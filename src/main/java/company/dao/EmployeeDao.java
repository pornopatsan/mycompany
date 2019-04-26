package company.dao;

import company.hibernate.EmployeeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class EmployeeDao {

    private Session session;

    public EmployeeEntity findById(int id) {
        session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeEntity res = (EmployeeEntity) session.get(EmployeeEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(employee);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(employee);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(employee);
        session.flush();
        session.close();
    }

    public List<EmployeeEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeEntity> res = (List<EmployeeEntity>) session.createQuery("From EmployeeEntity").list();
        session.close();
        return res;
    }

}
