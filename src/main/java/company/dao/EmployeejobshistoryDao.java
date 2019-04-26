package company.dao;

import company.hibernate.EmployeejobsHistoryEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class EmployeejobshistoryDao {

    private Session session;

    public EmployeejobsHistoryEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeejobsHistoryEntity res = (EmployeejobsHistoryEntity) session.get(EmployeejobsHistoryEntity.class, id);
        session.close();
        return res;
    }

    @Transactional
    public void save(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(history);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(history);
        session.flush();
        session.close();
    }

    @Transactional
    public void update(EmployeejobsHistoryEntity history) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(history);
        session.flush();
        session.close();
    }

    public List<EmployeejobsHistoryEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeejobsHistoryEntity> res =
                (List<EmployeejobsHistoryEntity>) session.createQuery("From EmployeejobsHistoryEntity").list();
        session.close();
        return res;
    }

}
