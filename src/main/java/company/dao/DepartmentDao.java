package company.dao;

import company.hibernate.DepartmentEntity;

import company.hibernate.EmployeeEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;


import java.util.List;


public class DepartmentDao {

    private Session session;

    public DepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        DepartmentEntity res = (DepartmentEntity) session.get(DepartmentEntity.class, id);
        session.close();
        return res;
    }

    public void save(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        session.flush();
        session.close();
    }

    public void delete(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        session.flush();
        session.close();
    }

    public void update(DepartmentEntity department) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
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

    public List<DepartmentEntity> findByEmployee(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "Select departmentByDepartmentId From EmployeeDepartmentEntity\n" +
                        "Where employee_id = :ee"
        );
        query.setParameter("ee", employee.getId());
        List<DepartmentEntity> res = (List<DepartmentEntity>) query.list();
        session.close();
        return res;
    }
}
