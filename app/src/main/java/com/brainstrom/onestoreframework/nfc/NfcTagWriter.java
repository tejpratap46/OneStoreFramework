package com.brainstrom.onestoreframework.nfc;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

import com.brainstrom.onestoreframework.R;

import org.ndeftools.Message;
import org.ndeftools.externaltype.AndroidApplicationRecord;
import org.ndeftools.util.activity.NfcTagWriterActivity;
import org.ndeftools.wellknown.TextRecord;

import java.nio.charset.Charset;
import java.util.Locale;


/**
 *
 * Activity demonstrating the default implementation of the abstract tag writer activity.
 *
 * The activity uses a simple layout and displays some toast messages for various events.
 *
 * @author Thomas Rorvik Skjolberg
 *
 */

public class NfcTagWriter extends NfcTagWriterActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.writer);

        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_actionbar)));

        setDetecting(true);

    }

    /**
     *
     * Create an NDEF message to be written when a tag is within range.
     *
     * @return the message to be written
     */

    @Override
    protected NdefMessage createNdefMessage() {

        // compose our own message
        Message message = new Message();

        // add an Android Application Record so that this app is launches if a tag is scanned :-)
        AndroidApplicationRecord androidApplicationRecord = new AndroidApplicationRecord();
        androidApplicationRecord.setPackageName(getPlayIdentifier());
        message.add(androidApplicationRecord);

        // add a Text Record with the message which is entered
        EditText text = (EditText) findViewById(R.id.text);
        TextRecord textRecord = new TextRecord();
        textRecord.setText(text.getText().toString());
        textRecord.setEncoding(Charset.forName("UTF-8"));
        textRecord.setLocale(Locale.ENGLISH);
        message.add(textRecord);

        return message.getNdefMessage();
    }

    /**
     * Get Google Play application identifier
     *
     * @return
     */

    private String getPlayIdentifier() {
        PackageInfo pi;
        try {
            pi = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pi.applicationInfo.packageName;
        } catch (final NameNotFoundException e) {
            return getClass().getPackage().getName();
        }
    }

    /**
     *
     * Writing NDEF message to tag failed.
     *
     * @param e exception
     */

    @Override
    protected void writeNdefFailed(Exception e) {
        toast("Write Failed");
    }

    @Override
    public void writeNdefNotWritable() {
        toast("Non Writable Tag");
    }


    @Override
    public void writeNdefTooSmall(int required, int capacity) {
        toast("Tag size (" + capacity + ") is less then your data size (" + required + ")");
    }


    /**
     *
     * Unable to write this type of tag.
     *
     */

    @Override
    public void writeNdefCannotWriteTech() {
        toast("Cannot write tech or unformatted tag.");
    }

    /**
     *
     * Successfully wrote NDEF message to tag.
     *
     */

    @Override
    protected void writeNdefSuccess() {
        toast("Data Written Successfully");
    }

    /**
     *
     * NFC feature was found and is currently enabled
     *
     */

    @Override
    protected void onNfcStateEnabled() {
        toast("NFC Enabled");
    }

    /**
     *
     * NFC feature was found but is currently disabled
     *
     */

    @Override
    protected void onNfcStateDisabled() {
        toast("NFC Disabled");
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
        toast("NFC Not Found");
    }


    public void toast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}