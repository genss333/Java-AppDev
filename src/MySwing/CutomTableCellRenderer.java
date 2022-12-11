package MySwing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
public class CutomTableCellRenderer extends DefaultTableCellRenderer 
{   
    private TableCellRenderer mWrappedRenderer; 
    private String text = "Original";
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CutomTableCellRenderer(TableCellRenderer pWrappedRenderer) { 
        mWrappedRenderer = pWrappedRenderer; 
        } 

    public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column) 
    {
        Component cell = mWrappedRenderer.getTableCellRendererComponent(table, value, isSelected,
                   hasFocus, row, column); 


            if( row == 1 )
            {

                JLabel label = (JLabel)cell;
                label.setText(text);
            }
            else
            {
                cell.setBackground( Color.white );
            }

        return cell;
    }
}
