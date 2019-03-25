package utils;

import hibernate.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AccountsEntity.class);
                configuration.addAnnotatedClass(DepartmentEntity.class);
                configuration.addAnnotatedClass(EmployeeEntity.class);
                configuration.addAnnotatedClass(EmployeejobsHistoryEntity.class);
                configuration.addAnnotatedClass(JobsEntity.class);
                configuration.addAnnotatedClass(LocationEntity.class);
                configuration.addAnnotatedClass(OfficeEntity.class);
                configuration.addAnnotatedClass(PersonaldataEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
