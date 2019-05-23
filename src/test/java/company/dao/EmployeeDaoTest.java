package company.dao;

import company.hibernate.EmployeeEntity;
import company.hibernate.EmployeejobsHistoryEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private EmployeeDao _dao;
    private DepartmentDao _d_dao;
    private static final double eps = 0.001;

    @Before
    public void setUp() throws Exception {
        _dao = new EmployeeDao();
        _d_dao = new DepartmentDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        // Какой странный конструктор
        assertNotNull(_dao.findById(1));
        assertNotNull(_dao.findById(1).getHireDate());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        EmployeeEntity tmp = new EmployeeEntity();
        tmp.setSalary(-1.00);
        _dao.save(tmp);
        assertEquals(_dao.findById(tmp.getId()).getSalary(), -1.00, eps);
        tmp.setSalary(-2.00);
        _dao.update(tmp);
        assertEquals(_dao.findById(tmp.getId()).getSalary(), -2.00, eps);
        _dao.delete(tmp);
        assertNull(_dao.findById(tmp.getId()));
    }

    @Test
    public void findAll() {
        List<EmployeeEntity> _list = _dao.findAll();
        for (EmployeeEntity i: _list) {
            assertEquals(i.getSalary(), _dao.findById(i.getId()).getSalary(), eps);
        }
    }

    @Test
    public void getEmployeeByDepartmentID() {
        assertEquals("Board of Directors", _d_dao.findById(1).getName());
        List<EmployeeEntity> tmp = _dao.findByDepartment(_d_dao.findById(1));
        assertNotNull(tmp);
        for (EmployeeEntity e : tmp) {
            assertEquals("Sapaev", e.getPersonaldataByPersonalId().getLastName());
        }
    }

}