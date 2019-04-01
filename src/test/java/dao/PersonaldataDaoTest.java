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
        assertEquals("Dilshod", _dao.findById(1).getFirstName());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void save_update_delete() {
        PersonaldataEntity tmp = new PersonaldataEntity();
        tmp.setId(-1);
        tmp.setFirstName("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(-1).getFirstName());
        tmp.setFirstName("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(-1).getFirstName());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<PersonaldataEntity> _list = _dao.findAll();
        assertEquals("Dilshod", _list.get(0).getFirstName());
    }
}