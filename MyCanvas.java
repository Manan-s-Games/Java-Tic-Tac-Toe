// Name: Mehek Thakkar
// Course: ICS3UI
// Date: June 7, 2022
// Teacher: Mr. Dyck
// School: KCI
// Brief Description of Program: This is the game boarder for the game tic-tac-toe
///////////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;

public class MyCanvas extends JComponent {
  public void paint(Graphics g) {
    // These lines of code will make the board/ outline for the game
    g.drawRect(200, 100, 1, 225);
    g.drawRect(275, 100, 1, 225);
    g.drawRect(125, 175, 225, 1);
    g.drawRect(125, 250, 225, 1);
  }
}