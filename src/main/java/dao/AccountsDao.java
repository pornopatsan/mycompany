package dao;

import hibernate.AccountsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class AccountsDao {

    public AccountsEntity findByLogin(String login) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AccountsEntity.class, login);
    }

    public void save(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(account);
        tx1.commit();
        session.close();
    }

    public void delete(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(account);
        tx1.commit();
        session.close();
    }

    public void update(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(account);
        tx1.commit();
        session.close();
    }

}
