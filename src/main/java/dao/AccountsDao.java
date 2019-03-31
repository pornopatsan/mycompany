package dao;

import hibernate.AccountsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

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

    public List<AccountsEntity> findAll() {
        List<AccountsEntity> res = (List<AccountsEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AccountsEntity").list();
        return res;
    }
}
