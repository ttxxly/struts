package test;

import com.pojo.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

public class TestCRUD {
    static SessionFactory factory;

    static {
        Configuration cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
    }

    /**
     * 定义获取Session对象的方法
     */
    public Session getSession() {
        return factory.openSession();
    }


    @Before
    public void initalizer() {
        System.out.println("start");
    }

    @Test
    public void add() {
        // 开启一个事务
        Transaction tx = null;
        try (
                Session session = getSession();
                ){
            tx = session.beginTransaction();

            // 创建一个用户对象
            UserInfo userInfo = new UserInfo();
            userInfo.setUserAge(20);
            userInfo.setUserBirth(new Date());
            userInfo.setUserName("李四");
            // 返回当前增加的数据主键值
            /*Serializable pkId = session.save(userInfo);*/
            // 主要操作的实体
            session.persist(userInfo);
            // System.out.println("新增的主键ID="+pkId);
            userInfo.setUserName("aaaa1");
            userInfo.setUserName("aaaa2");
            userInfo.setUserName("aaaa3");
            userInfo.setUserAge(21);
            // 提交事务
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                /*回滚事务*/
                tx.rollback();
            }
        }
    }

    @Test
    public void delete() {
        // 开启一个事务
        Transaction tx = null;
        try (
                Session session = getSession();
        ){
            tx = session.beginTransaction();

            // 创建一个用户对象
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(7L);
            // 返回当前增加的数据主键值
            /*Serializable pkId = session.save(userInfo);*/
            // 主要操作的实体
            session.delete(userInfo);
            // 提交事务
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                /*回滚事务*/
                tx.rollback();
            }
        }
    }

    @Test
    public void update() {
        // 开启一个事务
        Transaction tx = null;
        try (
                Session session = getSession();
        ){
            tx = session.beginTransaction();

            // 通过id获取到对应对象
            UserInfo userInfo = session.get(UserInfo.class, 5L);
            userInfo.setUserName("修改的信息");
            // 返回当前增加的数据主键值
            /*Serializable pkId = session.save(userInfo);*/
            // 主要操作的实体
            session.update(userInfo);
            // 提交事务

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                /*回滚事务*/
                tx.rollback();
            }
        }
    }


    @After
    public void close() {
        System.out.println("end");
    }
}
