package company.dao;

import company.hibernate.EmployeeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDao _dao;
    private static final double eps = 0.001;

    @Before
    public void setUp() throws Exception {
        _dao = new EmployeeDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals(10000.00, _dao.findById(1).getSalary(), eps);
        // Какой странный конструктор
        Date expected = new Date(2019 - 1900, 2 - 1, 23);
        assertEquals(expected, _dao.findById(1).getHireDate());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        EmployeeEntity tmp = new EmployeeEntity();
        tmp.setId(-1);
        tmp.setSalary(-1.00);
        _dao.save(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -1.00, eps);
        tmp.setSalary(-2.00);
        _dao.update(tmp);
        assertEquals(_dao.findById(-1).getSalary(), -2.00, eps);
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<EmployeeEntity> _list = _dao.findAll();
        for (EmployeeEntity i: _list) {
            assertEquals(i.getSalary(), _dao.findById(i.getId()).getSalary(), eps);
        }
    }

}