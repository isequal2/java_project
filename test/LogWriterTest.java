

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LogWriterTest {
    
    public LogWriterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testWriteLog() {
        System.out.println("writeLog");
        String entry = "String Test";
        LogWriter instance = new LogWriter();
        instance.writeLog(entry);
        entry="123 abc ..../??????";
    }
}
