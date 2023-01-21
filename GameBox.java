// Name: Manan Dua and Mehek Thakkar
// Course: ICS3UI
// Date: June 7, 2022
// Teacher: Mr. Dyck
// School: KCI
// Brief Description of Program: This program is the game tic-tac-toe, It creates the frame for the game and adds the button array for user input.
///////////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;
public class GameBox extends JFrame{
  GameBox() {
    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\Tic-Tac-Toe\\Tic-Tac-Toe.png"); 
    //Set the icon of the JFrame to Tic-Tac-Toe
    setIconImage(icon); 
    JLabel text1 = new JLabel();
    // This will make the button array the players will be able to click to place their moves 
    JButton Play[] = new JButton[9]; 
    //This for loop declares each button in the array and sets all of the colours to white
    for (int j = 0; j < 9; j++) {
      Play[j] = new JButton();
      Play[j].setBackground(Color.WHITE);
    }
    GameFrame game = new GameFrame();
    setSize(500, 500);
    getContentPane().setBackground(new Color(102, 0, 133));
    getContentPane().add(new MyCanvas());
    setTitle("Tic-Tac-Toe");
    setResizable(false);
    setVisible(true);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(text1);
    //This is the label stating who's turn it is and who won the game
    text1.setVisible(true);
    text1.setForeground(Color.WHITE);
    text1.setText("X's turn");
    text1.setFont(new Font("Serif", Font.BOLD, 25));
    text1.setBounds(200, 20, 200, 100);
    // These lines of code set the location of each button
    Play[0].setBounds(125, 100, 75, 75);
    Play[1].setBounds(200, 100, 75, 75);
    Play[2].setBounds(275, 100, 75, 75);
    Play[3].setBounds(125, 175, 75, 75);
    Play[4].setBounds(200, 175, 75, 75);
    Play[5].setBounds(275, 175, 75, 75);
    Play[6].setBounds(125, 250, 75, 75);
    Play[7].setBounds(200, 250, 75, 75);
    Play[8].setBounds(275, 250, 75, 75);
    // These lines of code play the move the player chooses to make by going to the class GameFrame and placing a X or an O where the player wants it to go
    Play[0].addActionListener(d -> game.SetPlay(Play[0], text1, Play, this));
    Play[1].addActionListener(d -> game.SetPlay(Play[1], text1, Play, this));
    Play[2].addActionListener(d -> game.SetPlay(Play[2], text1, Play, this));
    Play[3].addActionListener(d -> game.SetPlay(Play[3], text1, Play, this));
    Play[4].addActionListener(d -> game.SetPlay(Play[4], text1, Play, this));
    Play[5].addActionListener(d -> game.SetPlay(Play[5], text1, Play, this));
    Play[6].addActionListener(d -> game.SetPlay(Play[6], text1, Play, this));
    Play[7].addActionListener(d -> game.SetPlay(Play[7], text1, Play, this));
    Play[8].addActionListener(d -> game.SetPlay(Play[8], text1, Play, this));
    // This 'for' loop adds all the buttons to the JFrame
    for (int i = 0; i < 9; i++) {
      add(Play[i]);
    }
    //Adds the scoreboard to the JFrame
    game.Scores(this);
    // This implements the timer
    game.Timer1(this, Play, text1);
  }
}