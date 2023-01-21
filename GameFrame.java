// Name: Manan Dua
// Course: ICS3UI
// Date: June 7, 2022
// Teacher: Mr. Dyck
// School: KCI
// Brief Description of Program: This part of the program will let 2 players, X and O take turns playing. The program will then decied if their was a winner or if it was a tie.
//////////////////////////////////////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;

public class GameFrame {
  //Global variables
  public static int counter = 0;
  public static int counter1 = 6;
  public static int Loopcount = 0;
  public static boolean win = false;
  JLabel Text = new JLabel("Timer");
  JLabel timer = new JLabel("5");
  JLabel xScore = new JLabel();
  JLabel oScore = new JLabel();
  JLabel Score = new JLabel("Scores:");
  private int xscore;
  private int oscore;
  Timer timer2 = new Timer();
  //This starts a timer as soon as the game starts, if the player fails to play in time, the computer will play for them
  //Revision, added a timer
  void Timer1(JFrame f, JButton[] b, JLabel l) {
    f.repaint();
    Loopcount = 0;
    Text.setVisible(true);
    Text.setBounds(10, 30, 300, 300);
    Text.setForeground(Color.WHITE);
    Text.setFont(new Font("Serif", Font.BOLD, 30));
    f.add(Text);
    timer.setVisible(true);
    timer.setForeground(Color.WHITE);
    timer.setFont(new Font("Serif", Font.BOLD, 30));
    timer.setBounds(40, 65, 300, 300);
    f.add(timer);
    timer2.cancel();
    timer2 = new Timer();
    TimerTask task = new TimerTask() {
      int counter = 10;

      @Override
      public void run() {
        if (Loopcount < 1) {
          counter1--;
          timer.setText(String.valueOf(counter1));
          if (counter1 == 0) {
            if (counter % 2 == 0) {
              for (int h = 0; h < 1;) {
                int rand = (int) Math.floor(Math.random() * (9));
                if (b[rand].isEnabled()) {
                  SetPlay(b[rand],l, b, f);
                  break;
                }
              }
              counter++;
            } else {
              for (int h = 0; h < 1;) {
                int rand = (int) Math.floor(Math.random() * (9));
                if (b[rand].isEnabled()) {
                  SetPlay(b[rand],l, b, f);
                  break;
                }
              }
              counter++;
            }
            counter1 = 6;
          }
        }
      }
    };
    timer2.scheduleAtFixedRate(task, 0, 1000);
  }
  // Adds scores to JFrame and Updates them when there is a winner
  void Scores(JFrame f) {
    Score.setVisible(true);
    Score.setForeground(Color.WHITE);
    Score.setFont(new Font("Serif", Font.BOLD, 30));
    Score.setBounds(360, 100, 200, 50);
    f.add(Score);
    xScore.setVisible(true);
    xScore.setForeground(Color.WHITE);
    xScore.setFont(new Font("Serif", Font.BOLD, 30));
    xScore.setBounds(390, 150, 200, 50);
    xScore.setText("X: " + xscore);
    f.add(xScore);
    oScore.setVisible(true);
    oScore.setForeground(Color.WHITE);
    oScore.setFont(new Font("Serif", Font.BOLD, 30));
    oScore.setBounds(390, 200, 200, 50);
    oScore.setText("O: " + oscore);
    f.add(oScore);
  }
  //Will update the board with either an X or O when a button is clicked or the player has ran out of time
  void SetPlay(JButton b, JLabel l, JButton[] p, JFrame f) {
    b.setFont(new Font("Serif", Font.BOLD, 47));
    if (counter % 2 == 0) {
      b.setText("X");
      l.setText("O's turn");
    } else {
      b.setText("O");
      l.setText("X's turn");
    }
    if (counter == 8) {
      l.setText("Draw");
      Retry(p, l, f);
    }
    counter++;
    b.setEnabled(false);
    CheckWin(p, l, f);
    counter1 = 6;
  }
  //This methods checks if someone has one the game after every turn
  void CheckWin(JButton b[], JLabel l, JFrame f) {
    for (int j = 0; j <= 6; j += 3) {
      if (b[j].getText() == "X" && b[j + 1].getText() == "X" && b[j + 2].getText() == "X") {
        //If a win has been found, highlight the winning combo in green
        b[j].setBackground(Color.GREEN);
        b[j + 1].setBackground(Color.GREEN);
        b[j + 2].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
          b[i].setEnabled(false);
        }
        l.setText("X wins");
        win = true;
        xscore++;
        xScore.setText("X: " + xscore);

        Retry(b, l, f);
      }
      if (b[j].getText() == "O" && b[j + 1].getText() == "O" && b[j + 2].getText() == "O") {
        b[j].setBackground(Color.GREEN);
        b[j + 1].setBackground(Color.GREEN);
        b[j + 2].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
          b[i].setEnabled(false);
        }
        l.setText("O wins");
        win = true;
        oscore++;
        oScore.setText("O: " + oscore);

        Retry(b, l, f);
      }
    }
    for (int j = 0; j < 3; j++) {
      if (b[j].getText() == "X" && b[j + 3].getText() == "X" && b[j + 6].getText() == "X") {
        b[j].setBackground(Color.GREEN);
        b[j + 3].setBackground(Color.GREEN);
        b[j + 6].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
          b[i].setEnabled(false);
        }
        l.setText("X wins");
        win = true;
        xscore++;
        xScore.setText("X: " + xscore);

        Retry(b, l, f);
      }
      if (b[j].getText() == "O" && b[j + 3].getText() == "O" && b[j + 6].getText() == "O") {
        b[j].setBackground(Color.GREEN);
        b[j + 3].setBackground(Color.GREEN);
        b[j + 6].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
          b[i].setEnabled(false);
        }
        l.setText("O wins");
        win = true;
        oscore++;
        oScore.setText("O: " + oscore);

        Retry(b, l, f);
      }
    }
    if (b[0].getText() == "X" && b[4].getText() == "X" && b[8].getText() == "X") {
      b[0].setBackground(Color.GREEN);
      b[4].setBackground(Color.GREEN);
      b[8].setBackground(Color.GREEN);
      for (int i = 0; i < 9; i++) {
        b[i].setEnabled(false);
      }
      l.setText("X wins");
      win = true;
      xscore++;
      xScore.setText("X: " + xscore);

      Retry(b, l, f);
    }
    if (b[2].getText() == "X" && b[4].getText() == "X" && b[6].getText() == "X") {
      b[2].setBackground(Color.GREEN);
      b[4].setBackground(Color.GREEN);
      b[6].setBackground(Color.GREEN);
      for (int i = 0; i < 9; i++) {
        b[i].setEnabled(false);
      }
      l.setText("X wins");
      win = true;
      xscore++;
      xScore.setText("X: " + xscore);

      Retry(b, l, f);
    }
    if (b[0].getText() == "O" && b[4].getText() == "O" && b[8].getText() == "O") {
      b[0].setBackground(Color.GREEN);
      b[4].setBackground(Color.GREEN);
      b[8].setBackground(Color.GREEN);
      for (int i = 0; i < 9; i++) {
        b[i].setEnabled(false);
      }
      l.setText("O wins");
      win = true;
      oscore++;
      oScore.setText("O: " + oscore);

      Retry(b, l, f);
    }
    if (b[2].getText() == "O" && b[4].getText() == "O" && b[6].getText() == "O") {
      b[2].setBackground(Color.GREEN);
      b[4].setBackground(Color.GREEN);
      b[6].setBackground(Color.GREEN);
      for (int i = 0; i < 9; i++) {
        b[i].setEnabled(false);
      }
      l.setText("O wins");
      win = true;
      oscore++;
      oScore.setText("O: " + oscore);

      Retry(b, l, f);
    }
  }
  //If there is a winner or draw game, this will add a retry button which can reset the board but keep the same scores throughout
  void Retry(JButton b[], JLabel l, JFrame f) {
    Loopcount = 1;
    counter1 = 0;
    Text.setVisible(false);
    timer.setVisible(false);
    l.setBounds(180, 20, 200, 100);
    JButton b1 = new JButton("Retry");
    b1.setBackground(Color.WHITE);
    b1.setFont(new Font("Serif", Font.BOLD, 21));
    b1.setBounds(190, 375, 100, 50);
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        f.repaint();
        for (int i = 0; i < 9; i++) {
          b[i].setText("");
          b[i].setBackground(Color.WHITE);
          b[i].setEnabled(true);
        }
        l.setText("X's turn");
        l.setBounds(200, 20, 200, 100);
        counter = 0;
        Loopcount = 0;
        counter1 = 6;
        b1.setVisible(false);
        Timer1(f, b, l);
      }
    });
    f.add(b1);
  }
}