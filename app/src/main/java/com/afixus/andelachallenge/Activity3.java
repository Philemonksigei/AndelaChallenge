package com.afixus.andelachallenge;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.logging.LogManager;

public class Activity3 extends AppCompatActivity {

WebView webView;
String url= "https://andela.com/alc";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutalc);
        //WebView myWebView = (WebView) findViewById(R.id.webview);
       // myWebView.loadUrl("https://andela.com/alc/");


        // webview section, to display andela homepage
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //allowing for javascript pages to be loaded too
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url);
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            final AlertDialog.Builder mybuilder = new AlertDialog.Builder(Activity3.this);
            mybuilder.setMessage(R.string.notification_error_ssl_cert_invalid);

            //setting messagedialog for allowing the permission.
            mybuilder.setPositiveButton("Yes Proceed", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.proceed();
                }
            });
            //To stop from allowing the permission.
            mybuilder.setNegativeButton("No Stop!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    handler.cancel();
                }
            });
            //creating alert dialog
            final AlertDialog dialog = mybuilder.create();
            dialog.show();
        }
    }

    //for history functionality in case of any, while on web view
 public void  onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
