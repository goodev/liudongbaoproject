package com.hellogame;

import android.app.Activity;
import android.os.Bundle;

import com.box2dforandorid.R;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		initialize(new GearsGame(), false);
	}
}