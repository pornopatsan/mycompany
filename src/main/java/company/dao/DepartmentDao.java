package company.dao;

import company.hibernate.DepartmentEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class DepartmentDao {

    private Session session;

    public DepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        DepartmentEntity res = (DepartmentEntity) session.get(DepartmentEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(department);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(department);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(department);
        session.flush();
        session.close();
    }

    public List<DepartmentEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<DepartmentEntity> res = (List<DepartmentEntity>) session.createQuery("From DepartmentEntity").list();
        session.close();
        return res;
    }
}
