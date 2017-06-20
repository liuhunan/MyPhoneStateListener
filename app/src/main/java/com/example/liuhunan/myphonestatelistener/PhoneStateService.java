package com.example.liuhunan.myphonestatelistener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by liuhunan on 2017/6/19.
 */
public class PhoneStateService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
