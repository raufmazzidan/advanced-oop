package forum;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonAndCheckbox extends JFrame implements ActionListener {
  JPanel panel = new JPanel();
  JButton button;
  JCheckBox checkbox1;
  JCheckBox checkbox2;
  JCheckBox checkbox3;

  ButtonAndCheckbox() {
    checkbox1 = new JCheckBox("Option 1");
    checkbox2 = new JCheckBox("Option 2");
    checkbox3 = new JCheckBox("Option 3");
    button = new JButton("Submit");

    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 24));
    panel.add(checkbox1);
    panel.add(checkbox2);
    panel.add(checkbox3);
    panel.add(button);

    add(panel);

    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String selected = "";

    if (checkbox1.isSelected()) {
      selected += "Option 1, ";
    }

    if (checkbox2.isSelected()) {
      selected += "Option 2, ";
    }

    if (checkbox3.isSelected()) {
      selected += "Option 3, ";
    }
    JOptionPane.showMessageDialog(null, "Selected = " + selected);

  }

  public static void main(String args[]) {
    JFrame frame = new ButtonAndCheckbox();
    frame.setSize(300, 150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
