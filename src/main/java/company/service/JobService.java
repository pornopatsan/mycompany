package company.service;

import company.dao.JobsDao;
import company.hibernate.EmployeeEntity;
import company.hibernate.JobsEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobService {

    @Autowired
    JobsDao dao;

    public JobsEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(JobsEntity job) {
        dao.save(job);
    }

    public void delete(JobsEntity job) {
        dao.delete(job);
    }

    public void update(JobsEntity job) {
        dao.update(job);
    }

    public List<JobsEntity> findAll() {
        return dao.findAll();
    }

    public List<JobsEntity> findByEmployee(EmployeeEntity employee) {
        return dao.findByEmployee(employee);
    }
}
