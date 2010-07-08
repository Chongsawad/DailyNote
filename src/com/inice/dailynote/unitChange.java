package com.inice.dailynote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class unitChange extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.unit_change);
		
		
		Button done = (Button) findViewById(R.id.unitDone);
		done.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
		
	}

}
