import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class GraphHamming extends JFrame
{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 500;
	
	private JFrame frame;
	private JSlider hammDisSlider;
	private JTextField hammDisSliderDisplay, dist0Display, dist1Display, dist2Display, dist3Display, dist4Display, newStationEntryText;
	private JLabel label, compareLabel, dist0, dist1, dist2, dist3, dist4;
	private JButton showStationButton, calcHDButton, addStationButton, colorpickerButton;
	private JPanel  mainPanel, panel1, panel2, panel3, panel4, panel5;
	private JList<Object> list = new JList<Object>();
	private JComboBox stationIDCheckbx;
	private JScrollPane scrollPane;
	
	CalculateHammingDistance hammDis = new CalculateHammingDistance();
	
	
	
	
	
	
	public static void main (String [] args) throws IOException
	{
		new GraphHamming();
	}

}
