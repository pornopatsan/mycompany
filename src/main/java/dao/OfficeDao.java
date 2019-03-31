package dao;

import hibernate.OfficeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class OfficeDao {
    public OfficeEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OfficeEntity.class, id);
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
        List<OfficeEntity> res = (List<OfficeEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From OfficeEntity").list();
        return res;
    }
}
