package tp2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FormValidation extends JFrame implements ActionListener {
  JPanel panel = new JPanel();
  JLabel label;
  JTextField textField;
  JButton button;

  FormValidation() {
    label = new JLabel("Name ");
    textField = new JTextField(15);
    button = new JButton("Submit");

    textField.setEditable(true);

    panel.setLayout(new FlowLayout());
    panel.add(label);
    panel.add(textField);
    panel.add(button);

    add(panel);

    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (textField.getText().length() < 6) {
      JOptionPane.showMessageDialog(null, "Nama Minimal 6 Karakter", "Message", JOptionPane.ERROR_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Nama : " + textField.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public static void main(String args[]) {
    JFrame frame = new FormValidation();
    frame.setTitle("Form with Validation");
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
