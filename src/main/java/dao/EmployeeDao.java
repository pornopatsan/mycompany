package dao;

import hibernate.EmployeeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDao {

    public EmployeeEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeeEntity.class, id);
    }

    public void save(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        tx1.commit();
        session.close();
    }

    public void delete(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        tx1.commit();
        session.close();
    }

    public void update(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        tx1.commit();
        session.close();
    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> res = (List<EmployeeEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeeEntity").list();
        return res;
    }

}
