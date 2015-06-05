package com.brainstrom.onestoreframework.coupon;

import com.brainstrom.onestoreframework.database.ShoppingListFrame;

import java.util.ArrayList;

public class ApplyCoupon {

    public ArrayList<ShoppingListFrame> applyCouponToList(ArrayList<ShoppingListFrame> shoppingList, ArrayList<String> couponItems, int percentageDiscount) {
        ArrayList<ShoppingListFrame> shoppingListFrameArrayList = new ArrayList<ShoppingListFrame>();
        for (int i = 0; i < couponItems.size(); i++) {
            if (couponItems.contains(shoppingList.get(i).getID())) {
                int id = shoppingList.get(i).getID();
                String name = shoppingList.get(i).getName();
                int qty = shoppingList.get(i).getQuantity();
                String price = Integer.toString(Integer.parseInt(shoppingList.get(i).getPrice()) * (100 - percentageDiscount) / 100);
                shoppingListFrameArrayList.add(new ShoppingListFrame(id, name, price, qty));
            } else {
                shoppingListFrameArrayList.add(shoppingList.get(i));
            }
        }
        return shoppingListFrameArrayList;
    }
}