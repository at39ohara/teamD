package bean;

import java.io.Serializable;

public class Point implements Serializable {

	/**
	 * 学校コード:String
	 */
	private String cd;

	/**
	 * 科目コード:String
	 */
	private String subject_cd;


	/**
	 * 科目名:String
	 */
	private String subject_name;

	/**
	 * テスト:String
	 */
	private String test;

	/**
	 * ゲッター、セッター
	 */
	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getSubject_cd() {
		return subject_cd;
	}

	public void setSubjectCd(String Subject_cd) {
	}


	public String getSubject_Name() {
		return subject_name;
	}

	public void setSubjectName(String Subject_name) {
		this.subject_name = Subject_name;
	}
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
}

