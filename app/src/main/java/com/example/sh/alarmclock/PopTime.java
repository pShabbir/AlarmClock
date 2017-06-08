package com.example.sh.alarmclock;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by Shabbir Hussain on 6/8/2017.
 */

public class PopTime extends DialogFragment implements View.OnClickListener {

    View view;
    TimePicker timePicker;
    //    DatePicker datePicker;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.poptime,null);
        timePicker = (TimePicker)view.findViewById(R.id.timePicker);
//            datePicker = (DatePicker)view.findViewById(R.id.datePicker);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        String s = timePicker.getHour() +":" + timePicker.getMinute();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
//        String s = datePicker.getYear() + "/"+datePicker.getMonth()+"/"+datePicker.getDayOfMonth();
        MainActivity mn = (MainActivity)getActivity();
        mn.displayTime(hour,minute);
    }
}
