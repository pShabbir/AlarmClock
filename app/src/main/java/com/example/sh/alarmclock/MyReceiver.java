package com.example.sh.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equalsIgnoreCase("com.alarm.shabbir")){
            Bundle b=intent.getExtras();
            String msg=b.getString("msg");
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
        }
    }
}
