package com.inice.dailynote;

import android.app.Activity;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DailyNote extends Activity {
	private TextView inputNum, dateView,note;
	private Button bkg;
	final static int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        bkg = (Button) findViewById(R.id.unitChange);
        inputNum = (EditText) findViewById(R.id.inputNum);
        dateView = (TextView) findViewById(R.id.dateView);
        note = (EditText) findViewById(R.id.note);
        
        setContentView(R.layout.main);
    }    
}