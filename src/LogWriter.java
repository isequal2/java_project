import java.io.*;
class LogWriter{
  
    
    public synchronized void writeLog(String entry){
        BufferedWriter bw=null;
         try {

 

        bw =new BufferedWriter(new FileWriter("log.txt",true));

        bw.append(entry);

        bw.newLine();

 

    } catch (IOException e) {

 

        e.printStackTrace();

 

    }finally{

 

      try {

 

              bw.close();

 

      } catch (IOException e) {
 

               e.printStackTrace();
      }
}
 }
   

    }
