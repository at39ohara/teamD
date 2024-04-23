package bean;

import java.io.Serializable;

public class StudentScore implements Serializable {
	/**
	 * 学生番号:String
	 */
	private String no;

	/**
	 * 氏名:String
	 */
	private String name;
	/**
	 * 教科:String
	 */
	private String subject;

	/**
	 * 教科:String
	 */
	private String point;

	/**
	 * ゲッター、セッター
	 */
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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