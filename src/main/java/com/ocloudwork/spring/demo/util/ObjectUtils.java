package com.ocloudwork.spring.demo.util;

import java.util.Objects;

public class ObjectUtils {

	public static boolean equals(Object obj1, Object obj2) {
		return Objects.deepEquals(obj1, obj2);
	}

	public static boolean equals(String str1, String str2) {
		return Objects.equals(str1, str2);
	}
}
