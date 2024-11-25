package objekte;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;


public class Launcher extends Panel implements WindowListener{
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){System.exit(1);}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	
	public static Frame f = new Frame("Schwarmverhalten Launcher");
	int w = 1024;
	int h = 768;
	int a = 200;
	double sep = 10;
	double ali = 0.1;
	double coh = 0.05;
	
	Panel menu = new Panel(new GridLayout(6,2));
	Button startB = new Button("Starten");
	
	Panel buttonPanel = new Panel();
	
	TextField width = new TextField("");
	Label widthL = new Label("Breite:");
	
	TextField height = new TextField("");
	Label heightL = new Label("Hoehe:");
	
	TextField agents = new TextField("");
	Label agentsL = new Label("Agentenzahl:");
	
	TextField seperation = new TextField("");
	Label seperationL = new Label("Seperation:");
	
	TextField alignment = new TextField("");
	Label alignmentL = new Label("Alignment:");
	
	TextField cohesion = new TextField("");
	Label cohesionL = new Label("Cohesion:");
	
	
	ActionListener start = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			try {

				
				try{
					w = Integer.parseInt(width.getText());
				} catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + width.getText() +") ist kein gültiger Integerwert ...",
						    "Ungültige Breite!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try{
					h = Integer.parseInt(height.getText());
				} catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + height.getText() +") ist kein gültiger Integerwert ...",
						    "Ungültige Höhe!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				try{
					a = Integer.parseInt(agents.getText());
				}catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + agents.getText() +") ist kein gültiger Integerwert ...",
						    "Ungültige Agentenanzahl!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				try{
					sep = Double.parseDouble(seperation.getText());
				}catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + seperation.getText() +") ist kein gültiger Doublerwert ...",
						    "Seperation ungültig!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				try{
					ali = Double.parseDouble(alignment.getText());
				}catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + alignment.getText() +") ist kein gültiger Doublerwert ...",
						    "Alignment ungültig!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
			
				try{
					coh = Double.parseDouble(cohesion.getText());
				}catch(NumberFormatException ne1){
					JOptionPane.showMessageDialog(f,
							"(" + cohesion.getText() +") ist kein gültiger Doublerwert ...",
						    "Cohesion ungültige!",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				f.setVisible(false);
				GameEngine gE = new GameEngine(w,h,a, sep, ali, coh);
				gE.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}};
	
	public void setup(){
		agents.setText(Integer.toString(a));
		width.setText(Integer.toString(w));
		height.setText(Integer.toString(h));
		seperation.setText(Double.toString(sep));
		alignment.setText(Double.toString(ali));
		cohesion.setText(Double.toString(coh));
		
		menu.add(widthL);
		menu.add(width);
		menu.add(heightL);
		menu.add(height);
		menu.add(agentsL);
		menu.add(agents);
		menu.add(seperationL);
		menu.add(seperation);
		menu.add(alignmentL);
		menu.add(alignment);
		menu.add(cohesionL);
		menu.add(cohesion);
		
		setLayout(new BorderLayout());
		this.add(menu, BorderLayout.CENTER);
		startB.addActionListener(start);
		buttonPanel.add(startB);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	Launcher() {
		setup();
		f.add(this);
		f.addWindowListener(this);
		f.pack();
		f.setVisible(true);
		f.repaint();
	}
	
	public static void main(String[] args){
		Launcher l = new Launcher();
	}
}
