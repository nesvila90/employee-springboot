package com.fonyou.employee;

public class MainTest2 {
    public enum Days {MON, TUE, WED}
    static String s = "-";
    public static void main(String[] args) {
        new MainTest2().s1();
        System.out.println(s);
    }
    void s1() {
        try { s2(); }
        catch (Exception e) { s += "c"; }
    }
    void s2() throws Exception {
        s3(); s += "2";
        s3(); s += "2b";
    }
    void s3() throws Exception {
        throw new Exception();
    }
}
