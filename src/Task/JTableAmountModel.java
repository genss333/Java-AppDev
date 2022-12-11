package Task;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JTableAmountModel extends JPanel implements TableModelListener {
	private boolean DEBUG = true;

	JPanel subpanel;
	int COL_PRICE = 2;
	int COL_QUANTITY = 3;
	int COL_AMOUNT = 4;
	String id = "";
	JButton Btndel;

	public JTableAmountModel() {
		setLayout(new GridLayout(0, 1));
		final MyTableModel model = new MyTableModel();
		final JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 170));
		table.setFillsViewportHeight(true);
		table.getModel().addTableModelListener(this);
		
		if (DEBUG) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					final int i = table.getSelectedRow();
					System.out.println("id:" + id);
					printDebugData(table);
				}
			});
		}

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		subpanel = new JPanel();
		subpanel.setLayout(null);

		Btndel = new JButton("DELETE");
		Btndel.setBounds(350, 50, 100, 35);
		subpanel.add(Btndel);
		add(subpanel);
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

		final int firstRow = ev.getFirstRow();
		final int lastRow = ev.getLastRow();
		int column = ev.getColumn();
		final MyTableModel model = (MyTableModel) ev.getSource();
		String colName = model.getColumnName(column);
		Object data = model.getValueAt(firstRow, column);
		System.out.println("firstRow:" + firstRow + ", column:" + column + ", colName:" + colName + ", data:" + data);
	}

	class MyTableModel extends AbstractTableModel{

		private String[] columnNames = { "Goods", "Unit Name", "Price", "Quantity", "Amount" };
		private Object[][] data;
		Goods_DAO dao = new Goods_DAO();
		ArrayList<Goods> goods = dao.viewGoods();

		public MyTableModel() {
			System.out.println("MyTableModel()...");

			Object[][] lsit = new Object[goods.size()][goods.size()];
			int row = 0;

			for (Goods good : goods) {
				Object obj[] = new Object[columnNames.length];
				obj[0] = good.getId();
				obj[1] = good.getGname();
				obj[2] = good.getPrice();
				obj[3] = good.getQty();
				obj[4] = good.getAmount();
				lsit[row] = obj;
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
					int Id = Integer.valueOf(id);
					String strQuantity = value.toString();
					Integer intQuantity = Integer.parseInt(strQuantity);
					int quantity = intQuantity.intValue();
					String strPrice = data[row][COL_PRICE].toString();
					Double intPrice = Double.parseDouble(strPrice);
					double price = intPrice.intValue();
					double amount = quantity * price;
					Goods_DAO dao = new Goods_DAO();
					Goods good = new Goods(Id, "", 0, quantity, amount);
					dao.editGoods(good);
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
