
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Game1Test {
    
    public Game1Test() {
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
    public void testTDisplay() {
        System.out.println("tDisplay");
        Game1 instance = new Game1();
        instance.tDisplay();
    }

    
    @Test
    public void testExit() {
        System.out.println("Exit");
        int n = 0;
        Game1 instance = new Game1();
        instance.Exit(n);
        
    }

   
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Game1.main(args);
        
    }

    
    @Test
    public void testLogic() {
        System.out.println("logic");
        Game1 instance = new Game1();
        instance.logic();
        
    }
}
