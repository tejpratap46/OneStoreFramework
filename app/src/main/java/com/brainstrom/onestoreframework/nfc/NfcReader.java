package com.brainstrom.onestoreframework.nfc;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.brainstrom.onestoreframework.R;

import org.ndeftools.Message;
import org.ndeftools.MimeRecord;
import org.ndeftools.Record;
import org.ndeftools.externaltype.ExternalTypeRecord;
import org.ndeftools.util.activity.NfcReaderActivity;
import org.ndeftools.wellknown.TextRecord;

public class NfcReader extends NfcReaderActivity {
    private static final String TAG = NfcReader.class.getName();

    protected Message message;
    TextView tvReader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nfc_reader);

        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_actionbar)));

        tvReader = (TextView) findViewById(R.id.tvNfcReader);

        // lets start detecting NDEF message using foreground mode
        setDetecting(true);
    }

    /**
     * An NDEF message was read and parsed. This method prints its contents to log and then shows its contents in the GUI.
     *
     * @param message the message
     */

    @Override
    public void readNdefMessage(Message message) {
        if(message.size() > 1) {
            toast("Reading Multiple Messages");
        } else {
            toast("Reading Single Message");
        }

        this.message = message;

        // process message

        // show in log
        // iterate through all records in message
        Log.d("NFC Found","Found " + message.size() + " NDEF records");

        for(int k = 0; k < message.size(); k++) {
            Record record = message.get(k);

            Log.d("Reading Rec","Record " + k + " type " + record.getClass().getSimpleName());

            // your own code here, for example:
            if(record instanceof MimeRecord) {
                // ..
            } else if(record instanceof ExternalTypeRecord) {
                // ..
            } else if(record instanceof TextRecord) {
                tvReader.setText(((TextRecord) record).getText());
            } else { // more else
                // ..
            }
        }
    }

    /**
     * An empty NDEF message was read.
     *
     */

    @Override
    protected void readEmptyNdefMessage() {
        toast("Read Empty Message");
    }

    /**
     *
     * Something was read via NFC, but it was not an NDEF message.
     *
     * Handling this situation is out of scope of this project.
     *
     */

    @Override
    protected void readNonNdefMessage() {
        toast("Reading NDEF Message");
    }

    /**
     *
     * NFC feature was found and is currently enabled
     *
     */

    @Override
    protected void onNfcStateEnabled() {
        toast("NFC Is Enabled");
    }

    /**
     *
     * NFC feature was found but is currently disabled
     *
     */

    @Override
    protected void onNfcStateDisabled() {
        toast("NFC Is Disabled");
    }

    /**
     *
     * NFC setting changed since last check. For example, the user enabled NFC in the wireless settings.
     *
     */

    @Override
    protected void onNfcStateChange(boolean enabled) {
        if(enabled) {
            toast("NFC Is Enabled");
        } else {
            toast("NFC Is Disabled");
        }
    }

    /**
     *
     * This device does not have NFC hardware
     *
     */

    @Override
    protected void onNfcFeatureNotFound() {
        toast("NFC Feature Is Found");
    }

    public void toast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

}