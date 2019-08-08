package Game;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TTT extends JFrame implements ActionListener {
	public final int BOARD_SIZE = 3;
	private final String CROSS_TEXT = "X";
	private final String ZERO_TEXT = "0";
	private boolean crossTurn;
	private final int X_WINS=0;
	private final int ZERO_WINS=1;
	private final int TIE=2;
	private final int INCOMPLETE=3;
	
	private JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE]; 
	
	
	public TTT(){
		super("Tic-Tac-Toe");
		super.setVisible(true);
		super.setSize(600, 600);
		super.setResizable(false);
		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);
		
		for(int row=0; row<BOARD_SIZE; row++){
			for(int col=0; col<BOARD_SIZE; col++){
				JButton button = new JButton();
				button.setFont(new Font("Times New Roman", 1, 225));
				super.add(button);
				this.board[row][col] = button;
				button.addActionListener(this);
			}
		}
	}
	
	public void startGame(){
		crossTurn = true;
	}

	@Override
	public void actionPerformed(ActionEvent E) {
		JButton clickedButton = (JButton) E.getSource();
		
		if(clickedButton.getText().equals("")){
			makeMove(clickedButton);
		
			int gameStatus = getGameStatus();
		
			if(gameStatus == INCOMPLETE){
				crossTurn = !crossTurn;
				super.setTitle(crossTurn ? "X's turn" : "0's turn");
			}
			else{
				declareWinner(gameStatus);
				dispose();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid Move");
		}
	}
	
	private void makeMove(JButton button){
		String message = crossTurn ? CROSS_TEXT : ZERO_TEXT;
		button.setText(message);
	}
	
	private int getGameStatus(){
		int row = 0, col = 0;
		String text1="",text2="";
		
		//Row
		for(row=0;row<BOARD_SIZE;row++){
			for(col=0;col<BOARD_SIZE-1;col++){
				text1 = this.board[row][col].getText();
				text2 = this.board[row][col+1].getText();
				
				if(!text1.equals(text2) || text1.equals("")){
					break;
				}
			}
			if(col == BOARD_SIZE-1){
				if(text1.equals(CROSS_TEXT)){
					return X_WINS;
				}
				return ZERO_WINS;
			}
		}
		
		row =0;
		col=0;
		//Col
		for(col=0;col<BOARD_SIZE;col++){
			for(row=0;row<BOARD_SIZE-1;row++){
				text1 = this.board[row][col].getText();
				text2 = this.board[row + 1][col].getText();
				
				if(!text1.equals(text2) || text1.equals("")){
					break;
				}
			}
			if(row == BOARD_SIZE-1){
				if(text1.equals(CROSS_TEXT)){
					return X_WINS;
				}
				return ZERO_WINS;
			}
		}
		
		row=0;
		col=0;
		//Left-Diagonal
		for(row=0;row<BOARD_SIZE-1;row++,col++){
			text1 = this.board[row][col].getText();
			text2 = this.board[row+1][col+1].getText();
			
			if(!text1.equals(text2) || text1.equals("")){
				break;
			}	
		}
		if(row == BOARD_SIZE-1){
			if(text1.equals(CROSS_TEXT)){
				return X_WINS;
			}
			return ZERO_WINS;
		}
		
		row=BOARD_SIZE-1;
		col=0;
		//Right-Diagonal
		for(col=0;col<BOARD_SIZE-1;col++,row--){
			text1 = this.board[row][col].getText();
			text2 = this.board[row-1][col+1].getText();
			
			if(!text1.equals(text2) || text1.equals("")){
				break;
			}	
		}
		if(col == BOARD_SIZE-1){
			if(text1.equals(CROSS_TEXT)){
				return X_WINS;
			}
			return ZERO_WINS;
		}
		
		row=0;
		col=0;
		//Incomplete
		for(row=0;row<BOARD_SIZE;row++){
			for(col=0;col<BOARD_SIZE;col++){
				text1 = this.board[row][col].getText();
				
				if(text1.equals("")){
				return INCOMPLETE;
				}
			}
			
		}
		
		return TIE;
		
	}
	
	private void declareWinner(int status){
		if(status == 2){
			JOptionPane.showMessageDialog(null, "TIE");
			return;
		}
		String message = (status==0) ? "X Wins" : "Zero Wins";
		JOptionPane.showMessageDialog(null, message);
	}

}
