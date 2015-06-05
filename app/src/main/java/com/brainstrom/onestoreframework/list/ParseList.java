package com.brainstrom.onestoreframework.list;

import com.brainstrom.onestoreframework.database.ShoppingListFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Tej on 02-Jun-15.
 */
public class ParseList {

    public String listToHtmlTable(String list) {
        Document doc = Jsoup.parse(list);
        Elements ids = doc.getElementsByTag("id");
        Elements names = doc.getElementsByTag("name");
        Elements qtys = doc.getElementsByTag("quantity");
        Elements costs = doc.getElementsByTag("cost");

        int total = 0;
        String itemlist = "<style>table,th,td{border:1px solid black;border-collapse: collapse;}th,td{padding: 5px;}th{text-align: left;}</style>";
        itemlist = "<table style='width:100%;' >";
        itemlist = itemlist
                + "<tr><td>name</td><td>price</td><td>qty</td></tr>";
        for (int j = 0; j < ids.size(); j++) {
            itemlist = itemlist + "<tr>";
            itemlist = itemlist + "<td>" + names.get(j).text() + "</td>"
                    + "<td>" + costs.get(j).text() + "</td>" + "<td>"
                    + qtys.get(j).text() + "</td>";
            itemlist = itemlist + "</tr>";
            total = total
                    + (Integer.parseInt(costs.get(j).text()) * Integer
                    .parseInt(qtys.get(j).text()));
        }
        itemlist = itemlist + "<td>total : </td>" + "<td>"
                + Integer.toString(total) + "</td>" + "<td></td>";
        itemlist = itemlist + "</table>";
        return itemlist;
    }

    public ArrayList<ShoppingListFrame> parseList(String list) {
        ArrayList<ShoppingListFrame> items = new ArrayList<ShoppingListFrame>();
        Document doc = Jsoup.parse(list);
        Elements ids = doc.getElementsByTag("id");
        Elements names = doc.getElementsByTag("name");
        Elements qtys = doc.getElementsByTag("quantity");
        Elements costs = doc.getElementsByTag("cost");

        for (int i = 0; i < ids.size(); i++) {
            items.add(new ShoppingListFrame(Integer.parseInt(ids.get(i).text()),
                    names.get(i).text(),
                    costs.get(i).text(),
                    Integer.parseInt(qtys.get(i).text())));
        }
        return items;
    }
}
