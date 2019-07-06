package com.finalhome.robin.reflection;

public class Helper {

	public String plain(String str) {
		return str;
	}
	
	public String reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1;i>=0;i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
