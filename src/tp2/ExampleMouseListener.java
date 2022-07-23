package tp2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExampleMouseListener implements MouseListener {
  JFrame frame;
  JLabel label;

  ExampleMouseListener() {
    frame = new JFrame();
    frame.addMouseListener(this);

    label = new JLabel();

    frame.setLayout(new FlowLayout(FlowLayout.CENTER));
    frame.add(label);
    frame.setTitle("Example Mouse Listener");
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    label.setText("Clicked");
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    label.setText("Entered");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    label.setText("Exited");
  }

  @Override
  public void mousePressed(MouseEvent e) {
    label.setText("Pressed");
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    label.setText("Released");
  }

  public static void main(String argvs[]) {
    new ExampleMouseListener();
  }
}
