package company.dao;

import company.hibernate.LocationEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class LocationDao {

    private Session session;

    public LocationEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        LocationEntity res = (LocationEntity) session.get(LocationEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(location);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(location);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(location);
        session.flush();
        session.close();
    }

    public List<LocationEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<LocationEntity> res = (List<LocationEntity>) session.createQuery("From LocationEntity").list();
        session.close();
        return res;
    }
}
