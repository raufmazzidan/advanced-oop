package tk4;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class InsertFrame extends JFrame {
  private Connect conn = new Connect();
  
  JPanel panel = new JPanel();
  JPanel formPanel = new JPanel();

  JLabel nameLabel;
  JTextField nameField;

  JLabel typeLabel;
  JComboBox<String> typeField;

  JLabel priceLabel;
  JSpinner priceField;

  JLabel stockLabel;
  JSpinner stockField;

  JButton buttonSubmit;

  String typeOption[] = { "Drink", "Food" };

  InsertFrame() {
    panel.setBorder(new EmptyBorder(16, 16, 16, 16));
    panel.setLayout(new BorderLayout(16, 16));

    panel.add(new JLabel("Product", JLabel.CENTER), BorderLayout.NORTH);

    formPanel.setLayout(new GridLayout(0, 2, 16, 16));

    nameLabel = new JLabel("Name");
    nameField = new JTextField();
    formPanel.add(nameLabel);
    formPanel.add(nameField);

    typeLabel = new JLabel("Type");
    typeField = new JComboBox<String>(typeOption);
    formPanel.add(typeLabel);
    formPanel.add(typeField);

    priceLabel = new JLabel("Price");
    priceField = new JSpinner();
    formPanel.add(priceLabel);
    formPanel.add(priceField);

    stockLabel = new JLabel("Stock");
    stockField = new JSpinner();
    formPanel.add(stockLabel);
    formPanel.add(stockField);

    panel.add(formPanel, BorderLayout.CENTER);

    buttonSubmit = new JButton("INSERT");
    panel.add(buttonSubmit, BorderLayout.SOUTH);

    add(panel);

    buttonSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String errorMessage = "";

        if (nameField.getText().length() == 0) {
          errorMessage = "Name Harus Diisi!";
        } else if ((Integer) priceField.getValue() < 1 || (Integer) priceField.getValue() > 200000) {
          errorMessage = "Price harus diantara 1 dan 200000";
        } else if ((Integer) stockField.getValue() < 1 || (Integer) stockField.getValue() > 100) {
          errorMessage = "Stock harus diantara 1 dan 100";
        }

        if (errorMessage.equals("")) {
          try {
            conn.executeUpdate("INSERT INTO `product` (`ID`, `Name`, `Type`, `Price`, `Stock`) VALUES (NULL, '" + nameField.getText()+ "', '" + typeField.getSelectedItem() + "', '" + (Integer) priceField.getValue() + "', '" + (Integer) stockField.getValue() + "');");
              // JOptionPane.showMessageDialog(null, "Sukses Insert", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              new ProductFrame();
            } catch (Exception ex) {
            System.out.println(ex);
          }
        } else {
          JOptionPane.showMessageDialog(null, errorMessage, "Informasi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  public static void main(String args[]) {
    JFrame frame = new InsertFrame();
    frame.setTitle("Insert Form");
    frame.setSize(400, 320);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
