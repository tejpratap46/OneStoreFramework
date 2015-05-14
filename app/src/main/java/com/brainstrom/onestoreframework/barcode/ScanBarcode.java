package com.brainstrom.onestoreframework.barcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

import com.brainstrom.onestoreframework.R;

import net.sourceforge.zbar.Symbol;

public class ScanBarcode extends Activity implements View.OnClickListener {

    Button bScanBarcode;
    private static final int ZBAR_SCANNER_REQUEST = 0;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_barcode);
        bScanBarcode = (Button) findViewById(R.id.bScanBarcode);
        bScanBarcode.setOnClickListener(this);
    }

    /*
    *
    */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bScanBarcode:
                Intent zb = new Intent(getApplicationContext(),
                        ZBarScannerActivity.class);
                zb.putExtra(ZBarConstants.SCAN_MODES, new int[]{Symbol.UPCA, Symbol.UPCE, Symbol.QRCODE});
                startActivityForResult(zb, ZBAR_SCANNER_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ZBAR_SCANNER_REQUEST: {
                if (resultCode == RESULT_OK) {
                    String scannerData = data
                            .getStringExtra(ZBarConstants.SCAN_RESULT);
                    Log.d("Scanner Data", scannerData);
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "Camera unavailable",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        }
    }
}
