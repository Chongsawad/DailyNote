package com.inice.dailynote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class unitChange extends Activity {
	static final String[] wlist = new String[] { "Kilogram (kg.)", "Gram (g.)", "Pound (lb.)"};
	static final String[] dlist = new String[] { "Kilometer(km.)", "meter (m.)", "centimeter (cm.)", "inch (in.)", "foot (ft)", "mile (mi.)"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.unit_change);
		
		ListView lv = (ListView) findViewById(R.id.unitList1);
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.unit_list,wlist));
        lv.setTextFilterEnabled(true);
        
        ListView lv2 = (ListView) findViewById(R.id.unitList2);
        lv2.setAdapter(new ArrayAdapter<String>(this, R.layout.unit_list,dlist));
        lv2.setTextFilterEnabled(true);
        
		Button done = (Button) findViewById(R.id.unitDone);
		done.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
	}

}
