import java.io.*;
import java.util.*;
class Score{
    
     public void writeScore(String pName,String gName,Integer pScore){
        BufferedWriter bWrite=null;
        String s="Score"+pName+".txt";
         try {

 

        bWrite =new BufferedWriter(new FileWriter(s,true));
        if(pScore<10)
            bWrite.append(pName+"   "+gName+"   "+'0'+pScore);
        else
            bWrite.append(pName+"   "+gName+"   "+pScore);
        bWrite.newLine();

 

    } catch (Exception e) {

 

        e.printStackTrace();

 

    }finally{

 

      try {

 

              bWrite.close();

 

      } catch (IOException e) {
 

               e.printStackTrace();
      }
}
 }
   public List readScore(String pName){
       Comparator<String> mComp=new scoreComparator();
       List<String> uScore=new ArrayList<String>();
       int lineNo;
       String line;
       String k="Score"+pName+".txt";
        try {
                        FileReader fr = new FileReader(k);
                        BufferedReader br = new BufferedReader(fr);
                        for (lineNo = 0; lineNo < 10; lineNo++) {
                             line=br.readLine();
                             uScore.add(line);
                             
                             
                             }
                    Collections.sort(uScore,mComp);   
                } catch (Exception e) {
                        e.printStackTrace();
                }

       return uScore;
   }

    
}
class scoreComparator implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        try{
            if(a.compareTo(b)<0)
            return -1;
               }
catch(Exception e){
                
            }
        return 0;
    }
}