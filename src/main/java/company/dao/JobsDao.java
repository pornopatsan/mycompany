package company.dao;

import company.hibernate.JobsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class JobsDao {

    private Session session;

    public JobsEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        JobsEntity res = (JobsEntity) session.get(JobsEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(job);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(job);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(JobsEntity job) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(job);
        session.flush();
        session.close();
    }


    public List<JobsEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<JobsEntity> res = (List<JobsEntity>) session.createQuery("From JobsEntity").list();
        session.close();
        return res;
}
}
