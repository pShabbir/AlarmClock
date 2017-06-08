package com.example.sh.alarmclock;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTime(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        PopTime popTime = new PopTime();
        popTime.show(fragmentManager,"This is PopTime");

    }
    public void displayTime(int hour, int minute){
        Toast.makeText(this,hour + ":"+minute,Toast.LENGTH_LONG).show();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);


        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        Intent intent= new Intent(this,MyReceiver.class);
        intent.setAction("com.alarm.shabbir");
        intent.putExtra("msg","Hello from alarm");

        PendingIntent pendingIntent= PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        //For repeating it daily
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        //For one day only
//        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

    }
}
