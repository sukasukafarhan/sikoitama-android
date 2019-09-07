package com.fatkhun.agriculture.mvp.ui.fragmentswatering;

import com.fatkhun.agriculture.mvp.ui.base.MvpPresenter;
import com.fatkhun.agriculture.mvp.ui.fragmentshistory.HistoryFragmentMvpView;

public interface WateringFragmentMvpPresenter<V extends WateringFragmentMvpView>
        extends MvpPresenter<V> {
    void updateRelay(String pumpOn, String autoPumpOn);

    void updateRelayPump(String pumpOn);

    void updateRelayAutoPump(String autoPumpOn);

    void getRelay();

    void getUserAll();

    String getDeviceId();

    String getUserId();
}
