package company.dao;

import company.hibernate.PersonaldataEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class PersonaldataDao {

    private Session session;

    public PersonaldataEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PersonaldataEntity res = (PersonaldataEntity) session.get(PersonaldataEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(personaldata);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(personaldata);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(personaldata);
        session.flush();
        session.close();
    }

    public List<PersonaldataEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<PersonaldataEntity> res = (List<PersonaldataEntity>) session.createQuery("From PersonaldataEntity").list();
        session.close();
        return res;
    }

}
