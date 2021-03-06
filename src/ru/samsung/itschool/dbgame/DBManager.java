package ru.samsung.itschool.dbgame;

import java.io.File;
import java.util.ArrayList;












import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	/*
	 * TABLES: ------- RESULTS SCORE INTEGER USER VARCHAR
	 */
	private Context context;
	private String DB_NAME = "game.db";

	private SQLiteDatabase db;

	private static DBManager dbManager;

	public static DBManager getInstance(Context context) {
		if (dbManager == null) {
			dbManager = new DBManager(context);
		}
		return dbManager;
	}

	private DBManager(Context context) {
		this.context = context;
		db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		createTablesIfNeedBe(); 
	}

	void addResult(String username, int score) {
		db.execSQL("INSERT INTO RESULTS VALUES ('" + username + "', " + score
				+ ");");
	}

	
	int sumscore()
	{
		String query = "SELECT SUM (SCORE) FROM RESULTS;";
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		String score = cursor.getString(0);
		return Integer.parseInt(score);
	
	}
	double count()
	{
		String query = "SELECT COUNT(*) FROM RESULTS;";
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		String score = cursor.getString(0);
		return Integer.parseInt(score);
	
	}
	int max()
	{
		String query = "SELECT MAX(SCORE) FROM RESULTS;";
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		String score = cursor.getString(0);
		return Integer.parseInt(score);
	
	}
	int players()
	{
		String query = "SELECT count(distinct USERNAME) FROM RESULTS;";
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		String score = cursor.getString(0);
		return Integer.parseInt(score);
	
	}
	double ch()
	{
		String query = "SELECT count(SCORE) FROM RESULTS where SCORE%2=0;";
		Cursor cursor = db.rawQuery(query, null);
		cursor.moveToFirst();
		String score = cursor.getString(0);
		return Integer.parseInt(score)/dbManager.count() *100;
	}


	
	
	ArrayList<Result> getAllResults() {

		ArrayList<Result> data = new ArrayList<Result>();
		Cursor cursor = db.rawQuery("SELECT SCORE, USERNAME FROM RESULTS;", null);
		boolean hasMoreData = cursor.moveToFirst();
		
		while (hasMoreData) {
			String name = cursor.getString(cursor.getColumnIndex("USERNAME"));
			int score = Integer.parseInt(cursor.getString(cursor
					.getColumnIndex("SCORE")));
			data.add(new Result(name, score));
			hasMoreData = cursor.moveToNext();
		}
		return data;
	}

	
	ArrayList<Result> get() {

		ArrayList<Result> data = new ArrayList<Result>();
		Cursor cursor = db.rawQuery("SELECT SCORE, USERNAME FROM RESULTS;", null);
		boolean hasMoreData = cursor.moveToFirst();
		
		while (hasMoreData) {
			String name = cursor.getString(cursor.getColumnIndex("USERNAME"));
			int score = Integer.parseInt(cursor.getString(cursor
					.getColumnIndex("SCORE")));
			data.add(new Result(name, score));
			hasMoreData = cursor.moveToNext();
		}
		return data;
	}


	
	
	int getPlayerIDByName(String username) {
		Cursor cursor = db.rawQuery("SELECT USERID FROM USERS WHERE NAME='"
				+ username + "'", null);
		if (!cursor.moveToFirst()) {
			return -1;
		}
		return cursor.getInt(cursor.getColumnIndex("USERID"));
	}

	void userUpdate(int userid, String username, String pic)
	{
		//�������� ������ ���������
		db.execSQL("UPDATE USERS SET NAME = 'NameStub' WHERE USERID = -1;");
	}
	
	String getUserName(int userid) {
		Cursor cursor = db.rawQuery("SELECT NAME FROM USERS WHERE USERID='"
				+ userid + "'", null);
		if (cursor.moveToFirst()) return cursor.getString(0);
		return "";
	}
	
	String getUserPic(int userid) {
		Cursor cursor = db.rawQuery("SELECT PIC FROM USERS WHERE USERID='"
				+ userid + "'", null);
		cursor.moveToFirst();
		//���� ��� ���� - ���������� ������ ������
		if (!cursor.moveToFirst() || cursor.isNull(0)) return "";  
		else return cursor.getString(0);
	}

	private void createTablesIfNeedBe() {
		db.execSQL("CREATE TABLE IF NOT EXISTS RESULTS (USERNAME TEXT, SCORE INTEGER);");
		db.execSQL("CREATE TABLE IF NOT EXISTS USERS(USERID INTEGER PRIMARY KEY ASC, NAME TEXT, PIC TEXT);");
	}

	private boolean dbExist() {
		File dbFile = context.getDatabasePath(DB_NAME);
		return dbFile.exists();
	}
	
	


}
