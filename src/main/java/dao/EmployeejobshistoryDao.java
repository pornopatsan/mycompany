package dao;

import hibernate.EmployeejobsHistoryEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class EmployeejobshistoryDao {

    public EmployeejobsHistoryEntity findByLogin(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeejobsHistoryEntity.class, id);
    }

    public void save(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(history);
        tx1.commit();
        session.close();
    }

    public void delete(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(history);
        tx1.commit();
        session.close();
    }

    public void update(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(history);
        tx1.commit();
        session.close();
    }

}
