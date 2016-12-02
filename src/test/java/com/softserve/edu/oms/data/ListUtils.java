package com.softserve.edu.oms.data;

import java.util.List;

public final class ListUtils {

	private static volatile ListUtils instance = null;

	private ListUtils() {
	}

	public static ListUtils get() {
		if (instance == null) {
			synchronized (ListUtils.class) {
				if (instance == null) {
					instance = new ListUtils();
				}
			}
		}
		return instance;
	}

	public Object[][] toMultiArray(List<?> list) {
		Object[][] array = new Object[list.size()][1];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i);
		}
		return array;
	}

	public Object[][] toMultiArray(Object testData, List<?> list) {
		Object[][] array = new Object[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = testData;
			array[i][1] = list.get(i);
		}
		return array;
	}

}
