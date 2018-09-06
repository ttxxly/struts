package com.orm.domain.jpa.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 */
@Entity // 标注为hibernate的持久类
@Table(name = "tbb_dept")
public class Dept {


    private Long deptId;
    private String deptName;
    private Set<Emp> emps = new HashSet<>(); // 一个部门可以对应多个员工

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键的生成策略
    @Column(name = "dept_id")
    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @OneToMany(mappedBy = "dept", cascade = CascadeType.PERSIST)
    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
