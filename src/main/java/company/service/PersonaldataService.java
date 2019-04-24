package company.service;

import company.dao.PersonaldataDao;
import company.hibernate.PersonaldataEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaldataService {

    @Autowired
    PersonaldataDao dao;

    public PersonaldataEntity findById(int id) {
        return dao.findById(id);
    }

    public void save(PersonaldataEntity personaldata) {
        dao.save(personaldata);
    }

    public void delete(PersonaldataEntity personaldata) {
        dao.delete(personaldata);
    }

    public void update(PersonaldataEntity personaldata) {
        dao.update(personaldata);
    }

    public List<PersonaldataEntity> findAll() {
        return dao.findAll();
    }
}
