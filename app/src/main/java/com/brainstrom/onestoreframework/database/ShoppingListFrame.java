package com.brainstrom.onestoreframework.database;

public class ShoppingListFrame {

	// private variables
	int _id;
	String _name;
	String _price;
	int _quantity;

	// Empty constructor
	public ShoppingListFrame() {

	}

	// constructor
	public ShoppingListFrame(int id, String name, String _price, int quantity) {
		this._id = id;
		this._name = name;
		this._price = _price;
		this._quantity = quantity;
	}

	// constructor
	public ShoppingListFrame(String name, String _price, int quantity) {
		this._name = name;
		this._price = _price;
		this._quantity = quantity;
	}

	// getting ID
	public int getID() {
		return this._id;
	}

	// setting id
	public void setID(int id) {
		this._id = id;
	}

	// getting name
	public String getName() {
		return this._name;
	}

	// setting name
	public void setName(String name) {
		this._name = name;
	}

	// getting price
	public String getPrice() {
		return this._price;
	}

	// setting price
	public void setPrice(String price) {
		this._price = price;
	}

	// getting price
	public int getQuantity() {
		return this._quantity;
	}

	// setting price
	public void setQuantity(int quantity) {
		this._quantity = quantity;
	}
}