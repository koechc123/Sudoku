package com.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class About extends Activity {
	TextView abtSudoku;
	Button backbutton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		abtSudoku = (TextView) findViewById(R.id.about_The_Game);
		// backbutton = (Button) findViewById(R.id.back);
		/*
		 * backbutton.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { // TODO Auto-generated
		 * method stub Intent newintent = new Intent(arg0.getContext(),
		 * Sudoku.class); startActivity(newintent);
		 * 
		 * 
		 * } });
		 */

	}
}
