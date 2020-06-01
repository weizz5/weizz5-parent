package com.weizz5.mybatis.bean;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/06/02
 */
public class Emp {

    private Integer empno;

    private String ename;

    private String job;

    private String sal;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal='" + sal + '\'' +
                '}';
    }
}
