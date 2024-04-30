package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Point;
import bean.School;
import bean.Student;
import bean.Subject;

public class PointDAO extends DAO {

    String baseSql = "select * from test where ";

    public Point get(Student student, Subject subject, School school, int no) throws Exception {
        Point point = new Point();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            statement = connection.prepareStatement(baseSql + " student_no=? and subject_cd=? and school_cd=? and no=? ");
            statement.setString(1, student.getNo());
            statement.setString(2, subject.getCd());
            statement.setString(3, school.getCd());
            statement.setString(4, "" + no);
            rSet = statement.executeQuery();
            if (rSet.next()) {
                point.setClassNum(rSet.getString("class_num"));
                point.setNo(rSet.getInt("no"));
                point.setPoint(rSet.getInt("point"));
                point.setSchool(school);
                point.setStudent(student);
                point.setSubject(subject);
            } else {
                point = null;
            }
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
        return point;
    }

    private Point postFilter(ResultSet rSet, int entYear, School school) throws Exception {
        Point point = null;
        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        try {
            if (rSet.next()) { // ResultSetが空でないことを確認する
                point = new Point();
                point.setNo(rSet.getInt("no"));
                point.setClassNum(rSet.getString("class_num"));
                point.setPoint(rSet.getInt("point"));
                point.setSchool(school);
                point.setStudent(studentDAO.get(rSet.getString("student_no")));
                point.setSubject(subjectDAO.get(rSet.getString("subject_cd"), school));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーログの出力を行う場合、適切に処理を行います
        } finally {
            if (rSet != null) {
                try {
                    rSet.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    // エラーログの出力を行う場合、適切に処理を行います
                }
            }
        }
        return point;
    }

    public List<Point> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
        List<Point> list = new ArrayList<>();
        List<Student> slist = new ArrayList<>();
        StudentDAO stDao = new StudentDAO();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            slist = stDao.filter(school, entYear, classNum, true);
            for (Student st : slist) {
                statement = connection.prepareStatement(baseSql + " student_no=? and subject_cd=? and school_cd=? and no=? and class_num=? ");
                statement.setString(1, st.getNo());
                statement.setString(2, subject.getCd());
                statement.setString(3, school.getCd());
                statement.setString(4, "" + num);
                statement.setString(5, classNum);
                rSet = statement.executeQuery();
                Point result = postFilter(rSet, entYear, school);
                list.add(result);
            }
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

    public boolean save(List<Point> list) throws Exception {
        Connection connection = getConnection();
        int count = 0;

        try {
            for (Point point : list) {
                boolean flg = save(point, connection);
                if (flg) {
                    count++;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
        }

        return count == list.size();
    }

    public boolean save(Point point, Connection connection) throws Exception {
        boolean flg = false;
        PreparedStatement statement = null;

        try {
            Point old = get(point.getStudent(), point.getSubject(), point.getSchool(), point.getNo());
            if (old == null) {
                statement = connection.prepareStatement(
                        "insert into test(student_no, subject_cd, school_cd, no, point, class_num) values (?, ?, ?, ?, ?, ?)");
                statement.setString(1, point.getStudent().getNo());
                statement.setString(2, point.getSubject().getCd());
                statement.setString(3, point.getSchool().getCd());
                statement.setInt(4, point.getNo());
                statement.setInt(5, point.getPoint());
                statement.setString(6, point.getClassNum());
            } else {
                statement = connection.prepareStatement(
                        "update test set point=? where class_num=? and student_no=? and subject_cd=? and no = ?");
                statement.setInt(1, point.getPoint());
                statement.setString(2, point.getClassNum());
                statement.setString(3, point.getStudent().getNo());
                statement.setString(4, point.getSubject().getCd());
                statement.setInt(5, point.getNo());
            }
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
        }

        return flg;
    }

    public boolean delete(List<Point> list) throws Exception {
        Connection connection = getConnection();
        int count = 0;

        try {
            for (Point point : list) {
                boolean flg = delete(point, connection);
                if (flg) {
                    count++;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
        }

        return count == list.size();
    }

    public boolean delete(Point point, Connection connection) throws Exception {
        boolean flg = false;
        PreparedStatement statement = null;
        int count = 0;
        try {
            statement = connection.prepareStatement("delete from test where student_no=? and subject_no=?");
            statement.setString(1, point.getStudent().getNo());
            statement.setString(2, point.getSubject().getCd());
            count = statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
        }
        if (count > 0) {
            flg = true;
        }
        return flg;
    }
}