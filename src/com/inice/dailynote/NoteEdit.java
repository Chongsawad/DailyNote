package com.inice.dailynote;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoteEdit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_edit);
		final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
		
		Button btDone = (Button) findViewById(R.id.done);
		TextView date = (TextView) findViewById(R.id.dateString);
		DailyNote d = new DailyNote();
		date.setText(d.s);
		
		btDone.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
				finish();
			}
		});
	}

}
