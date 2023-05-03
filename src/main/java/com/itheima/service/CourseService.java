package com.itheima.service;

import com.itheima.mapper.CourseMapper;
import com.itheima.pojo.Course;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourseService {
     static SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 查询所有
     * @return
     */
    public static List<Course> selectAll(){
//调用BrandMapper.selectAll()
//2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
//3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//4. 调用方法
        List<Course> courses = mapper.selectAll();
        sqlSession.close();
        return courses;
    }
    public boolean add(Course course){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
//3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//4. 调用方法
        Course u=mapper.selectByName(course.getName());
        if(u==null){
            mapper.add(course);
            sqlSession.commit();
        }

        sqlSession.close();
        return u==null;
    }
    public Course selectById(int id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
//3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//4. 调用方法
        Course course=mapper.selectById(id);

        sqlSession.close();
        return course;
    }
    public boolean update(Course course){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
//3. 获取BrandMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//4. 调用方法
        Course u=mapper.selectByName01(course);
        if(u==null){
            mapper.update(course);
            sqlSession.commit();
        }

        sqlSession.close();
        return u==null;

    }
    public void delete(int id){

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();

        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        //4. 调用方法

        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

}
