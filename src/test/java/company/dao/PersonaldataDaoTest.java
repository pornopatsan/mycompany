package company.dao;

import company.hibernate.PersonaldataEntity;
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
        assertNotNull(_dao.findById(1));
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        PersonaldataEntity tmp = new PersonaldataEntity();
        tmp.setFirstName("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(tmp.getId()).getFirstName());
        tmp.setFirstName("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(tmp.getId()).getFirstName());
        _dao.delete(tmp);
        assertNull(_dao.findById(tmp.getId()));
    }

    @Test
    public void findAll() {
        List<PersonaldataEntity> _list = _dao.findAll();
        assertNotNull(_list);
    }

    @Test
    public void updateFields() {
        PersonaldataEntity tmp = _dao.findById(1);
        String prev_self_description = tmp.getSelfDescription();
        String prev_phone = tmp.getPhone();
        String prev_address = tmp.getAddress();
        String prev_email = tmp.getEmail();

        tmp.setSelfDescription("DESCRIPTION");
        tmp.setPhone("PHONE");
        tmp.setAddress("ADDRESS");
        tmp.setEmail("EMAIL");
        _dao.update(tmp);

        assertEquals("DESCRIPTION", _dao.findById(1).getSelfDescription());
        assertEquals("PHONE", _dao.findById(1).getPhone());
        assertEquals("ADDRESS", _dao.findById(1).getAddress());
        assertEquals("EMAIL", _dao.findById(1).getEmail());

        tmp.setSelfDescription(prev_self_description);
        tmp.setPhone(prev_phone);
        tmp.setAddress(prev_address);
        tmp.setEmail(prev_email);
        _dao.update(tmp);
    }

}