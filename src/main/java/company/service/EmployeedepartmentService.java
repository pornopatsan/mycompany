package company.service;

import company.dao.EmployeedepartmentDao;
import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeDepartmentEntity;
import company.hibernate.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeedepartmentService {

    @Autowired
    EmployeedepartmentDao dao;

    public EmployeeDepartmentEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(EmployeeDepartmentEntity tmp) {
        dao.save(tmp);
    }

    public void delete(EmployeeDepartmentEntity tmp) {
        dao.delete(tmp);
    }

    public void update(EmployeeDepartmentEntity tmp) {
        dao.update(tmp);
    }

    public List<EmployeeDepartmentEntity> findAll() {
        return dao.findAll();
    }

    public List<EmployeeDepartmentEntity> findByEmployee(EmployeeEntity employee) {
        return dao.findByEmployee(employee);
    }

    public List<EmployeeDepartmentEntity> findByDepartment(DepartmentEntity department) {
        return dao.findByDepartment(department);
    }

    public EmployeeDepartmentEntity findByEmployeeAndDepartment(EmployeeEntity eid, DepartmentEntity did) {
        return dao.findByEmployeeAndDepartment(eid, did);
    }
}
