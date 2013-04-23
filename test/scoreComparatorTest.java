

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class scoreComparatorTest {
    
    public scoreComparatorTest() {
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
    public void testCompare() {
        System.out.println("compare");
        String a = "ab510";
        String b = "ab 01";
        scoreComparator instance = new scoreComparator();
        int expResult = -1;
        int result = instance.compare(a, b);
        assertEquals(expResult, result);
        a="Mani";
        b="Mani";
        expResult=0;
        result=instance.compare(a,b);
        assertEquals(expResult,result);
    }
}
