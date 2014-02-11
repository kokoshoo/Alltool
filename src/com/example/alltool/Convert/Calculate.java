package com.example.alltool.Convert;

import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Calculate {

	
	

	public void calculateCurrency(EditText leftCurrencyText, TextView rightCurrencyText,
			Spinner leftCurrencySpinner, Spinner rightCurrencySpinner) {
		
		// Instantiate values
		double amount = 0;
		String leftSpinner = leftCurrencySpinner.getSelectedItem().toString();
		String rightSpinner = rightCurrencySpinner.getSelectedItem().toString();
		
		// Change the leftCurrencyText to double
		try{
			amount = Double.parseDouble(leftCurrencyText.getText().toString());
		}
		catch(Exception args){
			amount = 0;
		}
		
		double result = 0;
		
		//Calculate money based on conversion rate
		//1USD = 1062.80WON
		//1USD = .62BPS
		//1GBP = 1711.75WON
		
		
		if(leftSpinner.equals("United States")){
			if(rightSpinner.equals("United States")){
				result = amount;
			}
			else if(rightSpinner.equals("Korea")){
				result = amount * 1062.80;
			}
			else if(rightSpinner.equals("United Kingdom")){
				result = amount * .62;
			}
		}
		else if(leftSpinner.equals("Korea")){
			if(rightSpinner.equals("United States")){
				result = amount/1062.80;
			}
			else if(rightSpinner.equals("Korea")){
				result = amount;
			}
			else if(rightSpinner.equals("United Kingdom")){
				result = amount/1711.75;
			}
		}
		if(leftSpinner.equals("United Kingdom")){
			if(rightSpinner.equals("United States")){
				result = amount / .62;
			}
			else if(rightSpinner.equals("Korea")){
				result = amount * 1711.75;
			}
			else if(rightSpinner.equals("United Kingdom")){
				result = amount;
			}
		}
		
		
		
		//Log.d("WWWWWWWWWWWWWWWWWWWWW",String.format("%.02f",result));
		rightCurrencyText.setText(String.format("%.02f",result));

	}

	public void calculateDistance(EditText leftDistanceText,
			TextView rightDistanceText, RadioButton kmToMiles) {
		// Instantiate
		double amount = 0;
		boolean kmChecked = kmToMiles.isChecked();
		
		try{
			amount = Double.parseDouble(leftDistanceText.getText().toString());
		}
		catch(Exception args){
			amount = 0;
		}
		
		double result = 0;
		
		if(kmChecked){
			result = amount*0.62137;
		}
		else{
			result = amount/0.62137;
		}
		
		rightDistanceText.setText(String.format("%.04f", result));
		
		
		
	}

	public void calculateWeight(EditText leftWeightText,
			TextView rightWeightText, RadioButton kgToLbs) {
		// Instantiate
		double amount = 0;
		boolean kgChecked = kgToLbs.isChecked();
		
		try{
			amount = Double.parseDouble(leftWeightText.getText().toString());
		}
		catch(Exception args){
			amount = 0;
		}
		
		double result = 0;
		
		if(kgChecked){
			result = amount*2.2046;
		}
		else{
			result = amount/2.2046;
		}
		
		rightWeightText.setText(String.format("%.04f", result));
		
	}

	public void calculateTemperature(EditText leftTemperatureText,
			TextView rightTemperatureText, RadioButton cToF) {
		// Instantiate
		double amount = 0;
		boolean cChecked = cToF.isChecked();
		
		try{
			amount = Double.parseDouble(leftTemperatureText.getText().toString());
		}
		catch(Exception args){
			amount = 0;
		}
		
		double result = 0;
		
		if(cChecked){
			result = (amount*1.8) + 32;
		}
		else{
			result = (amount-32) / 1.8;
		}
		
		rightTemperatureText.setText(String.format("%.02f", result));
	}
	
}
