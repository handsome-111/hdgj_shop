package com.hdgj.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String str = "ADMIN,USER,ABB,CCC";
		String[] s = str.split(",");
		for(String st : s){
			System.out.println(st);
		}
	}
}
