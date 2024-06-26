package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDAO extends DAO {

	// get
	public Subject get(String cd, School school) throws Exception {
		// 科目インスタンスを初期化
		Subject subject = new Subject();
		// データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection
					.prepareStatement("select * from subject where school_cd=? and subject_cd=? and delete=false");
			statement.setString(1, school.getCd());
			statement.setString(2, cd);

			System.out.println("subjectdaoのcdが渡されているかどうか");
			System.out.println(cd);

			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()) {
				// リザルトセットが存在する場合
				// 科目インスタンスに検索結果をセット
				subject.setCd(rSet.getString("subject_cd"));
				subject.setName(rSet.getString("subject_name"));

				System.out.println("rSetがifかelseか　こっちならif");

			} else {
				// リザルトセットが存在しない場合
				// 科目インスタンスにnullをセット
				subject = null;

				System.out.println("rSetがifかelseか　こっちならelse");
			}
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

		return subject;
	}

	// filter
	public List<Subject> filter(School school) throws Exception {
		// リストを初期化
		List<Subject> list = new ArrayList<>();
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// リザルトセット
		ResultSet rSet = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from subject where school_cd=? and delete=false");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, school.getCd());
			// プリペアードステートメントを実行
			rSet = statement.executeQuery();
			// リストへの格納処理を実行
			while (rSet.next()) {
				Subject subject = new Subject();
				subject.setCd(rSet.getString("subject_cd"));
				subject.setName(rSet.getString("subject_name"));
				list.add(subject);
			}
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
		return list;
	}

	// save
	public boolean save(Subject subject, School school) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {
			// データベースから科目を取得
			Subject old = get(subject.getCd(), school);
			if (old == null) {
				// 科目が存在しなかった場合
				// プリペアードステートメントにINSERT文をセット
				statement = connection.prepareStatement(
						"insert into subject(school_cd, subject_cd, subject_name, delete) values (?, ?, ?, ?)");
				statement.setString(1, subject.getSchool().getCd());
				statement.setString(2, subject.getCd());
				statement.setString(3, subject.getName());
				statement.setBoolean(4, subject.isFlag()); // フラグの値をバインド

			} else {
				// 科目が存在した場合
				// プリペアードステートメントにUPDATE文をセット
				statement = connection
						.prepareStatement("UPDATE subject SET subject_name=? WHERE school_cd=? AND subject_cd=?");
				// プリペアードステートメントに値をバインド
				statement.setString(1, subject.getName());
				statement.setString(2, subject.getSchool().getCd());
				statement.setString(3, subject.getCd());
			}

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

		// 実行件数が1件以上ある場合にtrueを返す
		return count > 0;
	}

	// delete
	public boolean delete(Subject subject) throws Exception {
		// コネクションを確立
		Connection connection = getConnection();

		// プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {
			// プリペアードステートメントにDELETE文をセット
			statement = connection.prepareStatement("delete from subject where subject_cd = ?");
			// プリペアードステートメントにバインド
			statement.setString(1, subject.getCd());
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

	public List<Subject> filter(String schoolCd) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}