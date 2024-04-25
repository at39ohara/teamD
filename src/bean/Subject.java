package bean;

public class Subject {
	    private String schoolCd;
	    private String subjectCd;
	    private String subjectName;

	    // コンストラクタ、ゲッター、セッターを実装
	    public Subject(String schoolCd, String subjectCd, String subjectName) {
	        this.schoolCd = schoolCd;
	        this.subjectCd = subjectCd;
	        this.subjectName = subjectName;
	    }

	    public String getSchoolCd() {
	        return schoolCd;
	    }

	    public void setSchoolCd(String schoolCd) {
	        this.schoolCd = schoolCd;
	    }

	    public String getSubjectCd() {
	        return subjectCd;
	    }

	    public void setSubjectCd(String subjectCd) {
	        this.subjectCd = subjectCd;
	    }

	    public String getSubjectName() {
	        return subjectName;
	    }

	    public void setSubjectName(String subjectName) {
	        this.subjectName = subjectName;
	    }
	}
