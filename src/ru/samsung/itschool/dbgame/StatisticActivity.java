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
		 int a = dbManager.sumscore(); 
		TextView restv = (TextView)this.findViewById(R.id.sum);
		restv.setText("Сумма очков - " + a);
		 double b = dbManager.count(); 
		 int i = (int)b;
			TextView res = (TextView)this.findViewById(R.id.count);
			res.setText("Колличество сыграных игр - " + i);
			 int c = dbManager.max(); 
				TextView re = (TextView)this.findViewById(R.id.max);
				re.setText("Mаксимальный счёт - " + c);
				 int d = dbManager.players(); 
					TextView r = (TextView)this.findViewById(R.id.countplayers);
					r.setText("Всего игроков - " + d);
					 double e = dbManager.ch(); 
						TextView rot = (TextView)this.findViewById(R.id.che);
						rot.setText("Процент чётных чисел - " + e +"%");
						 double io =100 - dbManager.ch(); 
							TextView WOLF = (TextView)this.findViewById(R.id.cheg);
							WOLF.setText("Процент нечётных чисел - " + io +"%");
	}
}
