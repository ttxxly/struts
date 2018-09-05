package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernateDev {
    public static void main(String[] args) {
        // 加载hibernate的配置文件
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        // 通过配置对象创建SessionFactory对象
        SessionFactory factory = configure.buildSessionFactory();
        // 与数据库建立连接
        Session session = factory.openSession();
        System.out.println(session);
    }
}
