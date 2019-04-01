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
        assertEquals(_dao.findById(1).getAddress(), "Lomonosovsky pr-ct 27/11");
    }

    @Test
    public void save_update_delete() {
        OfficeEntity tmp = new OfficeEntity();
        tmp.setId(-1);
        tmp.setAddress("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getAddress(), "TEST_ENTITY");
        tmp.setAddress("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getAddress(), "NEW_TEST_ENTITY");
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<OfficeEntity> _list = _dao.findAll();
        assertEquals(_list.size(), 1);
        assertEquals(_list.get(0).getAddress(), "Lomonosovsky pr-ct 27/11");
    }
}