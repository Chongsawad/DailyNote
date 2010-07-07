package com.inice.dailynote;

import java.util.logging.Logger;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DailyNote extends Activity {
	private TextView inputNum, dateView,newNote;
	private Button bkg,dButton;
	private final static int DATE_DIALOG_ID = 0;
    private static final int ACTIVITY_CREATE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        bkg = (Button) findViewById(R.id.unitChange);
        inputNum = (EditText) findViewById(R.id.inputNum);
        dateView = (TextView) findViewById(R.id.dateView);
        
        setContentView(R.layout.main);
        
        newNote = (TextView) findViewById(R.id.note);
        
        newNote.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				createNewNote();
			}
		});
    }
    private void createNewNote(){
    	Intent i = new Intent(this, NoteEdit.class);
    	startActivity(i);
    }
}