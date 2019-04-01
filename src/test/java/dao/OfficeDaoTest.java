package dao;

import hibernate.OfficeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OfficeDaoTest {

    private OfficeDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new OfficeDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals("Lomonosovsky pr-ct 27/11", _dao.findById(1).getAddress());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void save_update_delete() {
        OfficeEntity tmp = new OfficeEntity();
        tmp.setId(-1);
        tmp.setAddress("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(-1).getAddress());
        tmp.setAddress("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(-1).getAddress());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<OfficeEntity> _list = _dao.findAll();
        assertEquals("Lomonosovsky pr-ct 27/11", _list.get(0).getAddress());
    }
}