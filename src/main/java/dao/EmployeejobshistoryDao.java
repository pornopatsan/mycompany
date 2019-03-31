package dao;

import hibernate.EmployeeEntity;
import hibernate.EmployeejobsHistoryEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

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

    public List<EmployeejobsHistoryEntity> findAll() {
        List<EmployeejobsHistoryEntity> res = (List<EmployeejobsHistoryEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeejobsHistoryEntity").list();
        return res;
    }

}
