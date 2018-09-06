package com.orm.test;

import com.orm.domain.xml.Dept;
import com.orm.domain.xml.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestORM {
    static SessionFactory factory;

    static {
        Configuration cfg = new Configuration().configure("xml/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }

    /**
     * 定义获取Session对象的方法
     */
    public Session getSession() {
        return factory.openSession();
    }

    @Test
    public void test1() {
        System.out.println("=====");
    }

    @Test
    public void testAdd() {
        Transaction tx = null;
        try (Session session = getSession()){
            tx = session.beginTransaction();

            // 创建一个部门
            Dept d1 = new Dept();
            d1.setDeptName("研发部1");
            // 创建2个员工
            Emp emp1 = new Emp();
            emp1.setEmpName("张三");

            Emp emp2 = new Emp();
            emp2.setEmpName("李四");

            // 设置关联关系
            emp1.setDept(d1);
            emp2.setDept(d1);

            // 持久化
            session.persist(d1);
            session.persist(emp1);
            session.persist(emp2);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx !=null) {
                tx.rollback();
            }
        }
    }

    @Test
    public void testCasecdeAdd() {
        Transaction tx = null;
        try (Session session = getSession()){
            tx = session.beginTransaction();

            // 创建一个部门
            Dept d1 = new Dept();
            d1.setDeptName("研发部1");
            // 创建2个员工
            Emp emp1 = new Emp();
            emp1.setEmpName("张三");

            Emp emp2 = new Emp();
            emp2.setEmpName("李四");
            // 设置关联关系
            emp1.setDept(d1);
            emp2.setDept(d1);
            d1.getEmps().add(emp1);
            d1.getEmps().add(emp2);

            // 持久化
            session.persist(d1);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx !=null) {
                tx.rollback();
            }
        }
    }



    @Before
    public void initalizer() {
        System.out.println("start");
    }

    @After
    public void close() {
        System.out.println("end");
    }
}
