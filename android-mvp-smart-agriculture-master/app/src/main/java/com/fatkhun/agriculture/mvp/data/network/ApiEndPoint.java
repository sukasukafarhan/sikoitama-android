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

package com.fatkhun.agriculture.mvp.data.network;


import com.fatkhun.agriculture.mvp.BuildConfig;
import com.fatkhun.agriculture.mvp.utils.AppConstants;

/**
 * Created by amitshekhar on 01/02/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "/588d15f5100000a8072d2945";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL
            + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";

    public static final String ENDPOINT_LOGIN_USER = AppConstants.BASE_URL_API
            + "users/login";

    public static final String ENDPOINT_REGISTER_USER = AppConstants.BASE_URL_API
            + "users/register";

    public static final String ENDPOINT_LOGOUT_USER = AppConstants.BASE_URL_API
            + "users/logout/";

    public static final String ENDPOINT_USER_ALL = AppConstants.BASE_URL_API
            + "users/index/all";

    public static final String ENDPOINT_DATA_ALL = AppConstants.BASE_URL_API
            + "data/index/all/";

    public static final String ENDPOINT_AVERAGE_DATA_ALL = AppConstants.BASE_URL_API
            + "data/average/all";

    public static final String ENDPOINT_RELAY_ON_OFF = AppConstants.BASE_URL_API
            + "relay/update/";

    public static final String ENDPOINT_RELAY_PUMP = AppConstants.BASE_URL_API
            + "relay/pump/";

    public static final String ENDPOINT_RELAY_AUTOPUMP = AppConstants.BASE_URL_API
            + "relay/autopump/";

    public static final String ENDPOINT_RELAY_CONFIG = AppConstants.BASE_URL_API
            + "relay/config/";

    public static final String ENDPOINT_DATA_KOI = AppConstants.BASE_URL_API
            + "pHJson";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
