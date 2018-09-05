import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernateDev {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        System.out.println(sessionFactory);
    }
}
