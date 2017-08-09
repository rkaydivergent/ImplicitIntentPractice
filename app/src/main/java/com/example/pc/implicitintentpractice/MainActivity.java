package com.example.pc.implicitintentpractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.provider.MediaStore;

public class MainActivity extends AppCompatActivity {

    TextView websiteTxt, locationTxt, shareTxt, phoneTxt,smsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        websiteTxt = (TextView) findViewById(R.id.txt1);
        locationTxt = (TextView) findViewById(R.id.txt2);
        shareTxt = (TextView) findViewById(R.id.txt3);
        phoneTxt = (TextView) findViewById(R.id.txt4);
        smsTxt = (TextView) findViewById(R.id.txt5);
    }

    public	void	openWebsite(View view)	{
        String	url	=	websiteTxt.getText().toString();
        Uri webpage	=	Uri.parse(url);
        Intent intent	=	new	Intent(Intent.ACTION_VIEW,	webpage);
        if	(intent.resolveActivity(getPackageManager())	!=	null)
        {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this intent!");
        } }

    public	void	openLocation(View	view)	{
        String	loc	=	locationTxt.getText().toString();
        Uri	addressUri	=	Uri.parse("geo:0,0?q="	+	loc);
        Intent	intent	=	new	Intent(Intent.ACTION_VIEW,	addressUri);
       if	(intent.resolveActivity(getPackageManager())	!=	null)	{
           startActivity(intent);
       }
       else	{
           Log.d("ImplicitIntents",	"Can't	handle	this	intent!");
       } }

    public void shareText (View view) {
    String txt = shareTxt.getText().toString();
    String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
    public void makeCall(View view) {
        String number	=	phoneTxt.getText().toString();
        Uri phoneNo	=	Uri.parse("tel:"+number);
        Intent intent	=	new	Intent(Intent.ACTION_VIEW,	phoneNo);
        if	(intent.resolveActivity(getPackageManager())	!=	null)
        {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this intent!");
        } }
    public void sendMsg(View view) {
        String recipient	=	smsTxt.getText().toString();
        Uri phoneNo	=	Uri.parse("smsto:"+recipient);
        Intent intent	=	new	Intent(Intent.ACTION_VIEW,	phoneNo);
        if	(intent.resolveActivity(getPackageManager())	!=	null)
        {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this intent!");
        } }
    public void photoClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if	(intent.resolveActivity(getPackageManager())	!=	null)
        {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents","Can't handle this intent!");
        } }

    }


