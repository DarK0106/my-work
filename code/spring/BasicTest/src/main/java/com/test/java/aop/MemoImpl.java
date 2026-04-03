package com.test.java.aop;

public class MemoImpl implements Memo {

	@Override
	public void addMemo(String memo) {
//		Logger logger = new Logger();
//		logger.log();

		System.out.println("메모 쓰기: " + memo);
	}

	@Override
	public String readMemo(String seq) throws Exception {

//		Logger logger = new Logger();
//		logger.log();

		if (seq.equals("1"))
			return "안녕하세요.";
		else if (seq.equals("2"))
			return "엄준식입니다.";
		else if (seq.equals("3"))
			return "오늘 KFC 먹을까.";
		else
			throw new Exception("존재하지 않는 메모"); // 예외 던지기
	}

	@Override
	public boolean edit(String seq, String memo) {
//		Logger logger = new Logger();
//		logger.log();

		System.out.println("메모 수정하기: " + memo);
		return true;
	}

	@Override
	public boolean del(String seq) {
//		Logger logger = new Logger();
//		logger.log();

		System.out.println("메모 삭제하기: " + seq);
		return false;
	}

}
