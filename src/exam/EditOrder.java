package exam;

import java.sql.*;
import javax.swing.*;

public class EditOrder extends OrderForm {
  Connect conn = new Connect();
  String headsetId;
  
  EditOrder(String _headsetId) {
    headsetId = _headsetId;
    getDetail();
    formTitle.setText("Edit Order Form");
  }
  
  void getDetail() {
    try {
      ResultSet rs = conn.executeQuery("SELECT * FROM headset WHERE HeadsetID='" + headsetId + "'");
      while (rs.next()) {
        buyerNameField.setText(rs.getString(2));
        headsetTypeField.setSelectedItem(rs.getString(3));
        brandField.setSelectedItem(rs.getString(4));
        playtimeField.setText(rs.getString(6));
        withMicField.setSelected(Integer.parseInt(rs.getString(7)) > 0 ? true : false);
        qtyField.setValue(Integer.parseInt(rs.getString(8)));
      }
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      JOptionPane.showMessageDialog(null, "fail to get detail", "Error", JOptionPane.ERROR_MESSAGE);
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
          "UPDATE `headset` SET `NamaPembeli` = '" + buyerName + "', `JenisHeadset` = '" + headsetType + "', `Merk` = '" + brand + "', `Wireless` = '" + wireless + "', `Playtime` = '" + playtime + "', `Mic` = '" + withMic + "', `Qty` = '" + qty + "', `TotalHarga` = '" + generateTotal() + "' WHERE `headset`.`HeadsetID` = '" + headsetId + "';");

      int res = JOptionPane.showOptionDialog(null, "Successfully edit order", "Info",
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
