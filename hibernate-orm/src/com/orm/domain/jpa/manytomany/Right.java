package com.orm.domain.jpa.manytomany;

import org.junit.ClassRule;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_right")
public class Right {
    private Long rightId;
    private String rightName;
    private Set<Role> roles = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "right_id")
    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    @Column(name = "right_name")
    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    @ManyToMany
    // 配置中间表
    @JoinTable(name="t_role_right", joinColumns={ @JoinColumn(name="right_id")},
            inverseJoinColumns={ @JoinColumn(name = "role_id") })
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
