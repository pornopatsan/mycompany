package dao;

import hibernate.EmployeejobsHistoryEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeejobshistoryDaoTest {

    public EmployeejobshistoryDao _dao;

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
    }

    @Test
    public void save_update_delete() {
        EmployeejobsHistoryEntity tmp = new EmployeejobsHistoryEntity();
        tmp.setId(-1);
        tmp.setSalary(-1.00);
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -1.00, 0.0001);
        tmp.setSalary(-2.00);
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -2.00, 0.0001);
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<EmployeejobsHistoryEntity> _list = _dao.findAll();
        assertEquals(_list.size(), 0);
    }
}