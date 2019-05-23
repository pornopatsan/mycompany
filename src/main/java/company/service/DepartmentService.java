package company.service;

import company.dao.DepartmentDao;
import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentService {

    @Autowired
    DepartmentDao dao;

    public DepartmentEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(DepartmentEntity department) {
        dao.save(department);
    }

    public void delete(DepartmentEntity department) {
        dao.delete(department);
    }

    public void update(DepartmentEntity department) {
        dao.update(department);
    }

    public List<DepartmentEntity> findAll() {
        return dao.findAll();
    }

    public List<DepartmentEntity> findByEmployee(EmployeeEntity employee) {
        return dao.findByEmployee(employee);
    }

}
