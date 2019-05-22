package company.dao;

import company.hibernate.LocationEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LocationDao {

    private Session session;

    public LocationEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        LocationEntity res = (LocationEntity) session.get(LocationEntity.class, id);
        session.close();
        return res;
    }

    public void save(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(location);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void delete(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(location);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(location);
        session.flush();
        tx1.commit();
        session.close();
    }

    public List<LocationEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<LocationEntity> res = (List<LocationEntity>) session.createQuery("From LocationEntity").list();
        session.close();
        return res;
    }
}
