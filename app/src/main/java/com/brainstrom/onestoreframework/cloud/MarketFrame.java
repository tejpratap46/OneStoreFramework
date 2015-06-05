package com.brainstrom.onestoreframework.cloud;

public class MarketFrame {
    String itemid, itemname, itemprice, itemdiscreption, itemspecification, itemcategory, itembrand, quantity, imageurl, itemlocation, tags, date, totalsold;

    public MarketFrame(String itemid, String itemname, String itemprice, String itemdiscreption, String itemspecification, String itemcategory, String itembrand, String quantity, String imageurl, String itemlocation, String tags, String date, String totalsold) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemname = itemname;
        this.itemdiscreption = itemdiscreption;
        this.itemspecification = itemspecification;
        this.itemcategory = itemcategory;
        this.itembrand = itembrand;
        this.quantity = quantity;
        this.itemlocation = itemlocation;
        this.tags = tags;
        this.date = date;
        this.totalsold = totalsold;
    }

    public String getItemid() {
        return itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public String getItemdiscreption() {
        return itemdiscreption;
    }

    public String getItemspecification() {
        return itemspecification;
    }

    public String getItemcategory() {
        return itemcategory;
    }

    public String getItembrand() {
        return itembrand;
    }

    public String getDate() {
        return date;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getItemlocation() {
        return itemlocation;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTags() {
        return tags;
    }

    public String getTotalsold() {
        return totalsold;
    }
}
