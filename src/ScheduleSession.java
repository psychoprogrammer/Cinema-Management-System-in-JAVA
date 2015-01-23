import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JComboBox;


public class ScheduleSession extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleSession frame = new ScheduleSession();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTextField tfScheduleDate;
	private JTextField tfScheduleTime;
	private JComboBox comboBox;
	private String tit;
	
	public void fillComboBox(){
		try{
			String query = "SELECT title from regMovie";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				comboBox.addItem(rs.getString("title"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ScheduleSession() {
		conn = sqliteConnection.dbConnector();
		setClosable(true);
		setTitle("Schedule Session");
		setBounds(100, 100, 609, 493);
		
		JLabel lblMovieTitle = new JLabel("Movie Title");
		
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		
		JLabel lblScheduleTime = new JLabel("Schedule Time");
		
		tfScheduleDate = new JTextField();
		tfScheduleDate.setToolTipText("DD/MM/YYYY");
		tfScheduleDate.setColumns(10);
		
		tfScheduleTime = new JTextField();
		tfScheduleTime.setToolTipText("hh:mm");
		tfScheduleTime.setColumns(10);
		
		JLabel lblCinemaManagementSystem = new JLabel("Cinema Management System");
		lblCinemaManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblForStaff = new JLabel("for Staff!");
		lblForStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblScheduleMoiveSession = new JLabel("Schedule Moive Session");
		lblScheduleMoiveSession.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/movie-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query1 = "INSERT INTO secMovie (\"MovieTitle\",\"SecDate\",\"SecTime\") VALUES (?,?,?)";
					
					PreparedStatement pst1 = conn.prepareStatement(query1);
					pst1.setString(1, (String) comboBox.getSelectedItem());
					pst1.setString(2, tfScheduleDate.getText());
					pst1.setString(3, tfScheduleTime.getText());
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Movie Scheduled Successfully");
					
					
					tfScheduleDate.setText("");
					tfScheduleTime.setText("");
					
					pst1.close();
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		
		 comboBox = new JComboBox();
		 
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCinemaManagementSystem, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(274)
											.addComponent(lblForStaff, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
									.addGap(43))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(35)
									.addComponent(lblScheduleMoiveSession, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
									.addGap(78))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMovieTitle)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblScheduleTime)
									.addComponent(lblScheduleDate)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tfScheduleTime, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
								.addComponent(tfScheduleDate, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 444, Short.MAX_VALUE)
								.addComponent(btnSchedule, Alignment.TRAILING))
							.addGap(42))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblCinemaManagementSystem)
							.addGap(11)
							.addComponent(lblForStaff)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblScheduleMoiveSession)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMovieTitle)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScheduleDate)
						.addComponent(tfScheduleDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScheduleTime)
						.addComponent(tfScheduleTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSchedule)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillComboBox();

	}
}
