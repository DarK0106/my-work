package com.test.java.aop;

public interface Memo {
	// 메모 쓰기
	void addMemo(String memo);
	
	// 메모 읽기
	String readMemo(String seq) throws Exception;
	
	// 메모 수정하기
	boolean edit(String seq, String memo);
	
	// 메모 삭제하기
	boolean del(String seq);
}
