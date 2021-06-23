package cn.sms;

import java.util.*;

public class School {
    Map<String, BanJi> schoolMap;

    public School() {
        schoolMap = new HashMap<String, BanJi>();
    }

    public School(Map<String, BanJi> schoolMap) {
        this.schoolMap = schoolMap;
    }

    public Map<String, BanJi> getSchoolMap() {
        return schoolMap;
    }

    public void setSchoolMap(Map<String, BanJi> schoolMap) {
        this.schoolMap = schoolMap;
    }

    /**
     * 添加班级
     *
     * @param banji
     */
    public void addBanji(BanJi banji) {
        schoolMap.put(banji.getClassName(), banji);


    }

    /**
     * 删除班级
     *
     * @param banji
     */
    public void deleteBanji(BanJi banji) {
        schoolMap.remove(banji.getClassName(), banji);

    }

    /**
     * 通过班级名称查询班级
     *
     * @param className
     * @return
     */
    public BanJi searchClassByName(String className) {
        BanJi banji = null;
        Set<String> banjiSet = schoolMap.keySet();
        for (String s : banjiSet) {
            if (s.equals(className)) {
                //System.out.println("...");
                banji = schoolMap.get(s);
                break;
            }
        }
        return banji;
    }

    /**
     * 对各班语文成绩按平均分进行由大到小排序
     */
    public void sortChineseByAverage() {
        Map<String, Float> scoreMap = new HashMap<String, Float>();//成绩集合用来存放各班级平均分
        BanJi banji = null;
        Set<String> banjiSet = schoolMap.keySet();//班级名称列表
        for (String s : banjiSet) {
            if (s.equals("主学生列表")) {
                //System.out.println("主学生列表不参加比较");
                continue;
            }
            banji = this.searchClassByName(s);
            if (banji == null) {
                System.out.println("未找到此班级");
            } else if (banji.isStudentNull()) {
                System.out.println("还未向班级添加学生");
                break;
            } else {
                scoreMap.put(s, banji.getChineseAverage());
            }
        }
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(scoreMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        if (!scoreMap.isEmpty()) {
            System.out.println("排序后的数据为：");
            for (Map.Entry<String, Float> mapping : list) {
                System.out.println(mapping.getKey() + ":" + mapping.getValue());
            }
        } else {
            System.out.println("无数据");
        }


    }

    /**
     * 对各班数学成绩按平均分进行由大到小排序
     */
    public void sortMathByAverage() {
        Map<String, Float> scoreMap = new HashMap<String, Float>();//成绩集合用来存放各班级平均分
        BanJi banji = null;
        Set<String> banjiSet = schoolMap.keySet();//班级名称列表
        for (String s : banjiSet) {
            if (s.equals("主学生列表")) continue;
            banji = this.searchClassByName(s);
            if (banji == null) {
                System.out.println("未找到此班级");
            } else if (banji.isStudentNull()) {
                System.out.println("还未向班级添加学生");
                break;
            } else {
                scoreMap.put(s, banji.getMathAverage());
            }
        }
        List<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(scoreMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        if (!scoreMap.isEmpty()) {
            System.out.println("排序后的数据为：");
            for (Map.Entry<String, Float> mapping : list) {
                System.out.println(mapping.getKey() + ":" + mapping.getValue());
            }
        } else {
            System.out.println("无数据");
        }


    }

    /**
     * 显示所有班级名称
     */
    public void displayBanJiName() {
        Set<String> BanjiSet = schoolMap.keySet();
        System.out.println("班级名称为：");
        int i = 1;
        for (String s : BanjiSet) {
            if (s.equals("主学生列表")) continue;
            System.out.println(i + "、" + s);
            i++;
        }

    }


}
