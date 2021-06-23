package cn.sms;

import java.util.Objects;

public class Student {
    private String stuNum;
    private String stuName;
    private float math;
    private float chinese;

    public Student(String stuNum, String stuName, float math, float chinese) {
        setStuNum(stuNum);
        setStuName(stuName);
        setMath(math);
        setChinese(chinese);
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    @Override
    public boolean equals(Object o) {
        //判断对象是否相等，相等则直接返回true
        if (this == o) return true;
        //this!=obj
        if(o.getClass()==Student.class){
            Student student = (Student)o;
            return (student.getStuNum().equals(stuNum))&&(student.getStuName().equals(stuName))
                    &&(student.getMath()==math)&&(student.getChinese()==chinese);
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNum, stuName, math, chinese);
    }

    @Override
    public String toString() {
        return "学生信息：[学号：" + this.getStuNum() + ", 姓名：" + this.getStuName() +"]";
    }
}
