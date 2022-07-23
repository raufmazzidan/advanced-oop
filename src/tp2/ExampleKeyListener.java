package tp2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExampleKeyListener implements KeyListener {
  JFrame frame;
  JTextArea textArea;
  JLabel statusListener;

  ExampleKeyListener() {
    frame = new JFrame();

    textArea = new JTextArea(4, 23);
    textArea.addKeyListener(this);

    statusListener = new JLabel("Key Status...");

    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

    frame.add(textArea);
    frame.add(statusListener);

    frame.setTitle("Example Key Listener");
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    statusListener.setText("Key Pressed");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    statusListener.setText("Key Released");
  }

  @Override
  public void keyTyped(KeyEvent e) {
    statusListener.setText("Key Typed");
  }

  public static void main(String argvs[]) {
    new ExampleKeyListener();
  }
}
