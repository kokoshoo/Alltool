package com.example.alltool.Translate;

import com.example.alltool.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Spinner;

public class Translate {
	
	String queryString,queryURL,website;
	WebView transWebView;
	/*
	 * 1. Instantiate variables
	 * 2. Check which website was selected in the spinner
	 * 3. Check the language of the input
	 * 4. Load the page
	 */
	public void startTranslate(EditText query, WebView webView, Spinner websiteSpinner) {
		
		transWebView = webView;
		website = websiteSpinner.getSelectedItem().toString();
		queryString = query.getText().toString();
		
		//Base queryString on whichever website was chosen;
		if(website.equals("Naver")){
			queryURL = "http://m.endic.naver.com/search.nhn?query=" 
					+ queryString 
					+ "&searchOption=entryIdiom&preQuery=&forceRedirect=";
		}
		else if(website.equals("Google")){
			//Replace the whitespace with +, requirement for google translation
			changeWhitespace(queryString, "+");
			//Check the input for English or Korean
			if(isEnglish(queryString)){
				queryURL = "http://translate.google.com/m?hl=en&sl=en&tl=ko&ie=UTF-8&prev=_m&q=";
			}
			else{
				queryURL = "http://translate.google.com/m?hl=en&sl=ko&tl=en&ie=UTF-8&prev=_m&q=";
			}
			
		}
		else if(website.equals("Daum")){
			queryURL = "http://dic.daum.net/search.do?q="
					+queryString
					+"&dic=eng";
		}
		
		//Append the query to the URL and load the page
		queryURL+=queryString;
		
		transWebView.loadUrl(queryURL);
		
		//Loads the page in the app rather than a seperate browser
		transWebView.setWebViewClient(new WebViewClient());
		transWebView.requestFocus();
	}
	
	//Convert whitespace in a string to a character of choice
	public void changeWhitespace(String s, String change){
		s= s.replace(" ", change);
	}
	

	public boolean isEnglish(String input){
		
		//Use regex to check if the letters are in the alphabet
		if(input.matches("[A-za-z]+[[']?[A-Za-z]*[\\s]*]*")){
			return true;
		}
		else{
			return false;

		}
		
	}

}
