package exam;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class OrderList extends JFrame {
  private JPanel mainPanel = new JPanel();
  private JPanel actionCreatePanel = new JPanel();

  // table
  private JScrollPane scrollPane = new JScrollPane();
  private JTable table = new JTable();
  private DefaultTableModel dtm = new DefaultTableModel();

  // label
  private JLabel titleLabel = new JLabel("List Order Headset", JLabel.CENTER);
  Font fontTitle = new Font(Font.SANS_SERIF, Font.BOLD, 14);

  // add button
  private JButton addButton = new JButton("Tambah Order");

  // connection
  private Connect conn = new Connect();

  private ResultSet rs = null;
  private ResultSetMetaData rsm = null;
  private Vector<String> headerTable = new Vector<String>();
  private Vector<Vector<Object>> dataTable = new Vector<Vector<Object>>();

  public OrderList() {
    titleLabel.setFont(fontTitle);

    mainPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
    mainPanel.setLayout(new BorderLayout(16, 16));
    mainPanel.add(titleLabel, BorderLayout.NORTH);
    mainPanel.add(scrollPane, BorderLayout.CENTER);

    actionCreatePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    actionCreatePanel.add(addButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new InsertOrder(conn);
      }
    });

    mainPanel.add(actionCreatePanel, BorderLayout.SOUTH);

    add(mainPanel);

    scrollPane.setViewportView(table);
    table.setModel(dtm);

    getData();

    for (int i = 0; i < headerTable.size(); i++) {
      dtm.addColumn(headerTable.get(i));
    }
    dtm.addColumn("Action");
    dtm.addColumn("");

    table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer("Edit"));
    table.getColumnModel().getColumn(10).setCellRenderer(new ButtonRenderer("Delete"));

    table.getColumnModel().getColumn(9).setCellEditor(new ButtonEdit(new JTextField()));
    table.getColumnModel().getColumn(10).setCellEditor(new ButtonDelete(new JTextField(), conn));

    for (int i = 0; i < dataTable.size(); i++) {
      dtm.addRow(dataTable.get(i));
    }

    setTitle("SoundBooster Shop");
    setSize(900, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void getData() {
    try {
      rs = conn.executeQuery("SELECT * FROM headset");
      rsm = rs.getMetaData();

      int totalCol = rsm.getColumnCount();

      for (int i = 1; i <= totalCol; i++) {
        headerTable.add(rsm.getColumnName(i));
      }

      while (rs.next()) {
        Vector<Object> row = new Vector<>();
        for (int i = 1; i <= totalCol; i++) {
          row.add(rs.getString(i));
        }
        row.add(rs.getString(1));
        row.add(rs.getString(1));
        dataTable.add(row);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    new OrderList();
  }
}

class ButtonRenderer extends JButton implements TableCellRenderer {
  public ButtonRenderer(String _label) {
    setText(_label);
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj,
      boolean selected, boolean focused, int row, int col) {
    return this;
  }

}