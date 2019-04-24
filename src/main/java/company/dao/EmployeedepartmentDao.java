package company.dao;

import company.hibernate.EmployeeDepartmentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeedepartmentDao {

    private Session session;

    public EmployeeDepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeDepartmentEntity res = session.get(EmployeeDepartmentEntity.class, id);
        session.close();
        return res;
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
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeDepartmentEntity> res =
                (List<EmployeeDepartmentEntity>) session.createQuery("From EmployeeDepartmentEntity").list();
        session.close();
        return res;
    }

}

