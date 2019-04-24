package company.dao;

import company.hibernate.OfficeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OfficeDao {

    private Session session;

    public OfficeEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        OfficeEntity res = session.get(OfficeEntity.class, id);
        session.close();
        return res;
    }

    public void save(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(office);
        tx1.commit();
        session.close();
    }

    public void delete(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(office);
        tx1.commit();
        session.close();
    }

    public void update(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(office);
        tx1.commit();
        session.close();
    }

    public List<OfficeEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<OfficeEntity> res = (List<OfficeEntity>) session.createQuery("From OfficeEntity").list();
        session.close();
        return res;
    }
}
