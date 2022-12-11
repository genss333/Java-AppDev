package SwingJTable;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Jmenu extends JFrame implements ActionListener{

	public final static int FRAME_WIDTH = 500;
	final public static int FRAME_HEIGHT = 300;

	Main Main;

	JPanel mainPanel;
	
	FormView view;

	final static String CAR_STR = "Goods";
	final static String ADD_STR = "Add";
	final static String EDIT_STR = "Edit";
	final static String DELETE_STR = "Delete";
	final static String SEARCH_STR = "Search";
	final static String VIEW_STR = "View";
	final static String EXIT_STR = "Exit";

	final static String CANCEL_STR = "Cancel";
	

	Jmenu(Main Main) {
		super("Goods");
		this.Main = Main;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenDim.width - FRAME_WIDTH) / 2, (screenDim.height - FRAME_HEIGHT) / 2);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu mainMenu = new JMenu(CAR_STR);
		JMenuItem menuAdd = new JMenuItem(ADD_STR);
		JMenuItem menuEdit = new JMenuItem(EDIT_STR);
		JMenuItem menuDelete = new JMenuItem(DELETE_STR);
		JMenuItem menuSearch = new JMenuItem(SEARCH_STR);
		JMenuItem menuView = new JMenuItem(VIEW_STR);
		JMenuItem menuExit = new JMenuItem(EXIT_STR);

		menuAdd.addActionListener(this);
		menuEdit.addActionListener(this);
		menuDelete.addActionListener(this);
		menuSearch.addActionListener(this);
		menuView.addActionListener(this);
		menuExit.addActionListener(this);

		mainMenu.add(menuAdd);
		mainMenu.add(menuEdit);
		mainMenu.add(menuDelete);
		mainMenu.add(menuSearch);
		mainMenu.add(menuView);
		mainMenu.add(menuExit);
		jMenuBar.add(mainMenu);
		setJMenuBar(jMenuBar);
		
		view = new FormView(Main);

		mainPanel = new JPanel(new CardLayout());
		mainPanel.add(view,VIEW_STR);

		add(mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println("command:" + command);
		Object source = e.getSource();
		System.out.println("source:" + source.toString());
		if(command.equals(VIEW_STR)) {
			CardLayout cardLayout = (CardLayout)mainPanel.getLayout();
			cardLayout.show(mainPanel, VIEW_STR);
		}
		
	}
}
