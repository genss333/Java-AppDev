package SwingJTable;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class FormView extends JPanel implements ActionListener {

	Main Main;
	private boolean DEBUG = true;
	
	JTable jTable;
	DefaultTableModel model;

	FormView(Main Mainframe) {
		Main = Mainframe;

		setPreferredSize(new Dimension(Main.menu.FRAME_WIDTH, Main.menu.FRAME_HEIGHT));
		setLayout(null);
		JLabel lbHeader = new JLabel("Form View");
		lbHeader.setBounds((Main.menu.FRAME_WIDTH - lbHeader.getPreferredSize().width) / 2, 10,
				lbHeader.getPreferredSize().width, lbHeader.getPreferredSize().height);
		add(lbHeader);

		int width;
		int height;
		int xl = 10;
		int yl = 30;

		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(xl, yl, Main.menu.FRAME_WIDTH - xl * 2, Main.menu.FRAME_HEIGHT - yl * 4);
		add(jScrollPane);

		jTable = new JTable();
		jScrollPane.setViewportView(jTable);

		model = (DefaultTableModel) jTable.getModel();
		model.addColumn("id");
		model.addColumn("goods");
		model.addColumn("price");
		model.addColumn("quantity");
		model.addColumn("amount");

		jTable.setFillsViewportHeight(true);

		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent ev) {
				if (ev.getType() == TableModelEvent.UPDATE) {
					try {
				    	int firstRow = ev.getFirstRow();
				    	int column = ev.getColumn();
				    	DefaultTableModel model = (DefaultTableModel)ev.getSource();
				    	String colName = model.getColumnName(column);
				    	Object data = model.getValueAt(firstRow, column);
				    	System.out.println("firstRow:" + firstRow + ", column:" + column +
				    			", colName:" + colName + ", data:" + data);
				    	try {
				    		String qtyStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()));
		    				String priceStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()-1));
				        	double price = Double.parseDouble(priceStr);
				        	int quantity = Integer.parseInt(qtyStr);
				        	double amount = quantity * price;
				        	System.out.println("quantity:" + quantity + ", price:" + price +
				        			", amount:" + amount);
				        	model.setValueAt(new Double(amount), ev.getFirstRow(), ev.getColumn()+1);
				        	model.fireTableDataChanged();
				    	} catch(NumberFormatException ex) {
				    		ex.printStackTrace();
				    	}

					} catch (NumberFormatException e) {
						e.printStackTrace();
					}

				}
			}
		});

		JButton btView = new JButton(Jmenu.VIEW_STR);
		width = btView.getPreferredSize().width;
		height = btView.getPreferredSize().height;
		btView.setBounds(Jmenu.FRAME_WIDTH / 2 - width - 10, Main.menu.FRAME_HEIGHT - yl * 3, width, height);
		add(btView);
		btView.addActionListener(this);

		JButton btCancel = new JButton(Jmenu.CANCEL_STR);
		width = btCancel.getPreferredSize().width;
		height = btCancel.getPreferredSize().height;
		btCancel.setBounds(Jmenu.FRAME_WIDTH / 2 + 10, Main.menu.FRAME_HEIGHT - yl * 3, width, height);
		add(btCancel);
	}

	public void actionPerformed(ActionEvent evt) {

		String command = evt.getActionCommand();
		if (command.equals(Jmenu.VIEW_STR)) {
			Main.viewgoods();

		}

	}

	public void setForm(ArrayList<Goods> goods) {

		int rows = model.getRowCount();
		for (int i = 0; i < rows; i++) {
			model.removeRow(0);
		}

		for (Iterator<Goods> it = goods.iterator(); it.hasNext();) {
			Goods good = it.next();
			Vector data = new Vector();
			data.add(new Integer(good.id));
			data.add(good.gname);
			data.add(new Double(good.price));
			data.add(new Integer(good.qty));
			data.add(new Double(good.amount));
			model.addRow(data);
		}
	}

}
