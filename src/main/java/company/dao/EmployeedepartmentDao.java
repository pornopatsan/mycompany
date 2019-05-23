package company.dao;

import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeDepartmentEntity;
import company.hibernate.EmployeeEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeedepartmentDao {

    private Session session;

    public EmployeeDepartmentEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        EmployeeDepartmentEntity res = (EmployeeDepartmentEntity) session.get(EmployeeDepartmentEntity.class, id);
        session.close();
        return res;
    }

    public void save(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tmp);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void delete(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(tmp);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(EmployeeDepartmentEntity tmp) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(tmp);
        session.flush();
        tx1.commit();
        session.close();
    }

    public List<EmployeeDepartmentEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<EmployeeDepartmentEntity> res =
                (List<EmployeeDepartmentEntity>) session.createQuery("From EmployeeDepartmentEntity").list();
        session.close();
        return res;
    }

    public List<EmployeeDepartmentEntity> findByEmployee(EmployeeEntity employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "From EmployeeDepartmentEntity Where employee_id = :employee"
        );
        query.setParameter("employee", employee.getId());
        List<EmployeeDepartmentEntity> res = (List<EmployeeDepartmentEntity>) query.list();
        session.close();
        return res;
    }

    public List<EmployeeDepartmentEntity> findByDepartment(DepartmentEntity department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "From EmployeeDepartmentEntity Where department_id = :department"
        );
        query.setParameter("department", department.getId());
        List<EmployeeDepartmentEntity> res = (List<EmployeeDepartmentEntity>) query.list();
        session.close();
        return res;
    }

    public EmployeeDepartmentEntity findByEmployeeAndDepartment(EmployeeEntity eid, DepartmentEntity did) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery(
                "From EmployeeDepartmentEntity Where department_id = :did And employee_id = :eid"
        );
        query.setParameter("did", did.getId());
        query.setParameter("eid", eid.getId());
        EmployeeDepartmentEntity res = ((List<EmployeeDepartmentEntity>) query.list()).get(0);
        session.close();
        return res;
    }
}

