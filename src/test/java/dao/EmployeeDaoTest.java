package dao;

import hibernate.EmployeeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new EmployeeDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals(_dao.findById(1).getSalary(), 10000.00, 0.0001);
    }

    @Test
    public void save_update_delete() {
        EmployeeEntity tmp = new EmployeeEntity();
        tmp.setId(-1);
        tmp.setSalary(-1);
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -1.00, 0.0001);
        tmp.setSalary(-2);
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -2.00, 0.0001);
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<EmployeeEntity> _list = _dao.findAll();
        assertEquals(_list.size(), 3);
        assertEquals(_list.get(0).getSalary(), 10000.00, 0.0001);
        assertEquals(_list.get(1).getSalary(),3000.00, 0.0001);
        assertEquals(_list.get(2).getSalary(),800.00, 0.0001);
    }
}