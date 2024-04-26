package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

	// delete
	public boolean delete(Subject subject) throws Exception {
	    // コネクションを確立
	    Connection connection = getConnection();
	    // プリペアードステートメント
	    PreparedStatement statement = null;
	    // 実行件数
	    int count = 0;

	    try {
	        // プリペアードステートメントにUPDATE文をセット
	        statement = connection.prepareStatement("update subject set active=false where school_cd=? and cd=?");
	        // プリペアードステートメントにバインド
	        statement.setString(1, String.valueOf(subject.getSchool().getCd()));
	        statement.setString(2, subject.getCd());
	        // プリペアードステートメントを実行
	        count = statement.executeUpdate();
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        // プリペアードステートメントを閉じる
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	        // コネクションを閉じる
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	    }

	    if (count > 0) {
	        // 実行件数が1件以上ある場合
	        return true;
	    } else {
	        // 実行件数が0件の場合
	        return false;
	    }
	}

	public List<Subject> filter(School school) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Subject get(String studentNo) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}