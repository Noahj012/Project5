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
	
	public GraphHamming() throws IOException
	{
		super("Hamming Distance");
		hammDis.readFile("Mesonet.txt");
		
		setFrame();
		setSlider(1, 4);
		setTextField(10);
		setHammDisDisplay();
		setButton();
		
		
		setComboBox();
		
		scrollPane = new JScrollPane(list);
		
		setPanels();
		
		panel2.add(label);
		panel2.add(hammDisSliderDisplay);
		panel1.add(panel2);
		panel1.add(hammDisSlider);
		
		panel3.add(showStationButton);
		panel3.add(scrollPane);
		
		panel4.add(compareLabel);
		panel4.add(stationIDCheckbx);
		
		panel5.add(calcHDButton);
		panel5.add(colorpickerButton);
		
		panel5.add(dist0);
		panel5.add(dist0Display);
		panel5.add(dist1);
		panel5.add(dist1Display);
		panel5.add(dist2);
		panel5.add(dist2Display);
		panel5.add(dist3);
		panel5.add(dist3Display);
		panel5.add(dist4);
		panel5.add(dist4Display);
		panel5.add(addStationButton);
		
		panel5.add(newStationEntryText);
		panel5.setLayout(new GridLayout(7,2));
		mainPanel.setLayout(new GridLayout(4,0));
		
		mainPanel.add(panel1);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}



	private void setPanels() {
		mainPanel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
	}



	private void setHammDisDisplay() 
	{
		
		// TODO Auto-generated method stub
		dist0 = new JLabel("Distance 0: ");
		dist1 = new JLabel("Distance 1: ");
		dist2 = new JLabel("Distance 2: ");
		dist3 = new JLabel("Distance 3: ");
		dist4 = new JLabel("Distance 4: ");
	}



	private void setComboBox() 
	{
		compareLabel = new JLabel("Compare with: ");
		stationIDCheckbx = new JComboBox<Object>(hammDis.getStationList().toArray());
	}



	private void setButton() 
	{
		showStationButton = new JButton("Show Station");
		calcHDButton= new JButton("Calculate HD");
		addStationButton= new JButton("Add Station");
		colorpickerButton = new JButton("Choose Color");
		
		calcHDButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						hammDis.calculateNode(stationIDCheckbx.getSelectedItem());
						
						dist0Display.setText(Integer.toString(hammDis.getNodeDistance()[0]));
						dist1Display.setText(Integer.toString(hammDis.getNodeDistance()[1]));
						dist2Display.setText(Integer.toString(hammDis.getNodeDistance()[2]));
						dist3Display.setText(Integer.toString(hammDis.getNodeDistance()[3]));
						dist4Display.setText(Integer.toString(hammDis.getNodeDistance()[4]));
					}
			
				});
		
		showStationButton.addActionListener(new ActionListener()
		{

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				try
				{
					if (hammDisSliderDisplay.getText().equals("1"))
					{
						list.setListData(hammDis.hd1Set.toArray());
						panel3.repaint();
						
					}
					if (hammDisSliderDisplay.getText().equals("2"))
					{
						list.setListData(hammDis.hd2Set.toArray());
						panel3.repaint();
						
					}
					if (hammDisSliderDisplay.getText().equals("3"))
					{
						list.setListData(hammDis.hd3Set.toArray());
						panel3.repaint();
					}
					if (hammDisSliderDisplay.getText().equals("4"))
					{
						list.setListData(hammDis.hd4Set.toArray());
						panel3.repaint();
					}
				}
				catch(NullPointerException h)
				{
					JOptionPane.showMessageDialog(GraphHamming.this, "Please calculate the hamming distance first");
				}
			}
			
		});
		
		addStationButton.addActionListener(new ActionListener()
		{

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO Auto-generated method stub
				stationIDCheckbx.addItem(newStationEntryText.getText().toUpperCase());
			}
			
		});
		
		colorpickerButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						// TODO Auto-generated method stub
						int reply =	JOptionPane.showConfirmDialog(
								GraphHamming.this, "Do you want to change the color?"
								,"Yes. I do",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						
				        if (reply == JOptionPane.YES_OPTION) 
				        {
					        	
					        		String[] hl = {"Slider Panel","List Panel", "Display Panel"};
						        	reply = JOptionPane.showOptionDialog(null, //Component parentComponent
				                               "Which Panel?", //Object message,
				                               "Choose an option", //String title
				                               JOptionPane.YES_NO_CANCEL_OPTION, //int optionType
				                              JOptionPane.INFORMATION_MESSAGE, //int messageType
				                               null, //Icon icon,
				                               hl, //Object[] options,
				                               "Panel1");
							        		if (reply == JOptionPane.YES_OPTION)
								        	{
								        			Color color =  JColorChooser.showDialog(GraphHamming.this,
													"Choose Background Color",
													panel1.getBackground());
								        			panel2.setBackground(color);
													panel1.setBackground(color);
								        	}
							        		else if (reply == JOptionPane.NO_OPTION)
								        	{
							        			Color color =  JColorChooser.showDialog(GraphHamming.this,
												"Choose Background Color",
												panel4.getBackground());
							        			panel3.setBackground(color);
												panel4.setBackground(color);
								        	}
							        		else if (reply == JOptionPane.CANCEL_OPTION)
								        	{
							        			Color color =  JColorChooser.showDialog(GraphHamming.this,
												"Choose Background Color",
												panel5.getBackground());
							   
							        			panel5.setBackground(color);
							        			
								        	}
					        	}
					        	
				        }
				
				});
	}



	private void setTextField(int amount) 
	{
		label = new JLabel("Hamming Distance: ");
		hammDisSliderDisplay = new JTextField(amount);
		dist0Display = new JTextField(amount);
		dist1Display = new JTextField(amount);
		dist2Display = new JTextField(amount);
		dist3Display = new JTextField(amount);
		dist4Display = new JTextField(amount);
		newStationEntryText = new JTextField(4);
		
		dist0Display.setEditable(false);
		dist1Display.setEditable(false);
		dist2Display.setEditable(false);
		dist3Display.setEditable(false);
		dist4Display.setEditable(false);
		
		hammDisSliderDisplay.setText("1");
		hammDisSliderDisplay.setEditable(false);
	}



	private void setFrame()
	{
		frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}



	private void setSlider(int min, int max) {
		hammDisSlider = new JSlider(min, max);
		hammDisSlider.setValue(min);
		hammDisSlider.setMajorTickSpacing(min);
		hammDisSlider.setPaintLabels(true);
		hammDisSlider.setPaintTicks(true);
		
		hammDisSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) 
			{
				// TODO Auto-generated method stub
				int value = hammDisSlider.getValue(); 
				if (value == 1 || value == 2 || value == 3 || value == 4)
				{
					hammDisSliderDisplay.setText(Integer.toString(value));
				}
			}
			
		});
	}
	
	
	
	
	public static void main (String [] args) throws IOException
	{
		new GraphHamming();
	}

}
