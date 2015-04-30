package com.brainstrom.onestoreframework.nfc;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NdefMessage;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.brainstrom.onestoreframework.R;

import org.ndeftools.Message;
import org.ndeftools.MimeRecord;
import org.ndeftools.Record;
import org.ndeftools.externaltype.ExternalTypeRecord;
import org.ndeftools.externaltype.GenericExternalTypeRecord;
import org.ndeftools.util.activity.NfcBeamWriterActivity;
import org.ndeftools.wellknown.TextRecord;

import java.nio.charset.Charset;

public class NfcBeam extends NfcBeamWriterActivity {

    protected Message message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.beamer);

        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_actionbar)));

        setDetecting(true); // will start detecting NFC actions once onResume() is called.
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        Log.d("Create", "Create message to be beamed");

        // create message to be pushed, for example
        Message message = new Message();
        // add text record
        if (getIntent().hasExtra("id")) {
            message.add(new TextRecord(getIntent().getStringExtra("id")));
        } else {
        }
        // add 'my' external type record
        message.add(new GenericExternalTypeRecord("com.onestore", "atype", "My data".getBytes(Charset.forName("UTF-8"))));

        // encode to NdefMessage, will be pushed via beam (now!) (unless there is a collision)
        return message.getNdefMessage();
    }

    @Override
    protected void onNdefPushCompleted() {
        // make toast
        toast("Beamed");

        // vibrate
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE) ;
        vibe.vibrate(500);
    }

    public void toast(int id) {
        toast(getString(id));
    }

    public void toast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    /**
     *
     * NFC was found and enabled in settings, and push is enabled too.
     *
     */

    @Override
    protected void onNfcPushStateEnabled() {
        toast("NFC beam Available");
    }

    /**
     *
     * NFC was found and enabled in settings, but push is disabled
     *
     */


    @Override
    protected void onNfcPushStateDisabled() {
        toast("NFC beam Disabled");
    }

    /**
     *
     * NFC beam setting changed since last check. For example, the user enabled beam in the wireless settings.
     *
     */

    @Override
    protected void onNfcPushStateChange(boolean enabled) {
        if(enabled) {
            toast("NFC Beam Enabled");
        } else {
            toast("NFC Beam Disabled");
        }
    }

    /**
     *
     * NFC feature was found and is currently enabled
     *
     */

    @Override
    protected void onNfcStateEnabled() {
        toast("NFC available And Enabled");
    }

    /**
     *
     * NFC feature was found but is currently disabled
     *
     */

    @Override
    protected void onNfcStateDisabled() {
        toast("NFC Available But Disabled");
    }

    /**
     *
     * NFC setting changed since last check. For example, the user enabled NFC in the wireless settings.
     *
     */

    @Override
    protected void onNfcStateChange(boolean enabled) {
        if(enabled) {
            toast("NFC Enabled");
        } else {
            toast("NFC Disabled");
        }
    }

    /**
     *
     * This device does not have NFC hardware
     *
     */

    @Override
    protected void onNfcFeatureNotFound() {
        toast("NFC Unavailable");
        finish();
    }

    /**
     * An NDEF message was read and parsed
     *
     * @param message the message
     */

    @Override
    protected void readNdefMessage(Message message) {
        if(message.size() > 1) {
            toast("Read multi-record NDEF message.");
        } else {
            toast("Read single-record NDEF message.");
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
                // tvReader.setText(((TextRecord) record).getText());
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
        toast("Read empty message.");
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
        toast("Read non-NDEF message.");
    }

    @Override
    protected void onNfcFeatureFound() {
        super.onNfcFeatureFound();

        startPushing();
    }
}