package cn.atguigu.team.service;

//public class Status {
//    private final String NAME;
//
//    private Status(String name) {
//        this.NAME = name;
//    }
//
//    public static final Status FREE = new Status("FREE");
//    public static final Status BUSY = new Status("BUSY");
//    public static final Status VOCATION = new Status("VOCATION");
//
//    public String getNAME() {
//        return this.NAME;
//    }
//
//    @Override
//    public String toString() {
//        return NAME;
//    }
//}
public enum Status{
    BUSY, FREE, VOCATION;
}