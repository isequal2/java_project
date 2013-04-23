import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

	private int[][] winCombinations = new int[][] {
			{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
			{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
			{0, 4, 8}, {2, 4, 6}
		};
	Font f1 = new Font("Times New Roman",1, 72);
	 Score score=new Score();
	 JButton buttons[] = new JButton[9];
	 int flg = 0;
	 String letter = "";
	 boolean win = false;
         LogWriter lg=new LogWriter();
         
	public TicTacToe(){
		lg.writeLog("Frame making starts");
		
	
	this.setTitle("TicTacToe");
        this.setLocation(550,200);
	setVisible(true);
	setSize(300,300);

	setLayout(new GridLayout(3,3));
	

	for(int i=0; i<=8; i++){
		buttons[i] = new JButton();
		
	add(buttons[i]);
        lg.writeLog("Buttons Added");
		buttons[i].addActionListener(this);
                
                buttons[i].setBackground(Color.blue);
	}


	setVisible(true);
	}

    @Override
	public void actionPerformed(ActionEvent a) {
		flg++;
                lg.writeLog("Button is pressed");

		if(flg % 2 == 0){
			letter = "O";
		} else {
			letter = "X";
		}
		

		 JButton pressedButton = (JButton)a.getSource();
		 pressedButton.setFont(f1);
                 if(letter=="O")
		 pressedButton.setBackground(Color.yellow);
		 else
                     pressedButton.setBackground(Color.red);
		 pressedButton.setText(letter);
		 
		 pressedButton.setEnabled(false);


		for(int i=0; i<=7; i++){
			if( buttons[winCombinations[i][0]].getText().equals(buttons[winCombinations[i][1]].getText()) &&
				buttons[winCombinations[i][1]].getText().equals(buttons[winCombinations[i][2]].getText()) &&
				buttons[winCombinations[i][0]].getText() != ""){
                            lg.writeLog("Player wins");
				win = true;
			}
		}

                              
                JOptionPane content=new JOptionPane();
		if(win == true){
			JOptionPane.showMessageDialog(null, letter + " wins the game!");
                        lg.writeLog("Game Ends");
                        if(letter=="X")
                       score.writeScore(Collection.pName(),"TicTacToe",1);
                        setVisible(false);
                       
                     
		} else if(flg == 9 && win == false){
			JOptionPane.showMessageDialog(null, "The game was tie!");
                        lg.writeLog("Game Ends");
			score.writeScore(Collection.pName(),"TicTacToe",0);
                        setVisible(false);
                        
                       
		}
                
                    
	}

	public static void main(String[] args){
		TicTacToe game = new TicTacToe();
                game.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        }
}