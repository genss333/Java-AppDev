package swinggraph;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;


public class MultiLineGraph extends JPanel {
	
	final static int PAD_RIGHT = 50;
	final static int PAD_LEFT = 100;
	final static int PAD_TOP = 50;
	final static int PAD_BOTTOM = 60;
	final static int PAD_GRAPH_RIGHT = 30;
	final static int PAD_GRAPH_LEFT = 30;
	final static int OFFSET_TOP = 30;
	final static int OFFSET_BOTTOM = 20;
	final static int OFFSET_X_AXIS = PAD_LEFT - 40;
	final static int OFFSET_Y_AXIS = PAD_BOTTOM - 10;
	final static int SCALE_LENGTH = 8;
	
	String graphLabel = "Line Graph";
	String xLabel = "Product";
	String yLabel = "Quantity";
	
	int width;
	int height;
	int graphWidth;
	int graphHeight;
	
	int fontHeight = 10;
		
	int dataBound;
	int[][] data;
	
	int dataNo;
	int groupNo;
	
	double valueRatio;

	public MultiLineGraph(int dataBound, int[][] data) {
		
		this(800, 600, dataBound, data);
		
	}
	
	public MultiLineGraph(int w, int h, int dataBound, int[][] data) {
		
		super();
		
		this.dataBound = dataBound;
		this.data = data;

		dataNo = data[0].length;
		groupNo = data.length;
		
		width = w;
		height = h;
		
		setPreferredSize(new Dimension(width, height));
		
		graphWidth = width - PAD_RIGHT - PAD_LEFT - PAD_GRAPH_RIGHT - PAD_GRAPH_LEFT;
		graphHeight = height - PAD_TOP - PAD_BOTTOM;
		
		valueRatio = graphHeight*1.0/dataBound;
		
		System.out.println("xAxisWidth:" + graphWidth
				+ ", yAxisHeight:" + graphHeight
				+ ", valueRatio:" + valueRatio);
		
	}
	
	public int[][] scaleData(int[][] raw) {
		int[][] scaled = new int[raw.length][];
		
		int i = 0;
		for(int[] row : raw) {
			scaled[i] = new int[row.length];
			int j = 0;
			for(int col : row) {
				double temp = valueRatio * col;
				int dataScaled = (int)Math.round(temp);
				scaled[i][j++] = dataScaled;
				System.out.println("raw:" + data + ", temp:" + temp 
						+ ", dataScaled:" + dataScaled);
			}
			++i;
		}
		
		return scaled;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		int[][] scaledData = scaleData(data);
		int dataBlockSize = 1;
		int yBlockSize = graphHeight / (dataBound/dataBlockSize);
		int xBlockSize = graphWidth / (dataNo-1);
		System.out.println("yBlockSize:" + yBlockSize + ", xBlockSize:" + xBlockSize + ", dataBlockSize:" + dataBlockSize);
		
		int x1, y1, x2, y2;
		
		// graph label
		x1 = PAD_LEFT + (graphWidth/2);
		y1 = PAD_TOP - OFFSET_TOP;
		g2.drawString(graphLabel, x1, y1);
		
		// draw x label
		x1 = PAD_LEFT + (graphWidth/2);
		y1 = height - OFFSET_BOTTOM;
		g2.drawString(xLabel, x1, y1);
		
		// draw x axis
		x1 = PAD_LEFT;
		y1 = height - PAD_BOTTOM;
		x2 = width - PAD_RIGHT;		
		y2 = y1;
		g2.drawLine(x1, y1, x2, y2);

		// draw scale on x axis
		x1 = PAD_LEFT + PAD_GRAPH_LEFT;
		y1 = height - PAD_BOTTOM;
		y2 = y1 + SCALE_LENGTH;
		int[] ar = {8,1,2};
		int p_id;
		for(int i=0; i<dataNo; i++) {
			x2 = x1;
			p_id = ar[i];
			g2.drawLine(x1, y1, x2, y2);
			g2.drawString("Products Id- " + p_id, x1, (height-OFFSET_Y_AXIS) + fontHeight);
			// move right one block
			x1 += xBlockSize;
		}
				
		// draw y label
		x1 = PAD_LEFT;
		y1 = OFFSET_TOP;
		g2.drawString(yLabel, x1, y1);

		// draw y axis		
		x1 = PAD_LEFT;
		y1 = PAD_TOP;		
		x2 = PAD_LEFT;
		y2 = height - PAD_BOTTOM;
		g2.drawLine(x1, y1, x2, y2);

		// draw scale on y axis
		x1 = PAD_LEFT;
		x2 = PAD_LEFT - SCALE_LENGTH;
		y1 = height - PAD_BOTTOM;
		for(int i=0; i<=dataBound; i++) {
			y2 = y1;
			g2.drawLine(x1, y1, x2, y2);
			g2.drawString(String.valueOf(dataBlockSize*i), OFFSET_X_AXIS, y1);
			// move up one block
			y1 -= yBlockSize;
		}
		
		// HSV color setting
		float hue = 0f;
		float saturation = 1.0f;
		float brightness = 1.0f;
		int inc = 360/groupNo;
				
		// draw graph
		for(int i=0; i<data.length; i++) {
			x1 = PAD_LEFT + PAD_GRAPH_LEFT;
			Color color = new Color(Color.HSBtoRGB((hue/360), saturation, brightness));
			for(int j=0; j<data[i].length-1; j++) {
								
				g2.setColor(Color.BLACK);
				y1 = height-PAD_BOTTOM - scaledData[i][j];
				x2 = x1 + xBlockSize;
				y2 = height-PAD_BOTTOM - scaledData[i][j+1];
				g2.drawString(String.valueOf(data[i][j]), x1, y1);
				if(i == data.length-1) {
					g2.drawString(String.valueOf(data[i][j+1]), x2, y2);
				}
				// draw graph between a pair of point
				g2.setColor(color);
				g2.drawLine(x1, y1, x2, y2);
				x1 += xBlockSize;
			}			
			hue += inc;
			
		}
		
	}
	
	public static void main(String[] args) {
		MultiLineGraph lg = null;
		try {
			Dashboard_DAO dao = new Dashboard_DAO();
			Vector<DashBar> linechart = dao.LineChart();
			Object[][] datalist = new Object[linechart.size()][linechart.size()];
			int row = 0;
			int bound = 0;
			for(DashBar index : linechart) {
				datalist[row][row] = index.getQty();
				bound += index.getQty();
				row++;
			}
			System.out.println(Arrays.toString(datalist));
			
			int[][]data = new int[datalist.length][datalist.length];
			for (int i = 0; i < datalist.length; i++) {
				for(int j = 0; j<datalist.length;j++) {
					data[i][j] = (Integer)datalist[i][j];
					lg = new MultiLineGraph(bound, data);
				}
	        }
			System.out.println("total"+bound);
			System.out.println(Arrays.toString(data));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		JFrame frame = new JFrame();
		frame.add(lg);
		
		frame.pack();
		frame.setVisible(true);
		
	}

}