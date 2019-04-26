package company.dao;

import company.hibernate.EmployeeDepartmentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class EmployeedepartmentDao {

    private Session session;

    public EmployeeDepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeDepartmentEntity res = (EmployeeDepartmentEntity) session.get(EmployeeDepartmentEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(tmp);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(tmp);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(tmp);
        session.flush();
        session.close();
    }

    public List<EmployeeDepartmentEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeDepartmentEntity> res =
                (List<EmployeeDepartmentEntity>) session.createQuery("From EmployeeDepartmentEntity").list();
        session.close();
        return res;
    }

}

