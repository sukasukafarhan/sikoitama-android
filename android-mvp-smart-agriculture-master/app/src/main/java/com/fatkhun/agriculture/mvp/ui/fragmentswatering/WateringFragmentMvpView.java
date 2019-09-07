package com.fatkhun.agriculture.mvp.ui.fragmentswatering;

import com.fatkhun.agriculture.mvp.data.network.model.RelayResponse;
import com.fatkhun.agriculture.mvp.data.network.model.User;
import com.fatkhun.agriculture.mvp.ui.base.MvpView;

import java.util.List;

public interface WateringFragmentMvpView extends MvpView {
    void setupUpdateRelay(RelayResponse relayResponse);
    void setupUpdateRelayPump(RelayResponse relayResponse);
    void setupUpdateRelayAutoPump(RelayResponse relayResponse);
    void getRelays(RelayResponse relayResponse);
    void validateRelayState(String deviceId);
    void setRelayState(PumpState pumpState);
    void updateUser(String userList);
}
