

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class ScoreTest {
    
    public ScoreTest() {
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
    public void testWriteScore() {
        System.out.println("writeScore");
        String pName = "abc";
        String gName = "gameOn";
        Integer pScore = 10;
        Score instance = new Score();
        instance.writeScore(pName, gName, pScore);
        
    }

    
    @Test
    public void testReadScore() {
        System.out.println("readScore");
        String pName = "abc";
        Score instance = new Score();
        List<String> expResult = new ArrayList<String>();
        FileReader fr = null;
        try {
            fr = new FileReader("Score"+pName+".txt");
        } catch (FileNotFoundException ex) {
            
        }
                        BufferedReader br = new BufferedReader(fr);
                        for (int lineNo = 0; lineNo < 10; lineNo++) {
                             String line = null;
            try {
                line = br.readLine();
            } catch (IOException ex) {
               
            }
                             expResult.add(line);
                        }
        List result = instance.readScore(pName);
        assertEquals(expResult, result);
        
    }
}
