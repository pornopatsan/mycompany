package dao;

import hibernate.EmployeeEntity;
import hibernate.JobsEntity;
import hibernate.EmployeejobsHistoryEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class JobsDao {
    public JobsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(JobsEntity.class, id);
    }

    public void save(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(job);
        tx1.commit();
        session.close();
    }

    public void delete(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(job);
        tx1.commit();
        session.close();
    }

    public void update(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(job);
        tx1.commit();
        session.close();
    }


    public List<JobsEntity> findAll() {
        List<JobsEntity> res = (List<JobsEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From JobsEntity").list();
        return res;
    }
}
