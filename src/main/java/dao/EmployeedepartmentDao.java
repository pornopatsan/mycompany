package dao;

import hibernate.EmployeeDepartmentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeedepartmentDao {
    public EmployeeDepartmentEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeeDepartmentEntity.class, id);
    }

    public void save(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tmp);
        tx1.commit();
        session.close();
    }

    public void delete(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(tmp);
        tx1.commit();
        session.close();
    }

    public void update(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(tmp);
        tx1.commit();
        session.close();
    }

    public List<EmployeeDepartmentEntity> findAll() {
        List<EmployeeDepartmentEntity> res = (List<EmployeeDepartmentEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeeDepartmentEntity").list();
        return res;
    }

}

