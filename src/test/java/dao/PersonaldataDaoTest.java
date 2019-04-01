package dao;

import hibernate.PersonaldataEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonaldataDaoTest {

    private PersonaldataDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new PersonaldataDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals(_dao.findById(1).getFirstName(), "Dilshod");
    }

    @Test
    public void save_update_delete() {
        PersonaldataEntity tmp = new PersonaldataEntity();
        tmp.setId(-1);
        tmp.setFirstName("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getFirstName(), "TEST_ENTITY");
        tmp.setFirstName("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getFirstName(), "NEW_TEST_ENTITY");
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<PersonaldataEntity> _list = _dao.findAll();
        assertEquals(_list.size(), 4);
        assertEquals(_list.get(0).getFirstName(), "Dilshod");
        assertEquals(_list.get(1).getFirstName(), "Emma");
        assertEquals(_list.get(2).getFirstName(), "Ksenia");
    }
}