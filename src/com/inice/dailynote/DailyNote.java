package com.inice.dailynote;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DailyNote extends Activity {
	private Button bPrev, bNext, bToday;	
	private TextView inputNum, dateView,note;
	
	final static int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        inputNum = (EditText) findViewById(R.id.inputNum);
        bToday = (Button) findViewById(R.id.bToday);
        dateView = (TextView) findViewById(R.id.dateView);
        note = (TextView) findViewById(R.id.note);
        setContentView(R.layout.main);
    }    
}