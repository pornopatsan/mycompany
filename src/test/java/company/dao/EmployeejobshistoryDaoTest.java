package company.dao;

import company.hibernate.EmployeejobsHistoryEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeejobshistoryDaoTest {

    public EmployeejobshistoryDao _dao;
    private static final double eps = 0.001;

    @Before
    public void setUp() throws Exception {
        _dao = new EmployeejobshistoryDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertNull(_dao.findById(1));
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        EmployeejobsHistoryEntity tmp = new EmployeejobsHistoryEntity();
        tmp.setSalary(-1.00);
        _dao.save(tmp);
        assertEquals(-1.00, _dao.findById(tmp.getId()).getSalary(), eps);
        tmp.setSalary(-2.00);
        _dao.update(tmp);
        assertEquals(-2.00, _dao.findById(tmp.getId()).getSalary(), eps);
        _dao.delete(tmp);
        assertNull(_dao.findById(tmp.getId()));
    }

    @Test
    public void findAll() {
        List<EmployeejobsHistoryEntity> _list = _dao.findAll();
        assertNotNull(_list);
    }

}