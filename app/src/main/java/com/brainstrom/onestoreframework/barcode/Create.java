package com.brainstrom.onestoreframework.barcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.brainstrom.onestoreframework.extras.Contents;
import com.brainstrom.onestoreframework.extras.QRCodeEncoder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

/*
* This Class is used to create barcode and qrcode
 * @param
 * context : context of the calling class
 * Text :
*/

@SuppressLint("NewApi")
public class Create {
    public Bitmap createBarcode(Context context, String text,BarcodeFormat barcodeFormat) {
        Bitmap bitmap = null;
        try {
            // Find screen size
            WindowManager manager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension * 3 / 4;
            // Encode with a QR Code image
            QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(text, null,
                    Contents.Type.TEXT, barcodeFormat.toString(),
                    smallerDimension);
            bitmap = qrCodeEncoder.encodeAsBitmap();
        } catch (WriterException e) {
            Log.d("Error in Barcode", e.getMessage());
        }
        return bitmap;
    }
}