package company.dao;

import company.hibernate.AccountsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AccountsDao {

    private Session session;

    public AccountsEntity findByLogin(String login) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AccountsEntity res = session.get(AccountsEntity.class, login);
        session.close();
        return res;
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
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AccountsEntity> res = (List<AccountsEntity>) session.createQuery("From AccountsEntity").list();
        session.close();
        return res;
    }
}
