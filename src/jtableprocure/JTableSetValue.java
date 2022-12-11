package jtableprocure;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableSetValue  extends JFrame {
  public JTableSetValue() {
    final AbstractTableModel model = new MyModel();
    final JTable table = new JTable(model);
    getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    model.setValueAt(new Integer(1), 0, 0);

    JButton button = new JButton("Increment selected cell");
    getContentPane().add(button, BorderLayout.SOUTH);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        int column = table.convertColumnIndexToModel(table.getSelectedColumn());
        int currentValue = ((Integer) model.getValueAt(row, column)).intValue();
        model.setValueAt(new Integer(currentValue + 1), row, column);
      }
    });

    pack();
  }
  public static void main(String arg[]) {
	  JTableSetValue ex2 = new JTableSetValue();
    ex2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ex2.setVisible(true);
  }
}


class MyModel extends AbstractTableModel {
  private int[][] table = { new int[3], new int[3], new int[3] };

  public MyModel() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        table[i][j] = i * j;
      }
    }
  }

  public int getColumnCount() {
    return table.length;
  }

  public int getRowCount() {
    return table[0].length;
  }

  public Object getValueAt(int r, int c) {
    return new Integer(table[r][c]);
  }

  public void setValueAt(Object obj, int r, int c) {
    table[r][c] = ((Integer) obj).intValue();
    fireTableCellUpdated(r, c);
  }
}