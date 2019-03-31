package dao;

import hibernate.LocationEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LocationDao {
    public LocationEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(LocationEntity.class, id);
    }

    public void save(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(location);
        tx1.commit();
        session.close();
    }

    public void delete(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(location);
        tx1.commit();
        session.close();
    }

    public void update(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(location);
        tx1.commit();
        session.close();
    }

    public List<LocationEntity> findAll() {
        List<LocationEntity> res = (List<LocationEntity>)
                HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From LocationEntity").list();
        return res;
    }
}
