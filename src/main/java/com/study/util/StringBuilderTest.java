package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {
		String str = "문자열1";
		str	+= "문자열2";
		str.replaceAll("문자열2", "문자열3");
		
		System.out.println(str);
		
		StringBuilder builder = new StringBuilder();
		StringBuffer buffer = new StringBuffer();
		// 스레드가 굳이 필요 없는 곳에서는 버퍼 사용
		// 스레드 사용 시 빌더 사용
	}

}
