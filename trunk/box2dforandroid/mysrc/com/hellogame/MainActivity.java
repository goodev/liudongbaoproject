package com.hellogame;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		initialize(new BodyTypesGame(), false);
	}
}