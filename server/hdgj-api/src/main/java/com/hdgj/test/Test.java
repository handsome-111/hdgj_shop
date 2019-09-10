package com.hdgj.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Test {
	public static void main(String[] args) {
		LocalDateTime a = LocalDateTime.of(LocalDate.parse("2019-09-11"), "0:0:0");
		System.out.println(a);

	}
}
