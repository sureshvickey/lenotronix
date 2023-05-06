package com.kubera.easyble.gatt.callback;


import com.kubera.easyble.BleDevice;

public interface BleConnectCallback extends BleCallback {
    int FAIL_CONNECT_TIMEOUT = 300;

    void onStart(boolean startConnectSuccess, String info, BleDevice device);

    void onConnected(BleDevice device);

    void onDisconnected(String info, int status, BleDevice device);
}
