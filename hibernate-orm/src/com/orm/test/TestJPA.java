package com.orm.test;

import com.orm.domain.jpa.onetomany.Dept;
import com.orm.domain.jpa.onetomany.Emp;
import com.orm.domain.jpa.onetoone.IDCard;
import com.orm.domain.jpa.onetoone.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestJPA {
    static SessionFactory factory;

    static {
        Configuration cfg = new Configuration().configure("jpa/hibernate.cfg.xml");
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
    public void testOneToOne() {
        Transaction tx = null;
        try (Session session = getSession()){
            tx = session.beginTransaction();

            // 创建2个人
            Person person1 = new Person();
            person1.setPersonName("张三");
            Person person2 = new Person();
            person2.setPersonName("李四");
            // 创建2张身份
            IDCard card1 = new IDCard();
            card1.setCardInfo("张三信息");
            IDCard card2 = new IDCard();
            card2.setCardInfo("李四信息");
            // 设置关联
            person1.setCard(card1);
            person2.setCard(card2);
            card1.setPerson(person1);
            card2.setPerson(person2);

            session.persist(person1);
            session.persist(person2);
            session.persist(card1);
            session.persist(card2);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx !=null) {
                tx.rollback();
            }
        }
    }

    @Test
    public void testManyToMany() {
        System.out.println("=============");
    }

    @Test
    public void testOneToManyCasecdeAdd() {
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

    @Test
    public void testOneToManyQuery() {
        Session session = getSession();
        Dept dept1 = session.get(Dept.class, 1L);
        System.out.println(dept1.getDeptName());

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 清除一级缓存中的内容
        // session.evict(dept1);
        Dept dept2 = session.get(Dept.class, 1L);
        System.out.println(dept1.getDeptName());

    }

    @Test
    public void testOneToManyQuery1() {
        Session session = getSession();
        Query query = session.createQuery("FROM Emp e join e.dept dept");
        Object[] objects = query.list().toArray();
       /* List<Emp> list =
        for (Emp emp : list) {
            System.out.println(emp.getEmpName()+","+emp.getDept().getDeptName());
        }*/
        for (Object obj : objects) {
            Object[] emp = (Object[]) obj;
            for (Object value : emp) {
                System.out.print(value+" ");
            }
            System.out.println();
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
