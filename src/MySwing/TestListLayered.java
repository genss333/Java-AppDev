package MySwing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class TestListLayered
{
    public static class LayeredListCellRenderer extends DefaultListCellRenderer
    {
        @Override
        public Component getListCellRendererComponent(final JList list, final Object value, final int index,
                final boolean isSelected, final boolean cellHasFocus)
        {
            final JLayeredPane pane = new JLayeredPane();
            final JLabel label = (JLabel) super.getListCellRendererComponent(list, value.toString(), index, isSelected,
                    cellHasFocus);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.setBounds(0, 0, 100, 20);
            pane.add(label, JLayeredPane.DEFAULT_LAYER);

            final JButton edit = new JButton("e");
            final FontMetrics fontMetrics = edit.getFontMetrics(edit.getFont());
            final int height2 = (int) (1.5 * fontMetrics.getHeight());
            edit.setBounds(0, 0, (int) (1.5 * fontMetrics.stringWidth("e")), height2);
            edit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(final ActionEvent e)
                {
                    System.out.println("button");
                }
            });
            pane.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(final MouseEvent e)
                {
                    System.out.println("layeredpane");
                }
            });
            pane.add(edit, JLayeredPane.PALETTE_LAYER);

            pane.setPreferredSize(new Dimension(-1, height2));
            pane.setBorder(new LineBorder(Color.blue));
            return pane;
        }
    }

    public static void main(final String[] args)
    {
        final JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JList<String> l = new JList<String>(new String[] { "item 1", "item 2" });
        l.setCellRenderer(new LayeredListCellRenderer());
        f.add(l);

        f.pack();
        f.setVisible(true);
    }
}