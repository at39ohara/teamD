package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Subject;

public class SubjectDAO extends DAO {
	/**
	 * getメソッド 学生番号を指定して学生インスタンスを1件取得する
	 *
	 * @param no:String
	 *            学生番号
	 * @return 学生クラスのインスタンス 存在しない場合はnull
	 * @throws Exception
	 */
	public Subject get(String no) throws Exception {
	    Subject subject = null;
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = getConnection();
	        statement = connection.prepareStatement("select * from subject where student_no=?");
	        statement.setString(1, no);
	        ResultSet rSet = statement.executeQuery();

	        if (rSet.next()) {
	            subject = new Subject();
	            subject.setNo(rSet.getString("student_no"));
	            subject.setEntYear(rSet.getInt("ent_year"));
	            subject.setClassNum(rSet.getString("class_num"));
	            subject.setSubject(rSet.getString("subject"));
	            // 学校コードから学校インスタンスを取得する処理を追加する必要があります
	            // subject.setSubject(subjectDao.get(rSet.getString("school_cd")));
	        }
	    } catch (SQLException e) {
	        throw new Exception("SQLエラーが発生しました", e);
	    } finally {
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException sqle) {
	                throw new Exception("PreparedStatementのクローズに失敗しました", sqle);
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException sqle) {
	                throw new Exception("Connectionのクローズに失敗しました", sqle);
	            }
	        }
	    }

	    return subject;
	}
}