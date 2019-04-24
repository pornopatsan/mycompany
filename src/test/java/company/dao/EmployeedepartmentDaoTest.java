package company.dao;

import company.hibernate.EmployeeDepartmentEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeedepartmentDaoTest {

    private EmployeedepartmentDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new EmployeedepartmentDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals("Board of Directors", _dao.findById(1).getDepartmentByDepartmentId().getName());
        assertEquals("President", _dao.findById(1).getEmployeeByEmployeeId().getJobsByJobId().getFunction());
        assertEquals("Dilshod", _dao.findById(1).getEmployeeByEmployeeId().getPersonaldataByPersonalId().getFirstName());
    }

    @Test
    public void saveUpdateDelete() {
        EmployeeDepartmentEntity tmp = new EmployeeDepartmentEntity();
        tmp.setId(-1);
        _dao.save(tmp);
        assertNotNull(_dao.findById(-1));
        _dao.update(tmp);
        assertNotNull(_dao.findById(-1));
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<EmployeeDepartmentEntity> _list = _dao.findAll();
        assertNotNull(_list);
    }

}