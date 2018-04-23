package com.example.sudoku;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
	private static MediaPlayer mp = null;

	// Stop old song and start a new one
	private static void play(Context context, int resource) {
		stop(context);
		mp = MediaPlayer.create(context, resource);
		mp.setLooping(true);
		mp.start();
	}

	// stop the music
	public static void stop(Context context) {
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
	}
}
