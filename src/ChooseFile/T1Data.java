package ChooseFile;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


public class T1Data extends JPanel implements TableModelListener{
    private final JTable table;
    MyModel model;

    public T1Data() {
        super(new BorderLayout(3, 3));
        this.table = new JTable(new MyModel());
        this.table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        this.table.setFillsViewportHeight(true);
        JPanel ButtonOpen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(ButtonOpen, BorderLayout.SOUTH);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        // Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);
        // add a nice border
        setBorder(new EmptyBorder(5, 5, 5, 5));
        CSVFile Rd = new CSVFile();
        model = new MyModel();
        this.table.setModel(model);
        File DataFile = new File("C:\\Users\\User\\Documents\\test.csv");
        ArrayList<String[]> Rs2 = Rd.ReadCSVfile(DataFile);
        model.AddCSVData(Rs2);
        System.out.println("Rows: " + model.getRowCount());
        System.out.println("Cols: " + model.getColumnCount());
    }

    // Method for reading CSV file
    public class CSVFile {
        private final ArrayList<String[]> Rs = new ArrayList<String[]>();
        private String[] OneRow;

        public ArrayList<String[]> ReadCSVfile(File DataFile) {
            try {
                BufferedReader brd = new BufferedReader(new FileReader(DataFile));
                while (brd.ready()) {
                    String st = brd.readLine();
                    OneRow = st.split("");
                    Rs.add(OneRow);
                    System.out.println(Arrays.toString(OneRow));
                } // end of while
            } // end of try
            catch (Exception e) {
                String errmsg = e.getMessage();
                System.out.println("File not found:" + errmsg);
            } // end of Catch
            return Rs;
        }// end of ReadFile method
    }// end of CSVFile class

    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("T1Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create and set up the content pane.
        T1Data newContentPane = new T1Data();
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    class MyModel extends AbstractTableModel {
        private final String[] columnNames = { "1", "2", "3", "4", };
        private ArrayList<String[]> Data = new ArrayList<String[]>();

        public void AddCSVData(ArrayList<String[]> DataIn) {
            this.Data = DataIn;
            this.fireTableDataChanged();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;// length;
        }

        @Override
        public int getRowCount() {
            return Data.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return Data.get(row)[col];
        }
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
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
    			
    			if(String.valueOf(model.getValueAt(ev.getFirstRow(), 0)).equals("RAM 4DDR 3.2GHz")) {
    				String qtyStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()));
    				String priceStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()-1));
    				int qty = Integer.parseInt(qtyStr);
    				int sale = 0;
    				int price = Integer.valueOf(priceStr);
    				
    				if (qty >2) {
    					System.out.println("sale 15%");
    					sale = ((price*15) /100 ) * qty;
    					System.out.println("sale: "+sale);
    				}
    				String sum = String.valueOf(qty * Integer.parseInt(priceStr)-sale);
    				model.setValueAt(sum, ev.getFirstRow(), ev.getColumn() +1);
    			}else {
    				String qtyStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()));
    				String priceStr = String.valueOf(model.getValueAt(ev.getFirstRow(), ev.getColumn()-1));
    				
    				int qty = Integer.parseInt(qtyStr);
    				
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
