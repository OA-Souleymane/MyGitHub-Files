package partie2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class InterfaceDeVisulisation extends JFrame implements ActionListener, FocusListener{
	JPanel panel, centre, south, west;
	JButton interrompre, lancer;
	JTextField decalage_input, prd;
	JTextArea board;
	JLabel decalage, choix, sp;
	BorderLayout border_layout;
	JComboBox<String> choix_item;
	
	
	public InterfaceDeVisulisation() {
		String list[] = {"Memory Available","CPU usage"};		
		this.setTitle("Multiverse Telemetry API V1.0.0");
		panel = new JPanel();
		centre = new JPanel();
		south = new JPanel();
		west = new JPanel();
		
		border_layout = new BorderLayout();
		GridLayout grid_layout = new GridLayout(20,2);
		
		interrompre = new JButton("Interrompre");
		lancer = new JButton("Lancer");
		decalage_input = new JTextField("6",5);
		prd = new JTextField("Now...to...decalage(6)",6);
		  
		board  = new JTextArea("",20,85);
		//bold.setEnabled(false);
		board.setEditable(false);
		board.setWrapStyleWord(true);
		board.setLineWrap(true);		
		JScrollPane pane = new JScrollPane(board, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		decalage = new JLabel("Decalage :");
		choix = new JLabel("Choix :");
		sp = new JLabel("");
		choix_item = new JComboBox(list);
		
		west.setLayout(grid_layout);
		west.add(decalage);
		west.add(decalage_input);
		west.add(choix);
		west.add(choix_item);
		west.add(sp);
		west.add(prd);
		
		centre.add(pane);
		
		south.add(interrompre);
		south.add(lancer);
		
		panel.setLayout(border_layout);
		panel.add(centre,border_layout.CENTER);
		panel.add(south,border_layout.SOUTH);
		panel.add(west,border_layout.WEST);
		prd.setEditable(false);
		
		this.setContentPane(panel);
		this.setBounds(80, 80, 1150, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		interrompre.addActionListener(this);
		lancer.addActionListener(this);
		//lancer.setEnabled(false);
		decalage_input.addFocusListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == lancer)
			if(Integer.parseInt(decalage_input.getText()) > 5) {
        		  board.setText(board.getText()+"\nDonnez un nouveau decalage de capture");
			
		   }else {
			   board.setText(board.getText()+"\nDonnez à capter ["+choix_item.getSelectedItem()+"] à chaque "+decalage_input.getText()+" secondes");
			   lancer.setEnabled(false);
			   decalage_input.setEditable(false);
		   
		   }
		if(e.getSource() == interrompre) {
			boolean quit = false;
			String m = board.getText();
			for(int i= 0; i< m.length()-3; i++) 
	      		 if(m.charAt(i) == 'C' && m.charAt(i+1) == 'a' && m.charAt(i+2) == 'p' && m.charAt(i+3) == 'a')
	      	 		 quit = true;
			if(quit == false) {
				board.setText(board.getText()+"\nError message de capability non reçu!");				
			    //System.exit(0);
			}else {
				ArrayList<String> resC = new ArrayList<String>();
				resC.add("CPU usage");
				resC.add("Memory Available");
				try {
					
					Publish controllerP2 = new Publish();
					controllerP2.Publish(Controller.Queue2, new Interruption(""+0+"", "cpu", "Specification", new When(), "", "controller", resC).toString());
					board.setText(board.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceDeVisulisation f = new InterfaceDeVisulisation();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
