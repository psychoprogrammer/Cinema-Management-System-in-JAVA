import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;


public class About extends JInternalFrame {

	

	public About() {
		setTitle("About - Cinema Management System");
		setBounds(100, 100, 624, 467);
		
		JLabel lblAboutCinemaManagement = new JLabel("About Cinema Management System");
		lblAboutCinemaManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblUsingCinemaManagement = new JLabel("Using Cinema Management System, the theater staff can manage movie schedules for their movie screen. ");
		
		JLabel lblUserCanRegister = new JLabel("User can Register and Schedule a Movie. ");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAboutCinemaManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(328))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsingCinemaManagement, GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUserCanRegister, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(358)))))
					.addGap(18))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAboutCinemaManagement)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsingCinemaManagement, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserCanRegister)
					.addContainerGap(358, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
