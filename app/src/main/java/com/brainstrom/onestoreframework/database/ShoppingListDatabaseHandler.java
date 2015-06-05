package com.brainstrom.onestoreframework.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListDatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "oneStoreDatabse";

	// shoppingLists table name
	private static final String TABLE_SHOPPING_LIST = "shopping_list";

	// shoppingLists Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PRICE = "price";
	private static final String KEY_QUANTITY = "quantity";

	public ShoppingListDatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_shoppingListS_TABLE = "CREATE TABLE "
				+ TABLE_SHOPPING_LIST + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
				+ KEY_NAME + " TEXT," + KEY_PRICE + " TEXT," + KEY_QUANTITY
				+ " INTEGER" + ")";
		db.execSQL(CREATE_shoppingListS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPPING_LIST);

		// Create tables again
		onCreate(db);
	}

	/*
	* Fire Query on database
	*/

	public List<ShoppingListFrame> queryShoppingList(String query) {
		List<ShoppingListFrame> shoppingListList = new ArrayList<ShoppingListFrame>();
		try {
			// Select All Query
			String selectQuery = query;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
                do {
                    ShoppingListFrame shoppingList = new ShoppingListFrame();
                    shoppingList.setID(Integer.parseInt(cursor.getString(0)));
                    shoppingList.setName(cursor.getString(1));
                    shoppingList.setPrice(cursor.getString(2));
                    shoppingList.setQuantity(Integer.parseInt(cursor.getString(3)));
                    // Adding shoppingList to list
                    shoppingListList.add(shoppingList);
                } while (cursor.moveToNext());
            }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		// return shoppingList list
		return shoppingListList;
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new shoppingList
	public void addShoppingList(ShoppingListFrame shoppingList) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ID, shoppingList.getID());
		values.put(KEY_NAME, shoppingList.getName()); // shoppingList Name
		values.put(KEY_PRICE, shoppingList.getPrice()); // shoppingList Price
		values.put(KEY_QUANTITY, shoppingList.getQuantity());

		// Inserting Row
		db.insert(TABLE_SHOPPING_LIST, null, values);
		db.close(); // Closing database connection
	}

	// Getting single shoppingList
	public ShoppingListFrame getShoppingList(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_SHOPPING_LIST, new String[] { KEY_ID,
				KEY_NAME, KEY_PRICE, KEY_QUANTITY }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		ShoppingListFrame shoppingList = new ShoppingListFrame(
				Integer.parseInt(cursor.getString(0)), cursor.getString(1),
				cursor.getString(2), Integer.parseInt(cursor.getString(3)));
		// return shoppingList
		return shoppingList;
	}

	// Getting All shoppingLists
	public List<ShoppingListFrame> getAllShoppingLists() {
		List<ShoppingListFrame> shoppingListList = new ArrayList<ShoppingListFrame>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SHOPPING_LIST;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ShoppingListFrame shoppingList = new ShoppingListFrame();
				shoppingList.setID(Integer.parseInt(cursor.getString(0)));
				shoppingList.setName(cursor.getString(1));
				shoppingList.setPrice(cursor.getString(2));
				shoppingList.setQuantity(Integer.parseInt(cursor.getString(3)));
				// Adding shoppingList to list
				shoppingListList.add(shoppingList);
			} while (cursor.moveToNext());
		}

		// return shoppingList list
		return shoppingListList;
	}

	// Updating single shoppingList
	public int updateShoppingList(ShoppingListFrame shoppingList) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, shoppingList.getName());
		values.put(KEY_PRICE, shoppingList.getPrice());
		values.put(KEY_QUANTITY, shoppingList.getQuantity());

		// updating row
		return db.update(TABLE_SHOPPING_LIST, values, KEY_ID + " = ?",
				new String[] { String.valueOf(shoppingList.getID()) });
	}

	// Update Quantity of Single Item

	public int UpdateQtyOfItem(ShoppingListFrame shoppingList){
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, shoppingList.getName());
		values.put(KEY_PRICE, shoppingList.getPrice());
		values.put(KEY_QUANTITY, shoppingList.getQuantity());

		// updating row
		return db.update(TABLE_SHOPPING_LIST, values, KEY_ID + " = ?",
				new String[] { String.valueOf(shoppingList.getID()) });
	}

	// Deleting single shoppingList
	public void deleteShoppingList(ShoppingListFrame shoppingList) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_SHOPPING_LIST, KEY_ID + " = ?",
				new String[] { String.valueOf(shoppingList.getID()) });
		db.close();
	}

	// Getting shoppingLists Count

	public int getShoppingListsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_SHOPPING_LIST;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int cnt = cursor.getCount();
		cursor.close();
		return cnt;
	}

	// check if item exists

	public boolean Exists(int _id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select 1 from " + TABLE_SHOPPING_LIST
				+ " where " + KEY_ID + " = " + _id, null);
		boolean exists = (cursor.getCount() > 0);
		cursor.close();
		return exists;
	}

	// delete all items in shopping list

	public void deleteAll() {
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL("delete from " + TABLE_SHOPPING_LIST);
		db.close();
	}

}