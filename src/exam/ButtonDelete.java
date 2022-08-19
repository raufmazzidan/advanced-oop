package exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonDelete extends DefaultCellEditor {
  protected JButton button;
  private String headsetId;
  private Boolean clicked;
  Connect conn;

  public ButtonDelete(JTextField headsetIdTextField, Connect _conn) {
    super(headsetIdTextField);

    conn = _conn;
    button = new JButton();
    button.setText("Delete");
    button.setOpaque(true);

    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object obj,
      boolean selected, int row, int col) {
    headsetId = (obj == null) ? "" : obj.toString();
    clicked = true;
    return button;
  }

  @Override
  public Object getCellEditorValue() {

    if (clicked) {
      int pilih = JOptionPane.showConfirmDialog(null, "Apakah anda yakin?", "Confirmation", JOptionPane.YES_NO_OPTION);
      if (pilih == JOptionPane.YES_OPTION) {
        try {
          conn.executeUpdate("DELETE FROM headset WHERE HeadsetID = '" + headsetId + "'");
          new OrderList();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    clicked = false;
    return new String(headsetId);
  }

  @Override
  public boolean stopCellEditing() {
    clicked = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}