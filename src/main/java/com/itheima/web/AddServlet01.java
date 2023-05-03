package com.itheima.web;

import com.itheima.pojo.Course;
import com.itheima.service.CourseService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Date;
import java.util.List;

@WebServlet("/addServlet01")
public class AddServlet01 extends HttpServlet {
    private CourseService service = new CourseService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String filename =null;
//        //处理POST请求的乱码问题
        request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory =new DiskFileItemFactory();
        String path=request.getRealPath("/imgs");
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024);
        ServletFileUpload upload=new ServletFileUpload(factory);
        InputStream in=null;
        byte[] buf=null;
        try{
            List<FileItem> list=(List<FileItem>) upload.parseRequest(request);
            for (FileItem item:list){
                String names = item.getFieldName();
               if (item.isFormField()){
                   String value =item.getString("UTF-8");
                   request.setAttribute(names,value);
               }else {
                   String value = item.getName();
                   String suffix = value.substring(value.lastIndexOf("."));
                   filename = "pro"+String.valueOf(((new Date()).getTime())%10000000)+suffix;
                   request.setAttribute(names, filename);

// 真正写到磁盘上
// 它抛出的异常 用exception 捕捉

// item.write( new File(path,filename) );//第三方提供的

// 手动写的，是将我电脑里的照片写在我服务器建立的upload文件夹下下面
                   OutputStream out = new FileOutputStream(new File(path,
                           filename));

                   in = item.getInputStream();

                   int length = 0;
                   buf = new byte[1024];//读1024个字节

                   System.out.println("获取上传文件的总共的容量：" + item.getSize());

// in.read(buf) 每次读到的数据存放在 buf 数组中
                   while ((length = in.read(buf)) != -1) {
// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
                       out.write(buf, 0, length);

                   }

                   in.close();
                   out.close();
               }
               }

            }
         catch (FileUploadException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            e.printStackTrace();
        }
//
//
        //1. 接收表单提交的数据，
        String name=request.getAttribute("name").toString();
//       String id=request.getAttribute("id").toString();
        String sid=request.getAttribute("sid").toString();
        String hours=request.getAttribute("hours").toString();
        Course course=new Course();
        course.setName(name);
        course.setHours(Integer.parseInt(hours));
//        course.setId(Integer.parseInt(id));
        course.setSid(Integer.parseInt(sid));
        course.setImagurl(filename);
//        String name = request.getParameter("name");
//        String id = request.getParameter("id");
//        String sid = request.getParameter("sid");
//        String hours = request.getParameter("hours");
//
//        Course course=new Course();
//        course.setName(name);
//        course.setHours(Integer.parseInt(hours));
//        course.setId(Integer.parseInt(id));
//        course.setSid(Integer.parseInt(sid));
        boolean flag=service.add(course);
        if(flag){
            service.add(course);
            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/selectAllServlet01").forward(request,response);
        }else {
            request.setAttribute("addCourse_msg","课程名已存在");



            //3. 转发到查询所有Servlet
            request.getRequestDispatcher("/selectAllServlet01").forward(request,response);
        }

        //2. 调用service 完成添加



        //3. 转发到查询所有Servlet
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}