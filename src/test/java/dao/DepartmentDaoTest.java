package dao;

import hibernate.DepartmentEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDaoTest {

    private DepartmentDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new DepartmentDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals(_dao.findById(1).getName(), "Board of Directors");
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        DepartmentEntity tmp = new DepartmentEntity();
        tmp.setId(-1);
        tmp.setName("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(-1).getName());
        tmp.setName("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(-1).getName());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<DepartmentEntity> _list = _dao.findAll();
        for (DepartmentEntity i: _list) {
            assertEquals(i.getName(), _dao.findById(i.getId()).getName());
        }
    }

    @Test
    public void getHierarchy() {
        DepartmentEntity head = _dao.findById(1);
        assertNull(head.getDepartmentByHeadId());
        DepartmentEntity other = _dao.findById(2);
        assertEquals(head, other.getDepartmentByHeadId());
    }

    @Test
    public void updateDescription() {
        DepartmentEntity tmp = _dao.findById(1);
        String prev = tmp.getDescription();
        tmp.setDescription("DESCRIPTION");
        _dao.update(tmp);
        assertEquals("DESCRIPTION", _dao.findById(1).getDescription());
        tmp.setDescription(prev);
        _dao.update(tmp);
    }

}