package test;

import com.pojo.UserInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestQuery {
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

    @Test // SQL
    public void testNativeSQL() {
        try (Session session = getSession()){
            // 创建一个原生SQL查询对象
            // 适用于查询所有字段
            NativeQuery query = session.createNativeQuery("select * from tb_userInfo").addEntity(UserInfo.class);
            // 执行SQL语句
            List list = query.list();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test // HQL(查询所有)
    public void testHQL() {
        try (Session session = getSession()){
            Query query = session.createQuery("from UserInfo");
            List list = query.list();
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test // HQL(查询某些字段)
    public void testHQL_1() {
        try (Session session = getSession()){
            Query query = session.createQuery("select new UserInfo(userId,userName) from UserInfo");
            List list = query.list();
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test // HQL(查询某些字段转换为Map集合)
    public void testHQL_2() {
        try (Session session = getSession()){
            Query query = session.createQuery("select new map(userId,userName) from UserInfo");
            List list = query.list();
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test // HQL(查询带参数 [?号占位])
    public void testHQL_3() {
        try (Session session = getSession()){
            Query query = session.createQuery("from UserInfo where userId = ?");
            query.setParameter(0, 3L);
            UserInfo userInfo = (UserInfo) query.uniqueResult();
            System.out.println(userInfo);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test // HQL(查询带参数 [命名参数占位])
    public void testHQL_4() {
        try (Session session = getSession()){
            Query query = session.createQuery("from UserInfo where userId =:userId");
            query.setParameter("userId", 4L);
            UserInfo userInfo = (UserInfo) query.uniqueResult();
            System.out.println(userInfo);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test // 更面向对象的查询操作
    public void testCriteria() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(UserInfo.class);
        // criteria.add(Restrictions.eq("userName", "张三"));
        criteria.add(Restrictions.like("userName", "四%"));
        criteria.add(Restrictions.in("userId",4L, 5L));
        List list = criteria.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void testNamedQuery() {
        Session session = getSession();
        // Query hqlQuery = session.createNamedQuery("selectAll_HQL");
        Query sqlQuery = session.createNamedQuery("selectAll_SQL");
        System.out.println(sqlQuery.list());
        session.close();
    }

    @Test // SQLServer,MySQL,Oracle (通配分页)
    public void testPage() {
        Session session = getSession();
        Query query = session.createQuery("FROM UserInfo u");
        query.setMaxResults(3); // 每页显示数
        query.setFirstResult((2 -1 ) * 3); // 每一页第一条记录对应索引

        System.out.println(query.list());
    }


    @After
    public void close() {
        System.out.println("end");
    }
}
