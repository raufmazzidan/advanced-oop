package tp2;

import java.awt.*;
import javax.swing.*;

public class ExampleBorderLayout {
  JFrame frame;

  ExampleBorderLayout() {
    frame = new JFrame();

    frame.setLayout(new BorderLayout());

    frame.add(new JLabel("North is Here", JLabel.CENTER), BorderLayout.NORTH);
    frame.add(new JLabel("South is Here", JLabel.CENTER), BorderLayout.SOUTH);
    frame.add(new JLabel("West is Here", JLabel.CENTER), BorderLayout.WEST);
    frame.add(new JLabel("East is Here", JLabel.CENTER), BorderLayout.EAST);
    frame.add(new JLabel("Center is Here", JLabel.CENTER), BorderLayout.CENTER);

    frame.setTitle("Example Border Layout");
    frame.setSize(500, 250);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String argvs[]) {
    new ExampleBorderLayout();
  }

}
