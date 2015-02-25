package ru.samsung.itschool.dbgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StatisticActivity extends Activity {
	
	private DBManager dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);
		dbManager = DBManager.getInstance(this);
		 int b = dbManager.sumscore();
		TextView restv = (TextView)this.findViewById(R.id.sum);
		restv.setText(b + "");
		
		
	}
	
}
