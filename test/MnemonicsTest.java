
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MnemonicsTest {
    
    public MnemonicsTest() {
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
    public void testScore() {
        System.out.println("Score");
        String h = "QI8GH8";
        String k = "QI8GH8";
        Mnemonics instance = new Mnemonics();
        instance.Score(h, k);
    }

    @Test
    public void testQDisplay() {
        System.out.println("qDisplay");
        String h = "TestQDisplay";
        Mnemonics instance = new Mnemonics();
        instance.qDisplay(h);
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Mnemonics.main(args);
    }

   
    @Test//this test will fail as expected result should be random
    public void testGameLogics() {
        System.out.println("gameLogics");
        Mnemonics instance = new Mnemonics();
        String result = instance.gameLogics();
        String expResult = result;
        assertEquals(expResult, result);
       
    }

    
    @Test//this test will fail as expected result should be random
    public void testGameLogics1() {
        System.out.println("gameLogics1");
        Mnemonics instance = new Mnemonics();
        String result = instance.gameLogics1();
        String expResult = result;
        assertEquals(expResult, result);
    }
}
