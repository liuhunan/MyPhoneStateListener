package com.example.liuhunan.myphonestatelistener;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG="liuhunan";
    private static boolean incomingFlag=false;
    private static String incomingNumber=null;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive()");
        //如果是去电
     if(intent.getAction().equals(intent.ACTION_NEW_OUTGOING_CALL)){
         incomingFlag=false;
         String callNumber=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
         Log.i(TAG,"是否来电："+ incomingFlag+" 通话状态为呼出, "+" 号码为： "+callNumber );   }
     //如果是来电
     else{
         TelephonyManager telephonyManager= (TelephonyManager) context.getSystemService
                 (Service.TELEPHONY_SERVICE);

         switch (telephonyManager.getCallState()){
             case TelephonyManager.CALL_STATE_RINGING:
                 incomingFlag=true;
                 incomingNumber=intent.getStringExtra("incoming_number");
                 Log.i(TAG,"是否来电： "+ incomingFlag+" 通话状态为来电ing "+" 来电号码为： "+incomingNumber );
                 break;
             case TelephonyManager.CALL_STATE_OFFHOOK:
                 if(incomingFlag){

                     Log.i(TAG,"是否来电： "+ incomingFlag+" 通话状态为通话ing "+" 号码为： "+incomingNumber );
         }

                 break;
             case TelephonyManager.CALL_STATE_IDLE:
                 Log.i(TAG,"是否来电： "+ incomingFlag+" 通话状态为空闲状态 "+" 号码为： "+null );
                 break;

         }
     }
   }

}
