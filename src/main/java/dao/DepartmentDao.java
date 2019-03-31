package dao;

import hibernate.DepartmentEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DepartmentDao {

    public DepartmentEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(DepartmentEntity.class, id);
    }

    public void save(DepartmentEntity department) {
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
        List<DepartmentEntity> res = (List<DepartmentEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From DepartmentEntity").list();
        return res;
    }
}
