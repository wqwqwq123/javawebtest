package com.itheima.pojo;

public class Course {
    Integer id;
    Integer sid;
    Integer hours;
    String name;
    String imagurl;


    public String getImagurl() {
        return imagurl;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", sid=" + sid +
                ", hours=" + hours +
                ", name='" + name + '\'' +
                ", imagurl='" + imagurl + '\'' +
                '}';
    }

    //
    public void setImagurl(String imagurl) {
        this.imagurl = imagurl;
  }

    public Course(){}
    public Course(Integer id, Integer sid, Integer hours, String name){
        this.id =id;
        this.sid =sid;
        this.hours =hours;
        this.name =name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
