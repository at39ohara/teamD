package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Teacher;

public class TeacherDAO extends DAO {

	public Teacher get(String id) throws Exception {
		Teacher teacher = new Teacher();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from teacher where teacher_id = ?");
			statement.setString(1, id);
			rSet = statement.executeQuery();
			teacher = getTeacherFromResultSet(rSet);
		} catch (Exception e) {
			throw e;
		} finally {
			closeResources(connection, statement, rSet);
		}

		return teacher;
	}

	public Teacher login(String id, String password) throws Exception {
		Teacher teacher = new Teacher();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from teacher where teacher_id = ? and password = ?");
			statement.setString(1, id);
			statement.setString(2, password);
			rSet = statement.executeQuery();
			teacher = getTeacherFromResultSet(rSet);
		} catch (Exception e) {
			throw e;
		} finally {
			closeResources(connection, statement, rSet);
		}

		return teacher;
	}

	private Teacher getTeacherFromResultSet(ResultSet rSet) throws SQLException {
		Teacher teacher = null;
		SchoolDAO schoolDao = new SchoolDAO();
		try {
			if (rSet.next()) {
				teacher = new Teacher();
				teacher.setId(rSet.getString("teacher_id"));
				teacher.setPassword(rSet.getString("password"));
				teacher.setName(rSet.getString("teacher_name"));
				teacher.setSchool(schoolDao.get(rSet.getString("school_cd")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return teacher;
	}

	private void closeResources(Connection connection, PreparedStatement statement, ResultSet rSet) {
		try {
			if (rSet != null) {
				rSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	private List<Teacher> postFilter(ResultSet rSet, School school) throws Exception {
		List<Teacher> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId("");
				teacher.setName(rSet.getString("teacher_name"));
				teacher.setPassword("");
				teacher.setAuthenticated(false);
				teacher.setSchool(school);
				list.add(teacher);
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return list;
	}

	public List<Teacher> filter(School school) throws Exception {
		List<Teacher> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		try {
			statement = connection.prepareStatement("select teacher_name from teacher where school_cd=?");
			statement.setString(1, school.getCd());
			rSet = statement.executeQuery();
			list = postFilter(rSet, school);
		} catch (Exception e) {
			throw e;
		} finally {
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
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
}