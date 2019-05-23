package company.service;

import company.dao.EmployeeDao;
import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    EmployeeDao dao;

    public EmployeeEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(EmployeeEntity employee) {
        dao.save(employee);
    }

    public void delete(EmployeeEntity employee) {
        dao.delete(employee);
    }

    public void update(EmployeeEntity employee) {
        dao.update(employee);
    }

    public List<EmployeeEntity> findAll() {
        return dao.findAll();
    }

    public List<EmployeeEntity> findByDepartment(DepartmentEntity department) {
        return dao.findByDepartment(department);
    }

}
