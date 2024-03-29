package com.ramybelbesy.games.bubbleinvasion;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.ramybelbesy.games.bubbleinvasion.screens.MainMenuScreen;
import com.ramybelbesy.games.framework.Screen;
import com.ramybelbesy.games.framework.impl.GLGame;

public class DroidInvaders extends GLGame {
	boolean firstTimeCreate = true;

	@Override
	public Screen getStartScreen() {
		return new MainMenuScreen(this);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		if (firstTimeCreate) {
			Settings.load(getFileIO());
			Assets.load(this);
			firstTimeCreate = false;
		} else {
			Assets.reload();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (Settings.soundEnabled)
			Assets.music.pause();
	}
}