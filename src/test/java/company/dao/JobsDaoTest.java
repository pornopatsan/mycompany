package company.dao;

import company.hibernate.JobsEntity;
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
        assertEquals("President", _dao.findById(1).getFunction());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        JobsEntity tmp = new JobsEntity();
        tmp.setFunction("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(tmp.getId()).getFunction());
        tmp.setFunction("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(tmp.getId()).getFunction());
        _dao.delete(tmp);
        assertNull(_dao.findById(tmp.getId()));
    }

    @Test
    public void findAll() {
        List<JobsEntity> _list = _dao.findAll();
        for (JobsEntity i: _list) {
            assertEquals(i.getFunction(), _dao.findById(i.getId()).getFunction());
        }
    }

}