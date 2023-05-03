package com.itheima.web;

import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet01")
public class SelectAllServlet01 extends HttpServlet {
    private CourseService service = new CourseService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 调用CourseService完成查询
        List<Course> courses = service.selectAll();

        //2. 存入request域中
        request.setAttribute("courses",courses);

        //3. 转发到course.jsp
        request.getRequestDispatcher("/cours.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
