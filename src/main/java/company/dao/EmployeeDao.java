package company.dao;

import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeEntity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDao {

    private Session session;

    public EmployeeEntity findById(int id) {
        session =  HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeEntity res = (EmployeeEntity) session.get(EmployeeEntity.class, id);
        session.close();
        return res;
    }

    public void save(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employee);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void delete(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employee);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employee);
        session.flush();
        tx1.commit();
        session.close();
    }

    public List<EmployeeEntity> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeEntity> res = (List<EmployeeEntity>) session.createQuery("From EmployeeEntity").list();
        session.close();
        return res;
    }

    public List<EmployeeEntity> findByDepartment(DepartmentEntity department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "Select employeeByEmployeeId From EmployeeDepartmentEntity\n" +
                        "Where department_id = :did"
        );
        query.setParameter("did", department.getId());
        List<EmployeeEntity> res = (List<EmployeeEntity>) query.list();
        session.close();
        return res;
    }

}
