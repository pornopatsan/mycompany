package company.service;

import company.dao.OfficeDao;
import company.hibernate.OfficeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OfficeService {

    @Autowired
    OfficeDao dao;

    public OfficeEntity findById(int id) {
        return dao.findById(id);
    }

    @Transactional
    public void save(OfficeEntity office) {
        dao.save(office);
    }

    @Transactional
    public void delete(OfficeEntity office) {
        dao.delete(office);
    }

    @Transactional
    public void update(OfficeEntity office) {
        dao.update(office);
    }

    public List<OfficeEntity> findAll() {
        return dao.findAll();
    }
}
