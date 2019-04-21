package dao;

import hibernate.AccountsEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountsDaoTest {

    private AccountsDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new dao.AccountsDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByLogin() {
        assertEquals(_dao.findByLogin("admin").getPasswordd(), "admin");
    }

    @Test
    public void saveUpdateDelete() {
        AccountsEntity tmp = new AccountsEntity();
        tmp.setLogin("TEST_LOGIN");
        tmp.setPasswordd("TEST_PASSWORD");
        _dao.save(tmp);
        assertEquals(_dao.findByLogin("TEST_LOGIN").getPasswordd(), "TEST_PASSWORD");
        tmp.setPasswordd("TEST_PASSWORD_NEW");
        _dao.update(tmp);
        assertEquals(_dao.findByLogin("TEST_LOGIN").getPasswordd(), "TEST_PASSWORD_NEW");
        _dao.delete(tmp);
        assertNull(_dao.findByLogin("TEST_LOGIN"));
    }

    @Test
    public void findAll() {
        List<AccountsEntity> _list = _dao.findAll();
        assertNotNull(_list);
        boolean contains_admin = false;
        for (AccountsEntity i: _list) {
            if (i.getLogin().equals("admin")) {
                contains_admin = true;
                assertEquals(i.getPasswordd(), "admin");
            }
        }
        assertTrue(contains_admin);
    }

}