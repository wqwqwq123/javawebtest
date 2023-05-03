package com.itheima.web;

import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet01")
public class SelectByIdServlet01 extends HttpServlet {
    private CourseService service = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        //2. 调用service查询
        Course course = service.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("course",course);

        //4. 转发到update.jsp
        request.getRequestDispatcher("/update01.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}