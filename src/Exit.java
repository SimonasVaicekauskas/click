import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exit implements ActionListener {
	JButton button;
	public boolean exit_code = false;
	
	public void actionPerformed(ActionEvent event){
		button.setText("something happened");
		System.exit(0);	
	}
	
	public void exitButtonGui(){
		JFrame frame = new JFrame();
		button = new JButton("Exit");
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}


