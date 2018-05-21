package com.mygdx.game;

import android.os.Bundle;
import android.util.DisplayMetrics;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	MyGdxGame myGdxGame;
    AndroidApplicationConfiguration config;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        config=new AndroidApplicationConfiguration();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
myGdxGame =new MyGdxGame(width);
		initialize(myGdxGame, config);
	}
}
