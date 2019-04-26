package company.service;

import company.dao.DepartmentDao;
import company.hibernate.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DepartmentService {

    @Autowired
    DepartmentDao dao;

    public DepartmentEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void save(DepartmentEntity department) {
        dao.save(department);
    }

    @Transactional
    public void delete(DepartmentEntity department) {
        dao.delete(department);
    }

    @Transactional
    public void update(DepartmentEntity department) {
        dao.update(department);
    }

    public List<DepartmentEntity> findAll() {
        return dao.findAll();
    }
}
