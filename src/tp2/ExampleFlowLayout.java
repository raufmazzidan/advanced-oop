package tp2;

import java.awt.*;
import javax.swing.*;

public class ExampleFlowLayout {
  JFrame frame;

  ExampleFlowLayout() {
    frame = new JFrame();

    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

    frame.add(new JButton("Button A"));
    frame.add(new JButton("Button B"));
    frame.add(new JButton("Button C"));
    frame.add(new JButton("Button D"));
    frame.add(new JButton("Button E"));

    frame.setTitle("Example Flow Layout");
    frame.setSize(500, 250);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String argvs[]) {
    new ExampleFlowLayout();
  }

}
