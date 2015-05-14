package com.brainstrom.onestoreframework.others;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;


public class IsSomethingOpen {

    public boolean isWifiEnabled(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifi.isWifiEnabled();
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter.isEnabled();
    }

    public int isRingVibrate(Context context) {
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        int ret = 0;
        switch (am.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                ret = 1;
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                ret = 2;
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                ret = 3;
                break;
        }
        return ret;
    }

    public static String batteryLevel(Context context)
    {
        Intent intent  = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int    level   = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int    scale   = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int    percent = (level*100)/scale;
        return String.valueOf(percent);
    }
}