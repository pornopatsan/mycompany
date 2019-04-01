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
        assertEquals(_dao.findById(-1).getName(), "TEST_ENTITY");
        tmp.setName("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getName(), "NEW_TEST_ENTITY");
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<DepartmentEntity> _list = _dao.findAll();
        assertEquals(_list.get(0).getName(), "Board of Directors");
        assertEquals(_list.get(1).getName(), "Game Development");
        assertEquals(_list.get(1).getDepartmentByHeadId().getName(), "Board of Directors");
        assertEquals(_list.get(2).getName(), "HR");
    }

    @Test
    public void getHierarchy() {
        DepartmentEntity head = _dao.findById(1);
        assertNull(head.getDepartmentByHeadId());
        DepartmentEntity other = _dao.findById(2);
        assertEquals(head, other.getDepartmentByHeadId());
    }

}