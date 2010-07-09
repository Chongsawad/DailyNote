package com.inice.dailynote;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class DailyNote extends Activity {
	public StringBuilder s;
	private final static int DATE_DIALOG_ID = 0;
	private static final int ACTIVITY_CREATE = 0;
	private final static int ACTIVITY_EDIT = 1;
    private int cDay, cMonth, cYear;
    private int vDay, vMonth, vYear;
	private Calendar c = Calendar.getInstance(); 
	private Button unitButton;
	private TextView newNote;
	private TextView bToday, bPrev, bNext;
	private TextView dateView;
	private NotesDbAdapter mDbHelper;
	private Cursor cursor;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        initDate();
        initEvent();     
        
        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();
        //getNote();
        cursor = mDbHelper.fetchAllNotes();
        startManagingCursor(cursor);
        
        
        //SimpleCursorAdapter s = new SimpleCursorAdapter(this, R.id.note, c, from, to);
        
    }
    
    private void initEvent(){
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
    
    private void initDate(){
    	dateView =  (TextView) findViewById(R.id.date);
        cDay = c.get(Calendar.DAY_OF_MONTH);
        cMonth = c.get(Calendar.MONTH);
        cYear = c.get(Calendar.YEAR);
        updateDate();
    }
    private void unitChange(){
    	Intent u = new Intent(this, unitChange.class);
    	startActivity(u);
    }
    
    private void createNewNote(){
    	Intent i = new Intent(this, NoteEdit.class);
    	i.putExtra(NotesDbAdapter.KEY_ROWID, 0);
        //i.putExtra(NotesDbAdapter.KEY_BODY, cursor.getString(
        //		cursor.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY)));
        startActivityForResult(i, ACTIVITY_CREATE);
    	//startActivity(i);
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
    
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//Bundle extras = data.getExtras();
		
        switch (requestCode) {
		case ACTIVITY_CREATE:
			//String body = extras.getString(NotesDbAdapter.KEY_BODY);
			//mDbHelper.createNote(body);

			break;
		case ACTIVITY_EDIT:
			
//			Long mRowId = extras.getLong(NotesDbAdapter.KEY_ROWID);
//			if(mRowId != null){
//				String editBody = extras.getString(NotesDbAdapter.KEY_BODY);
//				mDbHelper.updateNote(mRowId, editTitle, editBody);
//			}

			break;
        }
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