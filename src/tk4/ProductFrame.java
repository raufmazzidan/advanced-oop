package tk4;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

public final class ProductFrame extends JFrame {

  // table
  private JScrollPane scrollPane = new JScrollPane();
  private JTable table = new JTable();
  private DefaultTableModel dtm = new DefaultTableModel();

  // label
  private JLabel titleLabel = new JLabel("Product");

  // connection
  private Connect conn = new Connect();

  private ResultSet rs = null;
  private ResultSetMetaData rsm = null;
  private Vector<String> headerTable = new Vector<String>();
  private Vector<Vector<String>> dataTable = new Vector<Vector<String>>();

  public ProductFrame() {
    createForm();

    this.add(titleLabel, BorderLayout.NORTH);
    this.add(scrollPane, BorderLayout.CENTER);

    scrollPane.setViewportView(table);
    table.setModel(dtm);

    refreshData();
    
    for (int i = 0; i < headerTable.size(); i++) {
      dtm.addColumn(headerTable.get(i));
    }

    for (int i = 0; i < dataTable.size(); i++) {
      dtm.addRow(dataTable.get(i));
    }

    this.setVisible(true);
  }

  public void refreshData() {
    try {
      rs = conn.executeQuery("SELECT * FROM product");
      rsm = rs.getMetaData();

      int totalCol = rsm.getColumnCount();

      // loop for header
      for (int i = 1; i <= totalCol; i++) {
        headerTable.add(rsm.getColumnName(i));
      }

      // loop for data
      while (rs.next()) {
        Vector<String> row = new Vector<>();
        for (int i = 1; i <= totalCol; i++) {
          row.add(rs.getString(i));
        }
        dataTable.add(row);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void createForm() {
    this.setTitle("Product Form");
    this.setSize(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }
}
