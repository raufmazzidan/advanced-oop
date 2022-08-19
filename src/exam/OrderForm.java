package exam;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class OrderForm extends JFrame {
  JPanel mainPanel = new JPanel();
  JPanel actionPanel = new JPanel();

  public JLabel formTitle = new JLabel("Order Form", JLabel.CENTER);
  Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 14);

  JPanel formPanel = new JPanel();

  JLabel buyerNameLabel;
  JTextField buyerNameField;

  JLabel headsetTypeLabel;
  JComboBox<String> headsetTypeField;
  String headsetTypeOption[] = { "", "TWS", "Headphone" };

  JLabel brandLabel;
  JComboBox<String> brandField;
  String brandTWSOption[] = { "", "Sony", "Aukey", "Xiaomi" };
  String brandHeadsetOption[] = { "", "Sennheiser", "Nokia", "Philips" };

  JLabel playtimeLabel;
  JTextField playtimeField;

  JLabel withMicLabel;
  JCheckBox withMicField;

  JLabel qtyLabel;
  JSpinner qtyField;

  JButton buttonSubmit;

  Double convertToNum(String str) {
    try {
      Double num = Double.parseDouble(str);
      return num;
    } catch (NumberFormatException e) {
      return -1.0;
    }
  }

  int generateTotal() {
    int result = 0;
    if (withMicField.isSelected()) {
      if (brandField.getSelectedItem().equals("Sony")) {
        result = 2000000;
      } else if (brandField.getSelectedItem().equals("Aukey")) {
        result = 1800000;
      } else if (brandField.getSelectedItem().equals("Xiaomi")) {
        result = 1500000;
      } else if (brandField.getSelectedItem().equals("Sennheiser")) {
        result = 2500000;
      } else if (brandField.getSelectedItem().equals("Nokia")) {
        result = 1800000;
      } else if (brandField.getSelectedItem().equals("Philips")) {
        result = 3000000;
      }
    } else {
      if (brandField.getSelectedItem().equals("Sony")) {
        result = 1500000;
      } else if (brandField.getSelectedItem().equals("Aukey")) {
        result = 1400000;
      } else if (brandField.getSelectedItem().equals("Xiaomi")) {
        result = 1000000;
      } else if (brandField.getSelectedItem().equals("Sennheiser")) {
        result = 2200000;
      } else if (brandField.getSelectedItem().equals("Nokia")) {
        result = 1500000;
      } else if (brandField.getSelectedItem().equals("Philips")) {
        result = 2500000;
      }
    }
    return result * (Integer) qtyField.getValue();
  }

  void onSubmit() {
  }

  OrderForm() {
    mainPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
    mainPanel.setLayout(new BorderLayout(16, 16));

    formTitle.setFont(fontTitle);
    mainPanel.add(formTitle, BorderLayout.NORTH);

    formPanel.setLayout(new GridLayout(0, 2, 16, 16));

    buyerNameLabel = new JLabel("Nama Pembeli");
    buyerNameField = new JTextField();
    formPanel.add(buyerNameLabel);
    formPanel.add(buyerNameField);

    headsetTypeLabel = new JLabel("Jenis Headset");
    headsetTypeField = new JComboBox<String>(headsetTypeOption);
    formPanel.add(headsetTypeLabel);
    formPanel.add(headsetTypeField);

    brandLabel = new JLabel("Brand");
    brandField = new JComboBox<String>();
    brandField.setEnabled(false);
    formPanel.add(brandLabel);
    formPanel.add(brandField);

    playtimeLabel = new JLabel("Playtime");
    playtimeField = new JTextField();
    playtimeField.setEditable(false);
    playtimeField.setEnabled(false);
    formPanel.add(playtimeLabel);
    formPanel.add(playtimeField);

    withMicLabel = new JLabel("Microphone");
    withMicField = new JCheckBox();
    formPanel.add(withMicLabel);
    formPanel.add(withMicField);

    qtyLabel = new JLabel("Quantity");
    qtyField = new JSpinner();
    formPanel.add(qtyLabel);
    formPanel.add(qtyField);

    mainPanel.add(formPanel, BorderLayout.CENTER);

    buttonSubmit = new JButton("Submit");

    actionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    actionPanel.add(buttonSubmit);

    mainPanel.add(actionPanel, BorderLayout.SOUTH);

    headsetTypeField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        brandField.setEnabled(headsetTypeField.getSelectedIndex() != 0);

        String[] options;
        if (headsetTypeField.getSelectedIndex() == 1) {
          options = brandTWSOption;
          playtimeField.setEditable(true);
          playtimeField.setEnabled(true);
        } else {
          options = brandHeadsetOption;
          playtimeField.setText(null);
          playtimeField.setEditable(false);
          playtimeField.setEnabled(false);
        }
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(options);
        brandField.setModel(model);
      }
    });

    buttonSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String errorMessage = "";

        if (buyerNameField.getText().length() == 0) {
          errorMessage = "Nama Pembeli Harus Diisi!";
        } else if (headsetTypeField.getSelectedIndex() == 0) {
          errorMessage = "Jenis Headset Harus Diisi!";
        } else if (brandField.getSelectedIndex() == 0) {
          errorMessage = "Brand Harus Diisi!";
        } else if (playtimeField.isEnabled() && convertToNum(playtimeField.getText()) < 0) {
          errorMessage = "Playtime harus diisi!";
        } else if (((Integer) qtyField.getValue() < 1) || ((Integer) qtyField.getValue() > 10)) {
          errorMessage = "Quantity harus diantara 1 dan 10!";
        }

        if (errorMessage.equals("")) {
          onSubmit();
        } else {
          JOptionPane.showMessageDialog(null, errorMessage, "Informasi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    add(mainPanel);
    setTitle("SoundBooster Shop");
    setSize(600, 400);
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
