package com.example.alltool.Convert;

import com.example.alltool.R;
import com.example.alltool.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertFragment extends Fragment {
	
	/*Convert Money Variables*/
	EditText leftCurrencyText;
	TextView rightCurrencyText;
	Spinner leftCurrencySpinner,rightCurrencySpinner;
	Button calcMoneyButton,swapButton;
	
	/*Convert Distance Variables*/
	EditText leftDistanceText;
	TextView rightDistanceText;
	RadioButton kmToMiles, milesToKm;
	Button calcDistanceButton;
	
	/*Convert Weight Variables*/
	EditText leftWeightText;
	TextView rightWeightText;
	RadioButton kgToLbs,lbsToKg;
	Button calcWeightButton;
	
	/*Convert Temperature Variables*/
	EditText leftTemperatureText;
	TextView rightTemperatureText;
	RadioButton cToF,fToC;
	Button calcTemperatureButton;
	
	Calculate calculate;

	public ConvertFragment() {
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		View rootView = inflater.inflate(R.layout.convert_fragment,
				container, false);
		
		
		
		/* Initialize Convert Money Variables */
		leftCurrencyText = (EditText) rootView.findViewById(R.id.left_currency_text);
		rightCurrencyText = (TextView) rootView.findViewById(R.id.right_currency_text);
		leftCurrencySpinner = (Spinner) rootView.findViewById(R.id.currency_spinner_left);
		rightCurrencySpinner = (Spinner) rootView.findViewById(R.id.currency_spinner_right);
		calcMoneyButton = (Button) rootView.findViewById(R.id.convert_money_button);
		swapButton = (Button) rootView.findViewById(R.id.swap_button);
		
		calculate = new Calculate();
		

		rightCurrencySpinner.setSelection(2);
		
		// Add the Button Listeners
		calcMoneyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				calculate.calculateCurrency(leftCurrencyText,rightCurrencyText,
						leftCurrencySpinner,rightCurrencySpinner);
				
			}
		});
		
		swapButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// Change the left and right Spinner values
				int temp = leftCurrencySpinner.getSelectedItemPosition();
				
				leftCurrencySpinner.setSelection(rightCurrencySpinner.getSelectedItemPosition());
				rightCurrencySpinner.setSelection(temp);
				
				//Clear result value
				rightCurrencyText.setText("0");
			}
			
		});
		
		
		/* Initialize Convert Distance Variables */
		leftDistanceText = (EditText) rootView.findViewById(R.id.left_distance_text);
		rightDistanceText = (TextView) rootView.findViewById(R.id.right_distance_text);
		kmToMiles = (RadioButton) rootView.findViewById(R.id.km_to_miles_radioButton);
		milesToKm = (RadioButton) rootView.findViewById(R.id.miles_to_km_radioButton);
		calcDistanceButton = (Button) rootView.findViewById(R.id.convert_distance_button);
		
		//Tick the kmToMiles RadioButton by default
		kmToMiles.setChecked(true);
		
		//Add the button Listener
		calcDistanceButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Calculate the distance
				calculate.calculateDistance(leftDistanceText,rightDistanceText,
						kmToMiles);
				
			}
		});
		
		/* Initialize Convert Weight Variables */
		leftWeightText = (EditText) rootView.findViewById(R.id.left_weight_text);
		rightWeightText = (TextView) rootView.findViewById(R.id.right_weight_text);
		kgToLbs = (RadioButton) rootView.findViewById(R.id.kg_to_lbs_radioButton);
		lbsToKg = (RadioButton) rootView.findViewById(R.id.miles_to_km_radioButton);
		calcWeightButton = (Button) rootView.findViewById(R.id.convert_weight_button);
		
		//Tick the kmToMiles RadioButton by default
		kgToLbs.setChecked(true);
		
		//Add the button Listener
		calcWeightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Calculate the distance
				calculate.calculateWeight(leftWeightText,rightWeightText,
						kgToLbs);
				
			}
		});
		
		
		/* Initialize Convert Temperature Variables */
		leftTemperatureText = (EditText) rootView.findViewById(R.id.left_temperature_text);
		rightTemperatureText = (TextView) rootView.findViewById(R.id.right_temperature_text);
		cToF = (RadioButton) rootView.findViewById(R.id.c_to_f_radioButton);
		fToC = (RadioButton) rootView.findViewById(R.id.f_to_c_radioButton);
		calcTemperatureButton = (Button) rootView.findViewById(R.id.convert_temperature_button);
		
		//Tick the kmToMiles RadioButton by default
		cToF.setChecked(true);
		
		//Add the button Listener
		calcTemperatureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Calculate the distance
				calculate.calculateTemperature(leftTemperatureText,rightTemperatureText,
						cToF);
				
			}
		});
		
		
		return rootView;
	}
}