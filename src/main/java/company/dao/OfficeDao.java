package company.dao;

import company.hibernate.OfficeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class OfficeDao {

    private Session session;

    public OfficeEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        OfficeEntity res = (OfficeEntity) session.get(OfficeEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(office);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(office);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(OfficeEntity office) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(office);
        session.flush();
        session.close();
    }

    public List<OfficeEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<OfficeEntity> res = (List<OfficeEntity>) session.createQuery("From OfficeEntity").list();
        session.close();
        return res;
    }
}
