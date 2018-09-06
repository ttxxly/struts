package com.orm.domain.jpa.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "tbb_emp")
public class Emp {
    private Long empId;
    private String empName;
    private Dept dept; // 员工所属的部门对象=>部门编号

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Column(name = "emp_name")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id") // 配置当前类映射表的外键名称
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
