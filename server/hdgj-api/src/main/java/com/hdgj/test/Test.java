package com.hdgj.test;



import org.joda.time.DateTime;

import com.hdgj.entity.Product;

public class Test {
	public static void main(String[] args) throws Exception {
		DateTime time = new DateTime();
		System.out.println(time);
	}
	public static void aa(int a){
		System.out.println("a:" + a);
	}
		
		public static void bb(Object p){
		Product pp = (Product) p;
		pp.setId("1");
	}
}
