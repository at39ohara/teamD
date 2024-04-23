package bean;

import java.io.Serializable;

public class ClassScore implements Serializable {
	/**
	 * 学校:School
	 */
	private School school;

	/**
	 * クラス番号:String
	 */
	private String num;


	/**
	 * 点数:String
	 */
	private String point;

	/**
	 * 教科:String
	 */
	private String subject;

	/**
	 * ゲッター、セッター
	 */
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	public String Subject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}


}
