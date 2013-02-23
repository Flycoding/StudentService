package com.flyingh.studentservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText idText;
	private TextView resultView;
	private IBinder binder;
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = service;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		idText = (EditText) findViewById(R.id.id);
		resultView = (TextView) findViewById(R.id.result);
		bindService(new Intent(this, StudentService.class), conn, BIND_AUTO_CREATE);
	}

	public void query(View view) {
		String name = ((StudentBinder) binder).query(Integer.valueOf(idText.getText().toString()));
		if (name != null && !"".equals(name.trim())) {
			resultView.setText(name);
		} else {
			resultView.setText("no result");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(conn);
	}
}
