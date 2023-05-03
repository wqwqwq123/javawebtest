package com.itheima.mapper;

import com.itheima.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    /*
    查询所有
     */
//    insert into  s_student values (null,#{name},#{hours},#{sid})
//    INSERT INTO s_student(id,name,hours,sid) SELECT null,#{name},#{hours FROM DUAL WHERE NOT EXISTS(SELECT name FROM user WHERE name=#{name});
    @Select("select * from s_student order by sid")
    List<Course> selectAll();
    @Insert("insert into s_student(id,name,hours,sid,imagurl) values (null,#{name},#{hours},#{sid},#{imagurl});")
    void add(Course course);
    @Select("select * from s_student where id = #{id}")
    Course selectById(int id);
    @Update("update s_student set name=#{name}, hours=#{hours},sid=#{sid}, imagurl=#{imagurl} where id=#{id} ")
    void update(Course course);
    @Delete("delete from s_student where id=#{id}")
    void deleteById(int id);
    @Select("select * from s_student where name=#{name}")
    Course selectByName(String name);
    @Select("select * from s_student where name=#{name} and id!=#{id}")
    Course selectByName01(Course course);
}
