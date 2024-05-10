package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Teacher;
import dao.TeacherDAO;
import tool.Action;

public class TeacherListAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Teacher teacher = (Teacher) request.getSession().getAttribute("user");

        TeacherDAO teacherDao = new TeacherDAO();
        School school = teacher.getSchool();
        List<Teacher> teachers = teacherDao.filter(school);//filterを設定する
        System.out.println(teachers);
        request.setAttribute("teachers", teachers);
        System.out.println(teachers);

        request.getRequestDispatcher("teacher_list.jsp").forward(request, response);
    }
}