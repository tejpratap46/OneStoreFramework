package com.brainstrom.onestoreframework.list;

import com.brainstrom.onestoreframework.database.ShoppingListFrame;

import java.util.ArrayList;

/**
 * Created by Tej on 04-Jun-15.
 */
public class CreateList {

    public String CreateListWith(ArrayList<ShoppingListFrame> shoppingList) {
        String ret = "";
        for (int i = 0; i < shoppingList.size(); i++) {
            String id = Integer.toString(shoppingList.get(i).getID());
            String name = shoppingList.get(i).getName();
            String price = shoppingList.get(i).getPrice();
            String qty = Integer.toString(shoppingList.get(i).getQuantity());

            ret += "<id>" + id + "</id><name>" + name + "</name><cost>" + price + "</cost><quantity>" + qty + "</quantity>";
        }
        return ret;
    }
}
