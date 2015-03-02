package ru.samsung.itschool.dbgame;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ResulAdapter extends ArrayAdapter<Result> {
	Context context;
	ResulAdapter(Context context, ArrayList<Result> results)
	{
		super(context, R.layout.activity_gold, results);
		this.context = context;
	}
public View  getView (int position, View v, ViewGroup vg)
{
	View view = new View(context);
	LayoutInflator infl = (LayoutInflator) Context.getSystemService (Context.LAYOUT_INFLATER_SERVICE), conn, flags)
	View view = infl.inflance(R.layout.activity_gold, vg);
	return view;
}
}
