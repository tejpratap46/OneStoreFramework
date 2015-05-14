package com.brainstrom.onestoreframework.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class User {
    public static String SHARED_STORAGE_NAME = "one_store_framework";
    public static int SHARED_STORAGE_PRIVACY = 0; // 0: private, 1: public
    public static String PREFERENCE_USER_NAME = "username";
    public static String PREFERENCE_BANK_ID = "bank_id";
    public static String PREFERENCE_EMAIL_ID = "email_id";
    public static String PREFERENCE_TOTAL_PURCHASE = "total_purchase";
    public static String PREFERENCE_LAST_LIST_ID = "last_list_id";
    public static String PREFERENCE_LOYALTY_LEVEL = "loyalty_level";

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceUserName(Context context, String Username){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_USER_NAME,Username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_USER_NAME,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceBankId(Context context, String BankId){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_BANK_ID,BankId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_BANK_ID,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceEmailId(Context context, String EmailId){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_EMAIL_ID,EmailId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_EMAIL_ID,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceTotalPurchase(Context context, String TotalPurchase){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_TOTAL_PURCHASE,TotalPurchase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_TOTAL_PURCHASE,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceLastListId(Context context, String LastListId){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_LAST_LIST_ID,LastListId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_LAST_LIST_ID,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String setPreferenceLoyaltyLevel(Context context, String LoyaltyLevel){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        try {
            Editor edit = preferences.edit();
            edit.putString(PREFERENCE_LOYALTY_LEVEL,LoyaltyLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preferences.getString(PREFERENCE_LOYALTY_LEVEL,"not updated");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceUserName(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_USER_NAME,"not found");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceBankId(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_BANK_ID,"not found");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceEmailId(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_EMAIL_ID,"not found");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceTotalPurchase(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_TOTAL_PURCHASE,"not found");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceLastListId(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_LAST_LIST_ID,"not found");
    }

    /*
    * Set Username Of User For Application
    * */
    public String getPreferenceLoyaltyLevel(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_STORAGE_NAME,SHARED_STORAGE_PRIVACY);
        return preferences.getString(PREFERENCE_LOYALTY_LEVEL,"not found");
    }
}
