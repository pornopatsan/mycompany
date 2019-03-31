package dao;

import hibernate.JobsEntity;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class JobsDaoTest {

    private JobsDao dao;
    private static boolean ok = true;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Testing: JobsDao");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (ok) {
            System.out.println("OK");
        } else {
            System.out.println("FAILED");
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findAll() {
//        dao.JobsDao jd = new dao.JobsDao();
//        List<JobsEntity> jobs = jd.findAll();
//        for (hibernate.JobsEntity job: jobs) {
//            System.out.println(job.getFunction());
//        }
    }
}