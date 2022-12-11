package SwingJTable;

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

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JTableAmountModel extends JPanel implements TableModelListener {
	private boolean DEBUG = true;

	int COL_PRICE = 2;
	int COL_QUANTITY = 3;
	int COL_AMOUNT = 4;
	public JTableAmountModel() {
		super(new GridLayout(1, 0));

		MyTableModel model = new MyTableModel();
		final JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.getModel().addTableModelListener(this);

		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("printDebugData()...");
		System.out.println("Value of data: ");
		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public void tableChanged(TableModelEvent ev) {

		System.out.println("tableChanged()...");

		int firstRow = ev.getFirstRow();
		int column = ev.getColumn();
		MyTableModel model = (MyTableModel) ev.getSource();
		String colName = model.getColumnName(column);
		Object data = model.getValueAt(firstRow, column);
		System.out.println("firstRow:" + firstRow + ", column:" + column + ", colName:" + colName + ", data:" + data);
	}

	class MyTableModel extends AbstractTableModel {

		private String[] columnNames = { "Good", "Unit Name", "Price", "Quantity", "Amount" };
		private Object[][] data;

		public MyTableModel() {
			System.out.println("MyTableModel()...");
			Goods_DAO dao = new Goods_DAO();
			ArrayList<Goods> goods = dao.viewGoodssArrays();
			Object[][] lsit = new Object[goods.size()][goods.size()];
			int row = 0;
			
			for(Goods good : goods) {
				Object obj[] = new Object[5];
				obj[0] = good.getId();
				obj[1] = good.getGname();
				obj[2] = good.getPrice();
				obj[3] = good.getQty();
				obj[4] = good.getAmount();
				lsit [row] = obj;
				row++;
			}
			this.data = lsit;
		}

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
		
		public boolean isCellEditable(int row, int col) {
			if (col == 3) {
				return true;
			} else {
				return false;
			}
		}

		public void setValueAt(Object value, int row, int col) {
			System.out.println("setValueAt()... row:" + row + "x" + "col:" + col);
			if (DEBUG) {
				System.out.println("Setting value at " + row + "," + col + " to " + value + " (an instance of "
						+ value.getClass() + ")");
			}

			data[row][col] = value;
			fireTableCellUpdated(row, col);
			if (col == COL_QUANTITY) {
				try {
					String strQuantity = value.toString();
					Integer intQuantity = Integer.parseInt(strQuantity);
					int quantity = intQuantity.intValue();
					String strPrice = data[row][COL_PRICE].toString();
					Double intPrice = Double.parseDouble(strPrice);
					double price = intPrice.intValue();
					double amount = quantity * price;
					System.out.println("quantity:" + quantity + ", price:" + price + ", amount:" + amount);
					data[row][COL_AMOUNT] = amount;
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
				}
			}
			fireTableCellUpdated(row, COL_QUANTITY);

			if (DEBUG) {
				System.out.println("New value of data:");
				printDebugData();
			}
		}

		private void printDebugData() {
			System.out.println("printDebugData()...");
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
		JFrame frame = new JFrame("JTableAmount");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JTableAmountModel newContentPane = new JTableAmountModel();
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
}
