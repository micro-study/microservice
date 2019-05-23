package com.hz.pojo;

/**
 * @Auther: huangzhuo
 * @Date: 2019/1/17 16:40
 * @Description:
 */
public class Schedule {
    private String name;          //课程名字
    private String dayOfWeek;    //周几
    private String timePeriod;   //第几节课

    public Schedule(String name, String dayOfWeek, String timePeriod) {
        this.name = name;
        this.dayOfWeek = dayOfWeek;
        this.timePeriod = timePeriod;
    }

    public Schedule() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }
}
