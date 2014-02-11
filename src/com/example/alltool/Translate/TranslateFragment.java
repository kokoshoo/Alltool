package com.example.alltool.Translate;

import org.w3c.dom.Document;

import com.example.alltool.R;
import com.example.alltool.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TranslateFragment extends Fragment {

	
	WebView transWebView;
	EditText query;
	Button translateButton;
	String queryString,queryURL;
	Spinner websiteSpinner;
	View rootView;
	Translate translate;
	
	public TranslateFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.translate_fragment,
				container, false);
		
		transWebView = (WebView) rootView.findViewById(R.id.translation_webView);
		query = (EditText) rootView.findViewById(R.id.translation_query_box);
		translateButton = (Button) rootView.findViewById(R.id.translate_button);
		websiteSpinner = (Spinner) rootView.findViewById(R.id.translation_website_spinner);
		
		translate = new Translate();
		
		
		//queryURL+= queryString;
		
		
		translateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				translate.startTranslate(query,transWebView,websiteSpinner);
			}
		});
		
		
		return rootView;
	}
}