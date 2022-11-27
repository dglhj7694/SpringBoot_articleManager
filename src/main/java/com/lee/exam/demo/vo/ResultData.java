package com.lee.exam.demo.vo;

import lombok.Getter;

public class ResultData<T> {
	// 성공 - 1
	// 실패 - 0|
	@Getter
	private String resultCode;
	@Getter
	private String msg;
	@Getter
	private T data1;
	@Getter
	private String data1Name;

	private ResultData() {

	}

	public static <T> ResultData<T> from(String resultCode, String msg) {
		return from(resultCode, msg, null, null);
	}

	public static <T> ResultData<T> newData(ResultData rd, String data1Name, T data1) {
		return from(rd.getResultCode(), rd.getMsg(), data1Name, data1);
	}

	public static <T> ResultData<T> from(String resultCode, String msg, String data1Name, T data1) {
		ResultData<T> rd = new ResultData<T>();
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1Name = data1Name;
		rd.data1 = data1;
		return rd;
	}

	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}

	public boolean isFail() {
		return isSuccess() == false;
	}

}
