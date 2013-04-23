import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class HangmanFinal extends JPanel{ 
String word="Incident The Evil Edition";
ArrayList<String> correct=new ArrayList();
JPanel jp=new hanger();
int guesses=0;
JPanel wds=new words();
JPanel guesser=new gui();
HangmanFinal(){
correct.add("A");
correct.add("E");
correct.add("I");
correct.add("O");
correct.add("U");

wds.setPreferredSize
(new Dimension
(word.length()*100,100));
setLayout(new GridLayout(8,5)); 
add(jp);
add(wds);
add(guesser); 
}
public static void main(String[] args){
JFrame jf=new JFrame();
jf.setDefaultCloseOperation
(JFrame.DISPOSE_ON_CLOSE);
jf.add(new HangmanFinal());
jf.pack();
jf.setVisible(true);
}
class hanger extends JPanel{
hanger(){
setPreferredSize
(new Dimension());
} 
public void paint(Graphics g){ 
g.setColor(Color.RED);
g.drawRect(10,70, 50, 20);
g.drawLine(35, 70, 35, 5);
g.drawLine(35,5,70,5);
if(guesses>0)
g.drawOval(60, 10, 20, 20);
if(guesses>1)
g.drawLine(70, 30, 70, 60);
if(guesses>2){
g.drawLine(70,60,50,65);
g.drawLine(70,60,90,65);
}
if(guesses>3){
g.drawLine(70, 30, 50, 25);
g.drawLine(70, 30, 90, 25);
} 
}
}
class words extends JPanel{

        @Override
public void paint(Graphics g){
g.clearRect
(-1,-1, this.getPreferredSize().width,
this.getPreferredSize().height);
g.setColor(Color.BLUE);
g.drawString("Cool",0,0);
int jspace=100/(word.length()*10);
System.out.println(jspace); 
for(int i=0;i<word.length();i++){
boolean show=false;
for(int j=0;j<correct.size();j++){
if(correct.get(j).equalsIgnoreCase
(word.substring(i,i+1)))
show=true;
}
if(word.substring(i,i+1).equals(" "))
{}
else{
if(show){
g.drawString
(word.substring(i,i+1),i*10,20); 
}else{
g.drawLine(i*10, 20, (i+1)*10-5, 20);
} } } } }
class gui extends JPanel{
JTextField jtf = new JTextField(10);
JLabel j1=new JLabel
("Welcome to Hangman. Complete the word before the poor man hangs..");
JLabel j2=new JLabel
("Guess a letter, vowels of the words are given as a hint. Good luck! ");
JButton jb=new JButton("Click to Check!");
gui(){
setLayout(new FlowLayout());
add(j1);
add(j2);
add(jtf);
jb.addActionListener
(new ActionListener(){
                @Override
public void actionPerformed(ActionEvent ae){
try{
String s=jtf.getText();
jtf.setText("");
boolean good=false;
for(int i=0;i<word.length();i++){
if(s.equalsIgnoreCase
(word.substring(i,i+1)))
good=true;
}
if(good){
good=true;
for(int i=0;i<correct.size();i++){
if
(correct.get(i).equalsIgnoreCase(s))
good=false;
}if(good){correct.add(s);
} } else{
guesses++;
//jp.repaint();
}}catch(Exception ex){ }
wds.repaint();
}});
add(jb);
}}}