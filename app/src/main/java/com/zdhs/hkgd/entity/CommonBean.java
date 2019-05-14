package com.zdhs.hkgd.entity;


public class CommonBean {
    private int icon;
    private String title;
    private String summary;
    private String time;
    private int num;

    public CommonBean(int num, int icon, String title) {
        this.icon = icon;
        this.title = title;
        this.num = num;
    }
    public CommonBean(String title,String summary,String time) {
        this.title = title;
        this.summary = summary;
        this.time = time;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CommonBean{" +
                "icon=" + icon +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", time='" + time + '\'' +
                ", num=" + num +
                '}';
    }
}
