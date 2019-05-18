package com.zdhs.hkgd.bean;


public class WorkSheetBean {

    private String sheetID;//工单编号
    private String sheetState;//工单状态
    private String shopName;//测试一号店
    private String equipmentName;//设备名称
    private int priority;//优先级
    private String workerName;//测试人员
    private String workerTel;//测试人员电话
    private String date;//报修日期


    public WorkSheetBean(String sheetID, String sheetState, String shopName,String equipmentName, int priority, String workerName, String workerTel, String date) {
        this.sheetID = sheetID;
        this.sheetState = sheetState;
        this.date = date;
        this.shopName = shopName;
        this.equipmentName = equipmentName;
        this.priority = priority;
        this.workerName = workerName;
        this.workerTel = workerTel;
    }

    public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }

    public String getSheetState() {
        return sheetState;
    }

    public void setSheetState(String sheetState) {
        this.sheetState = sheetState;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerTel() {
        return workerTel;
    }

    public void setWorkerTel(String workerTel) {
        this.workerTel = workerTel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WorkSheetBean{" +
                "sheetID='" + sheetID + '\'' +
                ", sheetState='" + sheetState + '\'' +
                ", shopName='" + shopName + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", priority=" + priority +
                ", workerName='" + workerName + '\'' +
                ", workerTel='" + workerTel + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
