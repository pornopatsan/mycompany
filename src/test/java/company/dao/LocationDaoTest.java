package company.dao;

import company.hibernate.LocationEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LocationDaoTest {

    private LocationDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new LocationDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals("Moscow", _dao.findById(1).getRegion());
        assertEquals("Russian Federation", _dao.findById(1).getCountry());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        LocationEntity tmp = new LocationEntity();
        tmp.setId(-1);
        tmp.setRegion("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(-1).getRegion());
        tmp.setRegion("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(-1).getRegion());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<LocationEntity> _list = _dao.findAll();
        for (LocationEntity i: _list) {
            assertEquals(i.getRegion(), _dao.findById(i.getId()).getRegion());
        }
    }

}