/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package MySwing;

/*
 * TableRenderDemo.java requires no other files.
 */

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableRenderDemo extends JPanel implements TableModelListener {

	private boolean DEBUG = true;
	JTextField txt_id;
	JButton submit;

	class BtnSubmit extends JButton {
		public BtnSubmit() {
			setBounds(600, 400, 70, 35);
			setBackground(new Color(0x02315d));
			setText("SUBMIT");
			setForeground(Color.white);
			setBorder(null);
			setFocusable(false);
		}
	}

	class TxT_id extends JTextField {
		public TxT_id() {
			setBounds(400, 400, 100, 35);
			setFont(new Font(null, Font.PLAIN, 14));
			setForeground(Color.DARK_GRAY);
			setCaretColor(Color.DARK_GRAY);
		}
	}

	public TableRenderDemo() {
		setLayout(null);
		final JTable table = new JTable(new MyTableModel());
		table.setFillsViewportHeight(true);
		table.getModel().addTableModelListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 40, 750, 300);
		scrollPane.setViewportView(table);

		add(scrollPane);

	}

	class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "Goods", "price", "qty", "total" };

		public Object[][] data = { { "Logitech G402", 1990, 4, 1990 } };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			if (col < 4) {
				return true;
			} else {
				return true;
			}

		}

		public void setValueAt(Object value, int row, int col) {
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			/*int q1 = Integer.parseInt(String.valueOf(getValueAt(row, 1)));
			int q2 = Integer.parseInt(String.valueOf(getValueAt(row, 2)));
			int total = q1 * q2;*/
			data[row][col] = value;
			fireTableCellUpdated(row, col);

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			int numRows = getRowCount();
			int numCols = getColumnCount();

			for (int i = 0; i < numRows; i++) {
				System.out.print("    row " + i + ":");
				for (int j = 0; j < numCols; j++) {
					System.out.print("  " + data[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------------");
		}

	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		JFrame frame = new JFrame("TableRenderDemo");
		frame.setLocation(500, 200);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		TableRenderDemo newContentPane = new TableRenderDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void tableChanged(TableModelEvent ev) {
		int colPrice = 2;
    	int firstRow = ev.getFirstRow();
    	int column = ev.getColumn();
    	DefaultTableModel model = (DefaultTableModel)ev.getSource();
    	String colName = model.getColumnName(column);
    	Object data = model.getValueAt(firstRow, column);
    	System.out.println("firstRow:" + firstRow + ", column:" + column +
    			", colName:" + colName + ", data:" + data);
    	try {
    		String strData = data.toString();
        	Integer value = Integer.parseInt(strData);
        	int quantity = value.intValue();
        	data = model.getValueAt(firstRow, colPrice);
        	value = (Integer)data;
        	int price = value.intValue();
        	int amount = quantity * price;
        	System.out.println("quantity:" + quantity + ", price:" + price +
        			", amount:" + amount);
        	model.setValueAt(new Integer(amount), firstRow, column);
    	} catch(NumberFormatException ex) {
    		ex.printStackTrace();
    	}


	}

}
