package com.inice.dailynote;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DailyNote extends Activity {
	public StringBuilder s;
	private TextView dateView,newNote;
	private TextView bToday, bPrev, bNext;
	private Button unitButton;
	private final static int DATE_DIALOG_ID = 0;
    private int cDay, cMonth, cYear;
    private int vDay, vMonth, vYear;
	private Calendar c;    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        c = Calendar.getInstance();
        
        cDay = c.get(Calendar.DAY_OF_MONTH);
        cMonth = c.get(Calendar.MONTH);
        cYear = c.get(Calendar.YEAR);
        
        dateView = (TextView) findViewById(R.id.date);
        
        updateDate();
        
        dateView.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});
        
        bToday = (TextView) findViewById(R.id.bToday);
        bToday.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				resetDate();
				updateDate();
			}
		});
        
        bNext = (TextView) findViewById(R.id.bNext);
        bNext.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				c.add(Calendar.DAY_OF_MONTH, 1);
				updateDate();
			}
		});
        
        bPrev = (TextView) findViewById(R.id.bPrev);
        bPrev.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				c.add(Calendar.DAY_OF_MONTH, -1);
				updateDate();
			}
		});
        
        
        newNote = (TextView) findViewById(R.id.note);
        newNote.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				createNewNote();
			}
		});
        
        unitButton = (Button) findViewById(R.id.unitChange);
        unitButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				unitChange();
			}
		});
    }
    private void unitChange(){
    	Intent u = new Intent(this, unitChange.class);
    	startActivity(u);
    }
    
    private void createNewNote(){
    	Intent i = new Intent(this, NoteEdit.class);
    	startActivity(i);
    }
    private void resetDate(){
    	vDay = cDay;
    	vMonth = cMonth;
    	vYear = cYear;
    	c.set(vYear, vMonth, vDay);
    }
    
    private void updateDate(){
    	vYear = c.get(Calendar.YEAR);
    	vMonth = c.get(Calendar.MONTH);
    	vDay = c.get(Calendar.DAY_OF_MONTH);
    	s = new StringBuilder().append(vMonth + "/" + vDay + "/"+  vYear);
    	dateView.setText(new StringBuilder().append(vMonth + "/" + vDay + "/"+  vYear));
    }
    
    @Override
    protected Dialog onCreateDialog(int id){
    	switch (id) {
		case DATE_DIALOG_ID:
			{
				return new DatePickerDialog(this,mDateList,vYear,vMonth,vDay);
			}
		}
    	return null;
    }
    
    private DatePickerDialog.OnDateSetListener mDateList = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(android.widget.DatePicker view, int year,
				int monthOfYear, int dayOfMonth) {
			vYear = year;
			vMonth = monthOfYear;
			vDay = dayOfMonth;
			c.set(vYear, vMonth, vDay);
			updateDate();
		}
	};
}