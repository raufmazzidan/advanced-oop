package tp2;

import java.awt.*;
import javax.swing.*;

public class ExampleGridLayout {
  JFrame frame;

  ExampleGridLayout() {
    frame = new JFrame();

    frame.setLayout(new GridLayout(2, 4, 8, 8));

    frame.add(new JButton("Button A"));
    frame.add(new JButton("Button B"));
    frame.add(new JButton("Button C"));
    frame.add(new JButton("Button D"));
    frame.add(new JButton("Button E"));
    frame.add(new JButton("Button F"));
    frame.add(new JButton("Button J"));

    frame.setTitle("Example Grid Layout");
    frame.setSize(500, 250);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String argvs[]) {
    new ExampleGridLayout();
  }
}
