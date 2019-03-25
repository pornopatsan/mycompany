package dao;

import hibernate.JobsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

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
}
