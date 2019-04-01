package dao;

import hibernate.DepartmentEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DepartmentDao {

    private Session session;

    public DepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        DepartmentEntity res = session.get(DepartmentEntity.class, id);
        session.close();
        return res;
    }

    public void save(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        tx1.commit();
        session.close();
    }

    public void delete(DepartmentEntity department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        tx1.commit();
        session.close();
    }

    public void update(DepartmentEntity department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(department);
        tx1.commit();
        session.close();
    }

    public List<DepartmentEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<DepartmentEntity> res = (List<DepartmentEntity>) session.createQuery("From DepartmentEntity").list();
        session.close();
        return res;
    }
}
