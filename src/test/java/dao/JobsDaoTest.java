package dao;

import hibernate.JobsEntity;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class JobsDaoTest {

    private JobsDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new JobsDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals(_dao.findById(1).getFunction(), "President");
    }

    @Test
    public void save_update_delete() {
        JobsEntity tmp = new JobsEntity();
        tmp.setId(-1);
        tmp.setFunction("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getFunction(), "TEST_ENTITY");
        tmp.setFunction("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getFunction(), "NEW_TEST_ENTITY");
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<JobsEntity> _list = _dao.findAll();
        assertEquals(_list.size(), 12);
        assertEquals(_list.get(0).getFunction(), "President");
        assertEquals(_list.get(1).getFunction(), "Manager");
        assertEquals(_list.get(2).getFunction(), "HR");
    }
}