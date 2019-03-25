package dao;

import hibernate.AccountsEntity;
import hibernate.EmployeeEntity;
import hibernate.PersonaldataEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Collection;

public class PersonaldataDao {

    public PersonaldataEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PersonaldataEntity.class, id);
    }

    public void save(PersonaldataDao personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(personaldata);
        tx1.commit();
        session.close();
    }

    public void delete(PersonaldataDao personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(personaldata);
        tx1.commit();
        session.close();
    }

    public void update(PersonaldataDao personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(personaldata);
        tx1.commit();
        session.close();
    }

    Collection<EmployeeEntity> getEmployees() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "from EmployeeEntity";
        Collection<EmployeeEntity> employee = session.createQuery(hql).list();
        session.close();
        return employee;
    }

    Collection<AccountsEntity> getAccounts() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "from AccountsEntity";
        Collection<AccountsEntity> accounts = session.createQuery(hql).list();
        session.close();
        return accounts;
    }
}
