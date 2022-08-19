package exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonEdit extends DefaultCellEditor {
  protected JButton button;
  private String headsetId;
  private Boolean clicked;

  public ButtonEdit(JTextField headsetIdTextField) {
    super(headsetIdTextField);

    button = new JButton();
    button.setText("Edit");
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
      new EditOrder(headsetId);
      
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