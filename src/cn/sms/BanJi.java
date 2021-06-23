package cn.sms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BanJi {
    private String classId;
    private String className;
    private List<Student> stuList;

    public BanJi(String className) {
        this.setClassName(className);
        stuList = new ArrayList<Student>();
    }

    public BanJi(String classId, String className) {
        this.setClassId(classId);
        this.setClassName(className);
        stuList = new ArrayList<Student>();
    }

    public BanJi(String classId, String className, List<Student> stuList) {
        this.setClassId(classId);
        this.setClassName(className);
        this.setStuList(stuList);
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStuList() {
        return this.stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    /**
     * 将学生添加到班级
     *
     * @param stu
     */
    public void addStudent(Student stu) {
        //要排除重复添加的情况
        boolean flag = false;
        for (Student s1 : stuList) {
            if (s1.equals(stu)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("该学生已经存在于班级列表中，添加失败！");
        } else {
            stuList.add(stu);
        }

    }

    /**
     * 修改班级列表中的学生信息
     */
    public void updateStudent(String stuNum, Student student) {
        Student s1 = searchStudentByNum(stuNum);
        if (s1 == null) {
            System.out.println("没有找到学号为" + stuNum + "对应的学生信息！");
        } else {
            //先移除原来的信息，然后再重新添加
            this.getStuList().remove(s1);
            this.getStuList().add(student);
            System.out.println("修改成功！");
        }
    }

    /**
     * 通过学号查询学生在班级中是否存在
     *
     * @param stuNum
     * @return
     */
    public Student searchStudentByNum(String stuNum) {
        Student student = null;
        for (Student student1 : stuList) {
            if (student1.getStuNum().equals(stuNum)) {
                //如果相等就找到了
                student = student1;
                break;
            }
        }
        return student;

    }

    /**
     * 输入班级学生的语文成绩
     *
     * @param stuNum
     * @param score
     */
    public void insertChineseScore(String stuNum, float score) {
        Student student1 = searchStudentByNum(stuNum);
        if (student1 == null) {
            System.out.println("没有找到学号为" + stuNum + "对应的学生信息！");
        } else {
            this.getStuList().remove(student1);
            student1.setChinese(score);
            this.getStuList().add(student1);
            System.out.println("修改成功！");
        }

    }

    /**
     * 输入班级学生的数学成绩
     *
     * @param stuNum
     * @param score
     */
    public void insertMathScore(String stuNum, float score) {
        Student student1 = searchStudentByNum(stuNum);
        if (student1 == null) {
            System.out.println("没有找到学号为" + stuNum + "对应的学生信息！");
        } else {
            this.getStuList().remove(student1);
            student1.setMath(score);
            this.getStuList().add(student1);
            System.out.println("修改成功！");
        }
    }
    /**
     * 修改班级学生的语文成绩
     *
     * @param score
     */
    public void insertChineseScore(Student student, float score) {
        Student student1 = student;
        if (student1 == null) {
            System.out.println("没有找到学号为" + student1.getStuNum() + "对应的学生信息！");
        } else {
            student1.setChinese(score);
            System.out.println("修改成功！");
        }

    }

    /**
     * 输入班级学生的数学成绩
     * @param score
     */
    public void insertMathScore(Student student, float score) {
        Student student1 = student;
        if (student1 == null) {
            System.out.println("没有找到学号为" + student1.getStuNum() + "对应的学生信息！");
        } else {
            student1.setMath(score);
            System.out.println("修改成功！");
        }
    }

    /**
     * 删除学生信息
     *
     * @param stuNum
     */
    public void deleteStudent(String stuNum) {
        Student student = searchStudentByNum(stuNum);
        if (student != null) {
            this.getStuList().remove(student);
        } else {
            System.out.println("没有找到学号为" + stuNum + "对应的学生信息！");
        }
    }

    /**
     * 显示所有学生的信息（包括学号和姓名）
     */
    public void displayAllStudent() {
        System.out.println("班级列表中的所有学生为：");
        for (Student student : this.getStuList()) {
            System.out.println(student);
        }

    }

    /**
     * 求本班级的语文平均分
     */
    public float getChineseAverage() {
        float average = 0;
        int i = 0;
        float sum = 0;
        Iterator<Student> it = this.getStuList().listIterator();
        while (it.hasNext()) {
            i++;
            sum += it.next().getChinese();
        }
        average = sum / i;
        return average;
    }

    /**
     * 求本班级的数学平均分
     */
    public float getMathAverage() {
        float average = 0;
        int i = 0;
        float sum = 0;
        Iterator<Student> it = this.getStuList().listIterator();
        while (it.hasNext()) {
            i++;
            sum += it.next().getMath();
        }
        average = sum / i;
        return average;
    }

    @Override
    public String toString() {
        return "班级信息【" +
                "班级编号：" + classId +
                ", 班级名称：" + className + "】";
    }

    public boolean isStudentNull() {
        if (this.getStuList() == null || this.getStuList().size() == 0){
            return true;
        }else{
            return false;
        }
    }

}
