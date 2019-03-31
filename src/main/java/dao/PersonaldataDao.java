package dao;

import hibernate.AccountsEntity;
import hibernate.EmployeeEntity;
import hibernate.PersonaldataEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Collection;
import java.util.List;

public class PersonaldataDao {

    public PersonaldataEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PersonaldataEntity.class, id);
    }

    public void save(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(personaldata);
        tx1.commit();
        session.close();
    }

    public void delete(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(personaldata);
        tx1.commit();
        session.close();
    }

    public void update(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(personaldata);
        tx1.commit();
        session.close();
    }

    public List<PersonaldataEntity> findAll() {
        List<PersonaldataEntity> res = (List<PersonaldataEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From PersonaldataEntity").list();
        return res;
    }

}
