package cn.sms;

import java.util.Scanner;

public class TestDemo {
    /**
     * 学生的测试方法
     */
    public void testStudent() {
        Student s1 = new Student("s001", "张三", 100, 98);
        Student s2 = new Student("s002", "李四", 99, 96);
        Student s3 = new Student("s003", "王五", 97, 98);
        Student s4 = new Student("s003", "王五", 97, 98);
        System.out.println(s1);
        // 测试s1和s3这两个对象是否相等
        System.out.println("s1==s3?" + (s1.equals(s3)));
        System.out.println("s4==s3?" + (s4.equals(s3)));
        System.out.println(s3 == s4);

    }

    /**
     * 班级的测试方法
     */
    public void testBanJi() {
        Student s1 = new Student("s001", "张三", 100, 98);
        Student s2 = new Student("s002", "李四", 99, 96);
        Student s3 = new Student("s003", "王五", 97, 98);
        Student s4 = new Student("s003", "王五", 97, 98);

        BanJi banJi = new BanJi("主学生列表");
        banJi.addStudent(s1);
        banJi.addStudent(s2);
        banJi.addStudent(s3);
        banJi.addStudent(s4);

        banJi.displayAllStudent();
        // 通过学号查询学生信息
        Student student = banJi.searchStudentByNum("s003");
        if (student != null) {
            System.out.println("根据学号查询的学生信息为：");
            System.out.println(student);
        } else {
            System.out.println("该学生信息不存在！");
        }

        // 修改学生信息
        Student student1 = new Student("s005", "李狗蛋", 99, 99);
        banJi.updateStudent("s003", student1);
        banJi.displayAllStudent();
        // 修改班级学生的语文成绩
        banJi.insertChineseScore("s005", 78);
        // 修改班级学生的语文成绩
        banJi.insertMathScore("s005", 88);
        //计算班级语文平均分
        System.out.println("班级语文平均分：" + banJi.getChineseAverage());
        //计算班级数学平均分
        System.out.println("班级数学平均分：" + banJi.getMathAverage());


        // 删除学生信息
        banJi.deleteStudent("s005");
        banJi.displayAllStudent();

    }

    /**
     * 学校的测试方法
     */
    public void testSchool() {
        Student s1 = new Student("s001", "张三", 100, 98);
        Student s2 = new Student("s002", "李四", 99, 96);
        Student s3 = new Student("s003", "王五", 97, 98);
        Student s4 = new Student("s004", "aaa", 100, 98);
        Student s5 = new Student("s005", "bbb", 99, 96);
        Student s6 = new Student("s006", "ccc", 97, 98);
        Student s7 = new Student("s007", "ddd", 99, 98);
        Student s8 = new Student("s008", "eee", 88, 96);
        Student s9 = new Student("s009", "fff", 77, 98);
        BanJi mainbanji = new BanJi("主学生列表");
        // 将学生添加到主班级列表中
        mainbanji.addStudent(s1);
        mainbanji.addStudent(s2);
        mainbanji.addStudent(s3);
        mainbanji.addStudent(s4);
        mainbanji.addStudent(s5);
        mainbanji.addStudent(s6);
        mainbanji.addStudent(s7);
        mainbanji.addStudent(s8);
        mainbanji.addStudent(s9);
        // 定义一个新的班级列表，从主班级列表中添加学生进来
        BanJi yiban = new BanJi("一班");

        for (int i = 0; i < 6; i++) {
            yiban.addStudent(mainbanji.getStuList().get(i));
        }
/*
        yiban.addStudent(mainbanji.getStuList().get(0));
        yiban.addStudent(mainbanji.getStuList().get(1));
        yiban.addStudent(mainbanji.getStuList().get(2));
        yiban.addStudent(mainbanji.getStuList().get(3));
        yiban.addStudent(mainbanji.getStuList().get(4));
        yiban.addStudent(mainbanji.getStuList().get(5));
*/
        yiban.displayAllStudent();
        // 将两个班级列表添加到学校列表集合中
        School school = new School();
        school.addBanji(mainbanji);
        school.addBanji(yiban);
        school.displayBanJiName();
        // 根据班级列表名字查询班级列表信息，并显示所有学生
        BanJi b1 = school.searchClassByName("一班");
        b1.displayAllStudent();

        // 定义一个新的班级列表，从主班级列表中添加学生进来
        BanJi erban = new BanJi("二班");

        for (int i = 0; i < 4; i++) {
            erban.addStudent(mainbanji.getStuList().get(i));
        }
        school.addBanji(erban);
        System.out.println("对各班数学成绩按平均分进行由大到小排序");
        school.sortMathByAverage();
        // 删除班级信息
        System.out.println("删除前：");
        school.displayBanJiName();
        school.deleteBanji(yiban);
        System.out.println("删除后：");
        school.displayBanJiName();

    }

    /**
     * 主菜单
     */
    public void mainMenu() {
        System.out.println("***************************************");
        System.out.println("                 **主菜单**                      ");
        System.out.println("                 1--班级管理    ");
        System.out.println("                 2--学校管理    ");
        System.out.println("                 0--退出   ");
        System.out.println("***************************************");
    }

    /**
     * 学校管理菜单
     */
    public void schoolMenu() {
        System.out.println("*******************************************************");
        System.out.println("                 **学校管理**    ");
        System.out.println("                 1--创建班级    ");
        System.out.println("                 2--删除班级    ");
        System.out.println("                 3--通过班级名称查询班级信息    ");
        System.out.println("                 4--对各班语文成绩按平均分进行由大到小排序    ");
        System.out.println("                 5--对各班数学成绩按平均分进行由大到小排序    ");
        System.out.println("                 6--显示所有班级名称    ");
        System.out.println("                 9--返回上一级菜单   ");
        System.out.println("*******************************************************");
    }

    /**
     * 班级管理菜单
     */
    public void banJiMenu() {
        System.out.println("*******************************************************");
        System.out.println("                 **班级管理**    ");
        System.out.println("                 1--添加学生信息到主学生列表    ");
        System.out.println("                 2--添加学生信息到普通班级  ");
        System.out.println("                 3--通过学号查询学生信息  ");
        System.out.println("                 4--输入班级的语文成绩    ");
        System.out.println("                 5--输入班级的数学成绩    ");
        System.out.println("                 6--删除学生信息    ");
        System.out.println("                 7--显示所有学生信息    ");
        System.out.println("                 9--返回上一级菜单   ");
        System.out.println("*******************************************************");
    }

    /**
     * 主流程
     */
    public void test() {
        TestDemo td = new TestDemo();
        Scanner sc = new Scanner(System.in);
        int input = 0, input1 = 0, input2 = 0;
        //创建一个学校
        School school = new School();
        //创建主学生列表
        BanJi mainBanJi = new BanJi("主学生列表");
        //将主学生列表添加到学校
        school.addBanji(mainBanJi);
        BanJi YiBan = null;
        while (true) {
            td.mainMenu();
            System.out.println("请输入对应数字进行操作：");
            try {
                input = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("输入数据格式有误，不能有非数字的数据");
                sc.next();
                continue;
            }
            if (input == 0) {
                break;
            }
            switch (input) {
                case 1:
                    // 班级管理
                    while (true) {
                        td.banJiMenu();
                        System.out.println("请输入对应的数字对班级列表进行管理：");
                        try {
                            input1 = sc.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("输入数据格式有误，不能有非数字的数据");
                            sc.next();
                            continue;
                        }
                        if (input1 == 9)
                            break;
                        switch (input1) {
                            case 1:
                                System.out.println("添加学生信息到主学生列表");
                                System.out.println("请输入要添加的学生数量：");
                                int count = 0;
                                try {
                                    count = sc.nextInt();
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("输入数据格式有误，不能有非数字的数据");
                                    sc.next();
                                    continue;
                                }
                                for (int i = 1; i <= count; i++) {
                                    System.out.println("请输入第" + i + "个学生：");
                                    System.out.println("请输入学生的学号（例如s001）:");
                                    String strId = sc.next();
                                    System.out.println("请输入学生的姓名:");
                                    String strName = sc.next();
                                    //System.out.println("请输入语文成绩:");
                                    //float Chinese = sc.nextFloat();
                                    //System.out.println("请输入数学成绩:");
                                    //float Math = sc.nextFloat();
                                    //Student student = new Student(strId, strName, Math, Chinese);
                                    //创建学生类的对象
                                    Student student = new Student(strId, strName);
                                    mainBanJi.addStudent(student);
                                    System.out.println("输入成功");
                                    System.out.println(student);
                                }
                                System.out.println("主学生列表的学生信息为：");
                                mainBanJi.displayAllStudent();
                                break;
                            case 2:
                                System.out.println("添加学生信息到普通班级");
                                System.out.println("请输入要添加的班级名称：");
                                String sName = sc.next();
                                //根据名称判断班级是否在学校中存在
                                YiBan = school.searchClassByName(sName);
                                if (YiBan == null) {
                                    System.out.println("该班级不存在，请先将班级添加到学校中！");
                                } else {
                                    System.out.println("请输入要添加的学生的数量：");
                                    int count1 = 0;
                                    try {
                                        count1 = sc.nextInt();
                                    } catch (java.util.InputMismatchException e) {
                                        System.out.println("输入数据格式有误，不能有非数字的数据");
                                        sc.next();
                                        continue;
                                    }

                                    for (int i = 1; i <= count1; i++) {
                                        System.out.println("请输入第" + i + "个学生：");
                                        System.out.println("请输入学生学号：");
                                        String strId = sc.next();
                                        //首先判断该学号的学生是否在主班级列表存在
                                        Student student = mainBanJi.searchStudentByNum(strId);
                                        if (student == null) {
                                            //如果学生不存在，则创建新的添加，并且添加到主班级列表
                                            System.out.println("该学生在主班级列表不存在，继续输入学生的其他信息！");
                                            System.out.println("请输入学生姓名：");
                                            String strName = sc.next();
                                            //System.out.println("请输入语文成绩:");
                                            //float Chinese = sc.nextFloat();
                                            //System.out.println("请输入数学成绩:");
                                            //float Math = sc.nextFloat();
                                            //创建一个学生对象
                                            //Student student1 = new Student(strId, strName, Math, Chinese);
                                            Student student1 = new Student(strId, strName);
                                            YiBan.addStudent(student1);
                                            mainBanJi.addStudent(student1);
                                        } else {

                                            YiBan.addStudent(student);
                                        }
                                    }

                                    System.out.println("主学生列表:");
                                    mainBanJi.displayAllStudent();
                                    System.out.println("普通学生列表：");
                                    YiBan.displayAllStudent();
                                }
                                break;
                            case 3:
                                System.out.println("通过学号查询学生信息");
                                System.out.println("请输入要查询的班级名称：");
                                String strName1 = sc.next();
                                //查询班级是否存在
                                BanJi banJi = school.searchClassByName(strName1);
                                if (banJi == null) {
                                    System.out.println("该班级不存在！");
                                    break;
                                } else {
                                    System.out.println("请输入要查询的学生学号：");
                                    String strId1 = sc.next();
                                    Student s = banJi.searchStudentByNum(strId1);
                                    if (s == null) {
                                        System.out.println("该学生在班级列表" + strName1 + "中不存在！");
                                    } else {
                                        System.out.println("该学生的信息为：");
                                        System.out.println(s);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("输入班级的语文成绩");
                                System.out.println("请输入要查询的班级名称：");
                                String strName4 = sc.next();
                                //查询班级是否存在
                                BanJi banJicase4 = school.searchClassByName(strName4);
                                if (banJicase4 == null) {
                                    System.out.println("该班级不存在！");
                                    break;
                                } else {
                                    Float fc4 = 0f;
                                    for (Student s : banJicase4.getStuList()) {
                                        System.out.println(s + "语文：" + s.getChinese());
                                        System.out.println("请输入学生的语文成绩:");
                                        fc4 = sc.nextFloat();
                                        banJicase4.insertChineseScore(s, fc4);
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("输入班级的数学成绩");
                                System.out.println("请输入要查询的班级名称：");
                                String strName5 = sc.next();
                                //查询班级是否存在
                                BanJi banJicase5 = school.searchClassByName(strName5);
                                if (banJicase5 == null) {
                                    System.out.println("该班级不存在！");
                                    break;
                                } else {

                                    for (Student s : banJicase5.getStuList()) {
                                        System.out.println(s + "数学：" + s.getMath());
                                        System.out.println("请输入学生的数学成绩:");
                                        Float fc5 = sc.nextFloat();
                                        banJicase5.insertMathScore(s, fc5);

                                    }
                                }
                                break;
                            case 6:
                                System.out.println("删除学生信息");
                                System.out.println("输入班级的数学成绩");
                                System.out.println("请输入要查询的班级名称：");
                                String strName6 = sc.next();
                                //查询班级是否存在
                                BanJi banJicase6 = school.searchClassByName(strName6);
                                if (banJicase6 == null) {
                                    System.out.println("该班级不存在！");
                                    break;
                                } else {
                                    System.out.println("请输入要查询的学生学号：");
                                    String strId6 = sc.next();
                                    Student s = banJicase6.searchStudentByNum(strId6);
                                    if (s == null) {
                                        System.out.println("该学生在班级列表" + strName6 + "中不存在！");
                                    } else {
                                        banJicase6.deleteStudent(strId6);
                                    }

                                }

                                break;
                            case 7:
                                System.out.println("显示所有学生信息");
                                System.out.println("请输入要查询的班级名称：");
                                String strName7 = sc.next();
                                //查询班级是否存在
                                BanJi banJicase7 = school.searchClassByName(strName7);
                                if (banJicase7 == null) {
                                    System.out.println("该班级不存在！");
                                    break;
                                } else {
                                    banJicase7.displayAllStudent();
                                }
                                break;
                            default:
                                System.out.println("输入有误，没有对应的操作");
                                break;

                        }
                    }
                    break;
                case 2:
                    // 学校管理
                    while (true) {
                        td.schoolMenu();
                        System.out.println("请输入对应的数字对学校进行管理：");
                        try {
                            input2 = sc.nextInt();
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("输入数据格式有误，不能有非数字的数据");
                            sc.next();
                            continue;
                        }

                        if (input2 == 9)
                            break;
                        switch (input2) {
                            case 1:
                                System.out.println("创建班级");
                                System.out.println("输入要添加的班级ID：");
                                String classId = sc.next();
                                System.out.println("输入要添加的班级名称：");
                                String className = sc.next();
                                YiBan = new BanJi(classId, className);
                                school.addBanji(YiBan);
                                System.out.println("添加成功");
                                break;
                            case 2:
                                System.out.println("删除班级");
                                System.out.println("请输入要删除的班级名称：");
                                String className1 = sc.next();
                                if (className1.equals("主学生列表")) {
                                    System.out.println("主学生列表不能删除！");
                                    break;
                                }
                                //查询班级是否存在
                                BanJi banji1 = school.searchClassByName(className1);
                                if (banji1 == null) {
                                    System.out.println("该班级不存在！");
                                } else {
                                    //存在则删除
                                    school.deleteBanji(banji1);
                                    System.out.println("删除成功！");
                                }
                                break;
                            case 3:
                                System.out.println("通过班级名称查询班级信息");
                                System.out.println("请输入要查询的班级名称：");
                                String className2 = sc.next();
                                BanJi banJi2 = school.searchClassByName(className2);
                                if (banJi2 == null) {
                                    System.out.println("该班级不存在！");
                                } else {
                                    //显示该班级名称及其中的所有学生
                                    System.out.println("该班级存在！");
                                    System.out.println("该班级的名称为：" + className2);
                                    System.out.println(banJi2);
                                }
                                break;
                            case 4:
                                System.out.println("对各班语文成绩按平均分进行由大到小排序");
                                school.sortChineseByAverage();
                                break;
                            case 5:
                                System.out.println("对各班数学成绩按平均分进行由大到小排序");
                                school.sortMathByAverage();

                                break;
                            case 6:
                                System.out.println("显示所有班级名称");
                                school.displayBanJiName();
                                break;
                            default:
                                System.out.println("输入有误，没有对应的操作");
                                break;

                        }
                    }
                    break;
                default:
                    System.out.println("输入有误，没有对应的操作");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        TestDemo td = new TestDemo();
        //td.testStudent();
        //td.testBanJi();
        //td.testSchool();
        td.test();

    }


}
