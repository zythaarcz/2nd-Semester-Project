package helpers;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slider extends JPanel {

	/**
	 * Create the panel.
	 */
	public Slider() {
		
	}
	
	public void runSidebar() {
		Thread th = new Thread() {
            @Override
            public void run(){
                try {
                    
                    for ( int i = 0; i <= 225; i++){
                        Thread.sleep(1);
                        setSize(i, 740);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            };
            
		};th.start();
	}
}
