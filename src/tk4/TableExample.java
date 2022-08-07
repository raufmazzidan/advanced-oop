package tk4;

import java.util.*;

import javax.swing.*;

public class TableExample {
  JFrame f;

  TableExample() {
    f = new JFrame();
    Vector<Vector<String>> data = new Vector<>();
    Vector<String> column = new Vector<>();

    column.add("A");
    column.add("B");
    column.add("C");

    Vector<String> row = new Vector<>();
    row.add("1");
    row.add("2");
    row.add("3");

    data.add(row);
    data.add(row);
    data.add(row);

    JTable jt = new JTable(data, column);
    jt.setBounds(30, 40, 200, 300);
    JScrollPane sp = new JScrollPane(jt);
    f.add(sp);
    f.setSize(300, 400);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    new TableExample();
  }
}