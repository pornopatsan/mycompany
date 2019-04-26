package company.dao;

import company.hibernate.AccountsEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class AccountsDao {

    private Session session;

    public AccountsEntity findByLogin(String login) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AccountsEntity res = (AccountsEntity) session.get(AccountsEntity.class, login);
        session.close();
        return res;
    }

    @Transactional
    public void save(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(account);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(account);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(AccountsEntity account) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(account);
        session.flush();
        session.close();
    }

    public List<AccountsEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<AccountsEntity> res = (List<AccountsEntity>) session.createQuery("From AccountsEntity").list();
        session.close();
        return res;
    }
}
