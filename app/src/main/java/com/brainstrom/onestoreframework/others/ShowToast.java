package com.brainstrom.onestoreframework.others;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowToast {

    private static int gravity = Gravity.CENTER;
    private static int offsetX = 0;
    private static int offsetY = 0;

    public void toast(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(gravity,offsetX,offsetY);
        toast.show();
    }

}
