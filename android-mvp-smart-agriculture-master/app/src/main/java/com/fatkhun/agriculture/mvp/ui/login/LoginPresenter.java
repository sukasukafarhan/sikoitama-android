/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.fatkhun.agriculture.mvp.ui.login;

import com.androidnetworking.error.ANError;

import com.fatkhun.agriculture.mvp.R;
import com.fatkhun.agriculture.mvp.data.DataManager;
import com.fatkhun.agriculture.mvp.data.network.model.LoginResponse;
import com.fatkhun.agriculture.mvp.ui.base.BasePresenter;
import com.fatkhun.agriculture.mvp.utils.AppConstants;
import com.fatkhun.agriculture.mvp.utils.CommonUtils;
import com.fatkhun.agriculture.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by janisharali on 27/01/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loginUser(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .loginUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();
                    if (loginResponse.getUser() == null && loginResponse.getStatus() == false){
                        getMvpView().showMessage(loginResponse.getMessage());
                    }else {
                        getDataManager().updateUserInfo(
                                loginResponse.getApiToken(),
                                loginResponse.getUser().getId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                loginResponse.getUser().getName(),
                                loginResponse.getUser().getEmail());

                        getMvpView().openMainActivity();
                        getMvpView().showMessage(loginResponse.getMessage());
                    }
                }, throwable ->  {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();
                    // handle the login error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        baseHandleError(anError);
                    }
                }));
    }

    @Override
    public String getOnline() {
        return AppConstants.ISONLINE;
    }
}
