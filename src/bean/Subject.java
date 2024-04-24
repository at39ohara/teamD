package bean;

import java.io.Serializable;

public class Subject implements Serializable {
	/**
	 * 学生番号:String
	 */
	private String no;

	/**
	 * 氏名:String
	 */
	private String name;

	/**
	 * 入学年度:int
	 */
	private int entYear;

	/**
	 * クラス番号:String
	 */
	private String classNum;

	/**
	 * 教科：String
	 */
	private String subject;

	/**
	 * 所属校:School
	 */
	private School school;

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

	public int getEntYear() {
		return entYear;
	}

	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getsubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}