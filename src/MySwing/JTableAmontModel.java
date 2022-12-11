package MySwing;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class JTableAmontModel extends JPanel implements TableModelListener {

	private boolean DEBUG = true;

	MyTableModel model;

	public JTableAmontModel() {
		
		super(new GridLayout(1, 0));

		  String[] columnNames = {"Good",
                  "Price",
                  "Quantity",
                  "Amount"};

		Object[][] data = {
				{ "Liverpool T-Shirt Stadium", new Integer(750), new Integer(0), new Integer(0) },
				{ "Asenal T-Shirt Player", new Integer(2750), new Integer(0), new Integer(0)},
				{ "Manchester United T-Shirt", new Integer(1250), new Integer(0), new Integer(0)},
				{ "Manchester City T-Shirt", new Integer(1500), new Integer(0), new Integer(0) },
				{"total","","",new Integer(0)}
				};

		model = new MyTableModel(data,columnNames);
		final JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 170));
		table.setFillsViewportHeight(true);
		table.getModel().addTableModelListener(this);
		
		//Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

	}

	class MyTableModel extends AbstractTableModel {
    	
        private String[] columnNames;
        private Object[][] data;

        public MyTableModel(Object[][] data, String[] columnNames) {
        	System.out.println("MyTableModel()...");
       		this.columnNames = columnNames;
       		this.data = data;
       		System.out.println("MyTableModel()");
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

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        public boolean isCellEditable(int row, int col) {
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        public void setValueAt(Object value, int row, int col) {
        	System.out.println("setValueAt()... row:" + row + "x" + "col:" + col);
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);
            
            
            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
        	System.out.println("printDebugData()...");
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
	
	
	 private static void createAndShowGUI() {
		 
	        JFrame frame = new JFrame("JTableAmount");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JTableAmontModel newContentPane = new JTableAmontModel();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

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

	    	if(ev.getType() == TableModelEvent.UPDATE) {
	    		if(ev.getColumn() == 2) {
	    			int total = 0;
	    			
	    			if(String.valueOf(model.getValueAt(ev.getFirstRow(), 0)).equals("Asenal T-Shirt Player")) {
	    				String qtyStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()));
	    				String priceStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()-1));
	    				int qty = Integer.parseInt(qtyStr);
	    				int sale = 0;
	    				
	    				if (qty >2) {
	    					sale = qty*20;
	    				}
	    				String sum = String.valueOf(qty * Integer.parseInt(priceStr));
	    				model.setValueAt(sum, ev.getFirstRow(), ev.getColumn() +1);
	    			}else {
	    				String qtyStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()));
	    				String priceStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()-1));
	    				int qty = Integer.parseInt(qtyStr);
	    				int sale = 0;
	    				
	    				if (qty >2) {
	    					sale = qty*20;
	    				}
	    				String sum = String.valueOf(qty * Integer.parseInt(priceStr));
	    				model.setValueAt(sum, ev.getFirstRow(), ev.getColumn() +1);
	    			}
	    			
	    			int sum = 0;
	    	        for(int i =0;i<model.getRowCount()-1;i++){
	    	            sum = sum +Integer.parseInt(model.getValueAt(i, 3).toString());
	    	        }
	    	        
	    	        String totalsum = String.valueOf(sum);
	    	        model.setValueAt(totalsum, 4, 3);
	    		}
	    	}
	        
	    }
		

}
