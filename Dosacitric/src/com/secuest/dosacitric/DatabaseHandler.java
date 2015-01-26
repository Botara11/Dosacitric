package com.secuest.dosacitric;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "android_api";

	// Login table name
	private static final String TABLE_LOGIN = "login";

	// Login Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_MARCA = "marca";
	private static final String KEY_MODELO = "modelo";
	private static final String KEY_DIAMETRO = "diametro";
	private static final String KEY_CAUDAL = "caudal";
	private static final String KEY_P6 = "p6";
	private static final String KEY_P7 = "p7";
	private static final String KEY_P8 = "p8";
	private static final String KEY_P9 = "p9";
	private static final String KEY_P10 = "p10";
	private static final String KEY_P11 = "p11";
	private static final String KEY_P12 = "p12";
	private static final String KEY_P13 = "p13";
	private static final String KEY_P14 = "p14";
	private static final String KEY_P15 = "p15";
	private static final String KEY_P16 = "p16";
	private static final String ACTIVE = "active";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_MARCA + " TEXT,"
				+ KEY_MODELO + " TEXT," + KEY_DIAMETRO + " DOUBLE,"
				+ KEY_CAUDAL + " DOUBLE," + KEY_P6 + " DOUBLE," + KEY_P7
				+ " DOUBLE," + KEY_P8 + " DOUBLE," + KEY_P9 + " DOUBLE,"
				+ KEY_P10 + " DOUBLE," + KEY_P11 + " DOUBLE," + KEY_P12
				+ " DOUBLE," + KEY_P13 + " DOUBLE," + KEY_P14 + " DOUBLE,"
				+ KEY_P15 + " DOUBLE," + KEY_P16 + " DOUBLE, " + ACTIVE + " INTEGER" + ")";
		db.execSQL(CREATE_LOGIN_TABLE);
		Log.d("", "CREADA BD");
	}

	// Upgrading database

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);

		// Create tables again
		onCreate(db);
	}

	/**
	 * Storing user details in database
	 **/
	public void addBoquilla(String marca, String modelo, Double diametro,
			Double caudal, Double p6, Double p7, Double p8, Double p9,
			Double p10, Double p11, Double p12, Double p13, Double p14,
			Double p15, Double p16, int active) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_MARCA, marca);
		values.put(KEY_MODELO, modelo);
		values.put(KEY_DIAMETRO, diametro);
		values.put(KEY_CAUDAL, caudal);
		values.put(KEY_P6, p6);
		values.put(KEY_P7, p7);
		values.put(KEY_P8, p8);
		values.put(KEY_P9, p9);
		values.put(KEY_P10, p10);
		values.put(KEY_P11, p11);
		values.put(KEY_P12, p12);
		values.put(KEY_P13, p13);
		values.put(KEY_P14, p14);
		values.put(KEY_P15, p15);
		values.put(KEY_P16, p16);
		values.put(ACTIVE, active);

		// Inserting Row
		db.insert(TABLE_LOGIN, null, values);
		db.close(); // Closing database connection
	}

	/**
	 * Getting user data from database
	 * */
	public ArrayList<String> getBoquillas(String marca, double presion1,
			double presion2, String KEY) {
		ArrayList<String> boquillas = new ArrayList<String>();

		String selectQuery = "SELECT * FROM " + TABLE_LOGIN + " WHERE "
				+ KEY_MARCA + "=='" + marca + "'" + " AND " + KEY
				+ " BETWEEN " + presion1 + " AND " + presion2;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// Move to first row
		cursor.moveToFirst();
		System.out.println("Hay " + cursor.getCount() + " filas");
		if (cursor.getCount() != 0) {
			boquillas.add(cursor.getString(2)); // GET MODELO
			//System.out.println("anadido "+cursor.getString(2) + " " + cursor.getString(3));

			while (cursor.moveToNext()) {
				boquillas.add(cursor.getString(2)); // REVISAR SI SE PASA
				//System.out.println("anadido "+cursor.getString(2) + " " + cursor.getString(3));
			}
			System.out.println(boquillas.size());
		}
		return boquillas;

	}

	/**
	 * Getting user data from database
	 * */
	public HashMap<String, String> getUserDetails() {
		HashMap<String, String> user = new HashMap<String, String>();
		String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// Move to first row
		cursor.moveToFirst();
		if (cursor.getCount() > 0) {
			user.put("name", cursor.getString(1));
			user.put("email", cursor.getString(2));
			user.put("password", cursor.getString(3));
			user.put("city", cursor.getString(4));
			user.put("image", cursor.getString(5));
			user.put("uid", cursor.getString(6));
			user.put("created_at", cursor.getString(7));
			user.put("updated_at", cursor.getString(8));
		}
		cursor.close();
		db.close();
		// return user
		return user;
	}

	/**
	 * Getting user login status return true if rows are there in table
	 * */
	public int getRowCount() {
		String countQuery = "SELECT  * FROM " + TABLE_LOGIN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int rowCount = cursor.getCount();
		db.close();
		cursor.close();

		// return row count
		return rowCount;
	}

	/**
	 * Re crate database Delete all tables and create them again
	 * */
	public void resetTables() {
		SQLiteDatabase db = this.getWritableDatabase();
		// Delete All Rows
		db.delete(TABLE_LOGIN, null, null);
		db.close();
	}
	/*
	 * public void setUserImage(String string) { SQLiteDatabase db =
	 * this.getWritableDatabase();
	 * 
	 * String strFilter = "uid='" + string + "'"; ContentValues args = new
	 * ContentValues(); args.put(KEY_IMG, "'" + string + "'");
	 * db.update(TABLE_LOGIN, args, strFilter, null); db.close(); Log.d("",
	 * "MODIFICADA BD");
	 * 
	 * }
	 * 
	 * public void setUserNameCity(String uid, String name, String city) {
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * 
	 * String strFilter = "uid='" + uid + "'"; ContentValues args = new
	 * ContentValues(); args.put(KEY_NAME, "'" + name + "'"); args.put(KEY_CITY,
	 * "'" + city + "'"); db.update(TABLE_LOGIN, args, strFilter, null);
	 * db.close(); Log.d("", "MODIFICADA namecity BD");
	 * 
	 * }
	 */

}