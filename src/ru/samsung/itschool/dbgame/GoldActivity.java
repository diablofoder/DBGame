package ru.samsung.itschool.dbgame;

import java.util.ArrayList;


import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GoldActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gold);
		DBManager dbManager = DBManager.getInstance(this);
		ArrayList<Result> results = dbManager.getAllResults();
		ListView lv = (ListView) findViewById(R.id.Zero);
		ArrayAdapter<Result> adapter = 
				new ArrayAdapter<Result>(this, android.R.layout.simple_list_item_1, results) ;
		lv.setAdapter(adapter);
			
		
			
	}
	}
	
	

