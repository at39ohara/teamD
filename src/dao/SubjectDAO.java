package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public SubjectDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public SubjectDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                     jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Subject> listAllSubjects() throws SQLException {
        List<Subject> listSubject = new ArrayList<>();
        String sql = "SELECT * FROM subjects WHERE school_cd = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, "oom"); // ここで学校コードを設定
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String schoolCd = resultSet.getString("school_cd");
            String subjectCd = resultSet.getString("subject_cd");
            String subjectName = resultSet.getString("subject_name");

            Subject subject = new Subject(schoolCd, subjectCd, subjectName);
            listSubject.add(subject);
        }

        resultSet.close();
        statement.close();

        disconnect();
        return listSubject;
    }

	public List<Subject> filter(School school, String subjectCd, String subjectName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
