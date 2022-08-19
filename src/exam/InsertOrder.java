package exam;

import java.sql.*;
import javax.swing.*;

public class InsertOrder extends OrderForm {
  private Connect conn;

  InsertOrder(Connect _conn) {
    conn = _conn;
    formTitle.setText("Insert Order Form");
  }

  private String generateID() {
    ResultSet rs = null;
    ResultSetMetaData rsm = null;

    try {
      rs = conn
          .executeQuery(
              "SELECT COUNT(*) as total FROM headset WHERE JenisHeadset='" + headsetTypeField.getSelectedItem() + "'");
      rsm = rs.getMetaData();

      System.out.println(rsm.getColumnCount());

      int index = 0;

      while (rs.next()) {
        index = rs.getInt("total") + 1;
      }

      if (index == 0) {
        throw new Exception("index nya 0");
      }

      String formattedNum = String.format("%03d", index);
      String id = headsetTypeField.getSelectedIndex() == 1 ? "TW" : "HP";

      return id + formattedNum;
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "fail to generate id", "Error", JOptionPane.ERROR_MESSAGE);
      return "";
    }
  }

  public void onSubmit() {
    try {
      String buyerName = buyerNameField.getText();
      Object headsetType = headsetTypeField.getSelectedItem();
      Object brand = brandField.getSelectedItem();
      int wireless = headsetTypeField.getSelectedIndex() == 1 ? 1 : 0;
      String playtime = playtimeField.getText().equals("") ? "0" : playtimeField.getText();
      int withMic = withMicField.isSelected() ? 1 : 0;
      int qty = (Integer) qtyField.getValue();

      conn.executeUpdate(
          "INSERT INTO `headset` (`HeadsetID`, `NamaPembeli`, `JenisHeadset`, `Merk`, `Wireless`, `Playtime`, `Mic`, `Qty`, `TotalHarga`) VALUES ('"
              + generateID() + "', '" + buyerName + "', '" + headsetType + "', '" + brand + "', '" + wireless + "', '"
              + playtime + "', '" + withMic + "', '" + qty + "', '" + generateTotal() + "');");

      int res = JOptionPane.showOptionDialog(null, "Successfully add order", "Info",
          JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
          new Object[] { "Okay" }, JOptionPane.YES_OPTION);
      if (res == JOptionPane.YES_OPTION) {
        setVisible(false);
        new OrderList();
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
