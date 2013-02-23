package com.flyingh.studentservice;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Binder;

public class StudentBinder extends Binder {
	@SuppressLint("UseSparseArrays")
	private static final Map<Integer, String> map = new HashMap<Integer, String>();
	static {
		map.put(1, "zhangsan");
		map.put(2, "lisi");
		map.put(3, "wangwu");
		map.put(4, "zhaoliu");
		map.put(5, "sunqi");
	}

	public String query(int id) {
		return map.get(id);
	}
}
