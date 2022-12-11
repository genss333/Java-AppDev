package MySwing;

import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.Component;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
public class MyRenderer extends JLabel implements TableCellRenderer {
   public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus, int row,
      int col) {
      DefaultTableCellRenderer renderer =
         new DefaultTableCellRenderer();
      Component c = renderer.getTableCellRendererComponent(table,
         value, isSelected, hasFocus, row, col);
      String s = "";
      if (col == 3) {
         DecimalFormat dFormat = new DecimalFormat("#0.0");
         Double d = (Double) value;
         s = dFormat.format(d);
         c = renderer.getTableCellRendererComponent(table, s,
            isSelected, hasFocus, row, col);
         ((JLabel) c).setHorizontalAlignment(SwingConstants.RIGHT);
      }
      return c;
   }
}