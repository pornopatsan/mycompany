package dao;

import hibernate.EmployeeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDao {

    private Session session;

    public EmployeeEntity findById(int id) {
        session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeEntity res = session.get(EmployeeEntity.class, id);
        session.close();
        return res;
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeEntity> res = (List<EmployeeEntity>) session.createQuery("From EmployeeEntity").list();
        session.close();
        return res;
    }

}
