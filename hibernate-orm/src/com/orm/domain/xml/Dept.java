package com.orm.domain.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 */
public class Dept {
    private Long deptId;
    private String deptName;
    private Set<Emp> emps = new HashSet<>(); // 一个部门可以对应多个员工

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
