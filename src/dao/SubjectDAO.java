package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

<<<<<<< HEAD
	public static List<Subject> filter(String school) throws Exception {
		List<Subject> subjects = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT * FROM subject WHERE school_cd = ?");
			statement.setString(1, school);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Subject subject = new Subject();
				subject.setSubjectCd(resultSet.getString("subject_cd"));
				subject.setSchoolCd(resultSet.getString("school_cd"));
				subject.setSubjectName(resultSet.getString("subject_name"));
				subjects.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // エラー処理は適切に行ってください
=======
    public static List<Subject> filter(String school) throws Exception {
        List<Subject> subjects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM subject WHERE school_cd = ?");
            statement.setString(1, school);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setSubjectCd(resultSet.getString("subject_cd"));
                subject.setSchoolCd(resultSet.getString("school_cd"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subjects.add(subject);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラー処理は適切に行ってください
>>>>>>> branch 'master' of https://github.com/at39ohara/teamD.git

			e.printStackTrace();
		} finally {
<<<<<<< HEAD
			// リソースの解放処理
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); // エラー処理は適切に行ってください
			}
		}
		return subjects;
	}
=======
            // リソースの解放処理
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // エラー処理は適切に行ってください
            }
        }
        return subjects;
    }

>>>>>>> branch 'master' of https://github.com/at39ohara/teamD.git

<<<<<<< HEAD
	public Subject get(String studentNo) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


=======
>>>>>>> branch 'master' of https://github.com/at39ohara/teamD.git
}