package com.flyingh.studentservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StudentService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new StudentBinder();
	}

}
