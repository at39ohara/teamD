// Subject.java
package bean;

public class Subject implements java.io.Serializable {

    private String name;
    private School school;
    private String cd;

    public String getName() {
        return name;
    }

    public String getCd() {
        return cd;
    }

    public School getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
