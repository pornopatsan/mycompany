package company.dao;

import company.hibernate.JobsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class JobsDao {

    private Session session;

    public JobsEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        JobsEntity res = session.get(JobsEntity.class, id);
        session.close();
        return res;
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
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<JobsEntity> res = (List<JobsEntity>) session.createQuery("From JobsEntity").list();
        session.close();
        return res;
}
}
