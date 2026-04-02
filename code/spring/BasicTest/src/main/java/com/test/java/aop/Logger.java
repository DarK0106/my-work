package com.test.java.aop;

import java.util.Calendar;

public class Logger {
	public void log() {
		Calendar now = Calendar.getInstance();
		System.out.printf("[%tF %tT] 로그를 기록합니다.\r\n", now, now);
	}

	public void test() {

	}
}
