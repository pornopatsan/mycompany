package company.service;

import company.dao.EmployeejobshistoryDao;
import company.hibernate.EmployeejobsHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeJobsHistoryService {

    @Autowired
    EmployeejobshistoryDao dao;

    public EmployeejobsHistoryEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(EmployeejobsHistoryEntity history) {
        dao.save(history);
    }

    public void delete(EmployeejobsHistoryEntity history) {
        dao.delete(history);
    }

    public void update(EmployeejobsHistoryEntity history) {
        dao.update(history);
    }

    public List<EmployeejobsHistoryEntity> findAll() {
        return dao.findAll();
    }
}
