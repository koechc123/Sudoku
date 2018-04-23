package com.example.sudoku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;

public class Sudoku extends Activity {
	Button aboutButton;
	Button continueButton;
	Button newGameButton;
	Button exitButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		aboutButton = (Button) findViewById(R.id.Button03);
		exitButton = (Button) findViewById(R.id.Button04);
		newGameButton = (Button) findViewById(R.id.Button02);
		continueButton = (Button) findViewById(R.id.Button01);
		continueButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startGame(Game.DIFFICULTY_CONTINUE);
			}
		});
		aboutButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View myobject) {
				Intent myintent = new Intent(myobject.getContext(), About.class);
				startActivity(myintent);
			}
		});
		exitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View ex) {
				// TODO Auto-generated method stub
				finish();

			}
		});
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openNewGameDialog();
			}
		});
	}

	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
				.setTitle("Difficulty (Ugumu)")
				.setItems(R.array.Difficulty,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(
									DialogInterface dialogInterface, int i) {
								// TODO Auto-generated method stub
								startGame(i);
							}
						}).show();
	}

	private static final String TAG = "SUDOKU";

	private void startGame(int i) {
		Log.d(TAG, "Clicked on " + i);
		Intent intent = new Intent(this, Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, i);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
			// more case statements come here

		}
		return false;
	}

	/*
	 * @Override protected void onResume(){ super.onResume(); Music.play(this,
	 * R.raw.Jotta); }
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Music.stop(this);
	}

}