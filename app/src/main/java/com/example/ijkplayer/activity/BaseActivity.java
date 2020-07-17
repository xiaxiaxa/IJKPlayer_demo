/**
 * 
 */
package com.example.ijkplayer.activity;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

public abstract class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutRes());
		x.view().inject(this);
		init();
	}
	
	public abstract int getLayoutRes();
	public abstract void init();
}
