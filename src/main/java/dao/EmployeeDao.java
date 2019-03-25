package dao;

import hibernate.EmployeeEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class EmployeeDao {

    public EmployeeEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeeEntity.class, id);
    }

}
