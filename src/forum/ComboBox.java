package forum;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ComboBox extends JFrame implements ActionListener {
  JPanel panel = new JPanel();
  JButton button;
  JComboBox comboBox;

  ComboBox() {
    String opt[] = { "Option 1", "Option 2", "Option 3", "Option 4", "Option 5" };
    comboBox = new JComboBox(opt);
    button = new JButton("Submit");

    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 24));
    panel.add(comboBox);
    panel.add(button);

    add(panel);

    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Selected = " + comboBox.getSelectedItem());

  }

  public static void main(String args[]) {
    JFrame frame = new ComboBox();
    frame.setSize(300, 150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
