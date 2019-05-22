package company.dao;

import company.hibernate.EmployeejobsHistoryEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeejobshistoryDao {

    private Session session;

    public EmployeejobsHistoryEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeejobsHistoryEntity res = (EmployeejobsHistoryEntity) session.get(EmployeejobsHistoryEntity.class, id);
        session.close();
        return res;
    }

    public void save(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(history);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void delete(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(history);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(history);
        session.flush();
        tx1.commit();
        session.close();
    }

    public List<EmployeejobsHistoryEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeejobsHistoryEntity> res =
                (List<EmployeejobsHistoryEntity>) session.createQuery("From EmployeejobsHistoryEntity").list();
        session.close();
        return res;
    }

}
