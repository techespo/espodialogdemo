package com.espoir.espoirdialogdemo;

import java.util.Calendar;

import com.espoir.espoirdialogdemo.DialogFragment.onSubmitListener;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateAndTimePickerActivity extends AppCompatActivity implements OnClickListener,onSubmitListener {
	// Widget GUI
		Button btnCalendar, btnTimePicker,btnFragmentDialog;
		EditText txtDate, txtTime;

		// Variable for storing current date and time
		private int mYear, mMonth, mDay, mHour, mMinute;
		private TextView mTextView;

		/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_date_and_time_picker);
		btnCalendar = (Button) findViewById(R.id.btnCalendar);
		btnTimePicker = (Button) findViewById(R.id.btnTimePicker);
		btnFragmentDialog = (Button) findViewById(R.id.btn_fragment);
		btnFragmentDialog.setOnClickListener(this);

		txtDate = (EditText) findViewById(R.id.txtDate);
		txtTime = (EditText) findViewById(R.id.txtTime);

		btnCalendar.setOnClickListener(this);
		btnTimePicker.setOnClickListener(this);
		
		mTextView = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public void onClick(View v) {
		if(v == btnFragmentDialog){
			 DialogFragment fragment1 = new DialogFragment();
			    fragment1.mListener = DateAndTimePickerActivity.this;
			    fragment1.text = mTextView.getText().toString();
			    fragment1.show(getSupportFragmentManager(), "");
		}

		if (v == btnCalendar) {

			// Process to get Current Date
			final Calendar c = Calendar.getInstance();
			mYear = c.get(Calendar.YEAR);
			mMonth = c.get(Calendar.MONTH);
			mDay = c.get(Calendar.DAY_OF_MONTH);

			// Launch Date Picker Dialog
			DatePickerDialog dpd = new DatePickerDialog(this,
					new DatePickerDialog.OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							// Display Selected date in textbox
							txtDate.setText(dayOfMonth + "-"
									+ (monthOfYear + 1) + "-" + year);

						}
					}, mYear, mMonth, mDay);
			dpd.show();
		}
		if (v == btnTimePicker) {

			// Process to get Current Time
			final Calendar c = Calendar.getInstance();
			mHour = c.get(Calendar.HOUR_OF_DAY);
			mMinute = c.get(Calendar.MINUTE);

			// Launch Time Picker Dialog
			TimePickerDialog tpd = new TimePickerDialog(this,
					new TimePickerDialog.OnTimeSetListener() {

						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							// Display Selected time in textbox
							txtTime.setText(hourOfDay + ":" + minute);
						}
					}, mHour, mMinute, true);
			tpd.show();
		}
	}
	 @Override  
	    public void setOnSubmitListener(String arg) {  
	     mTextView.setText(arg);  
	    }  
}