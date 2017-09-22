package com.eachwang.pg.bean;

/**
 * 正确问题
 * 
 * @author iswgr
 *
 */
public class OkTest {
	private String question;
	private String ok;

	public OkTest() {
		super();
	}

	public OkTest(String question, String ok) {
		super();
		this.question = question;
		this.ok = ok;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}
