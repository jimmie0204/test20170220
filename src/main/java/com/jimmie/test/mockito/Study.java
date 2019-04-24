package com.jimmie.test.mockito;/**
 * Created by jimmie on 2018/1/15.
 */

/**
 * @author jimmie
 * @create 2018-01-15 下午7:02
 */

public class Study {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Study(){

    }
    public Study(Student student){
        this.student = student;
    }

    public void goToSchool(){
        student.setAge(12);
        System.out.println("ok，go");
    }

    public int learn(){
        System.out.println("ok，learning");
        return 1;
    }
}

