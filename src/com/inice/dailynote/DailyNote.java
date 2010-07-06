package com.inice.dailynote;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;


public class DailyNote extends Activity {
	private TextView inputNum, dateView,note;
	
	final static int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        inputNum = (EditText) findViewById(R.id.inputNum);
        dateView = (TextView) findViewById(R.id.dateView);
        note = (TextView) findViewById(R.id.note);
        setContentView(R.layout.main);
    }    
}