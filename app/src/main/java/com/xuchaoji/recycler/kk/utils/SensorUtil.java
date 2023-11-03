package com.xuchaoji.recycler.kk.utils;

import android.content.Context;
import android.os.Vibrator;

public class SensorUtil {
    private static final String TAG = "SensorUtil";

    public static void vibrate(Context context, long vibrateMs) {
        if (context == null || vibrateMs <= 0) {
            return;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(vibrateMs);
    }
}
