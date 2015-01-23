import java.awt.EventQueue;
import java.sql.*;

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


public class RegisterMovie extends JInternalFrame {
	private JTextField tfMovieTitle;
	private JTextField tfBilledCast;
	private JTextField tfDirector;
	private JTextField tfReleaseDate;
	private JTextField tfDuration;
	private JTextField tfGenre;
	private JTextField tfRating;
	private JTextField tfDistributor;
	private JTextField tfWebsite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMovie frame = new RegisterMovie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	private JTextArea taSynopsis;
	/**
	 * Create the frame.
	 */
	public RegisterMovie() {
		setClosable(true);
		setTitle("Register New Movie");
		setBounds(100, 100, 680, 680);
		
		
		JLabel lblTitle = new JLabel("Movie Title");
		
		tfMovieTitle = new JTextField();
		tfMovieTitle.setToolTipText("Enter the Movie Title");
		tfMovieTitle.setName("");
		tfMovieTitle.setColumns(30);
		
		JLabel lblBilledCast = new JLabel("Billed Cast");
		
		tfBilledCast = new JTextField();
		tfBilledCast.setToolTipText("Who are the actors?");
		tfBilledCast.setColumns(30);
		
		JLabel lblDirector = new JLabel("Director");
		
		tfDirector = new JTextField();
		tfDirector.setColumns(30);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		
		tfReleaseDate = new JTextField();
		tfReleaseDate.setToolTipText("DD-MM-YYYY");
		tfReleaseDate.setColumns(30);
		
		JLabel lblDuration = new JLabel("Duration");
		
		tfDuration = new JTextField();
		tfDuration.setToolTipText("159min 56sec");
		tfDuration.setColumns(30);
		
		JLabel lblGenre = new JLabel("Genre");
		
		tfGenre = new JTextField();
		tfGenre.setToolTipText("Action, Comedy, Love..?!");
		tfGenre.setColumns(30);
		
		JLabel lblRating = new JLabel("Rating");
		
		tfRating = new JTextField();
		tfRating.setToolTipText("Give your rating from 0 - 5.0");
		tfRating.setColumns(30);
		
		JLabel lblDistributor = new JLabel("Distributor");
		
		tfDistributor = new JTextField();
		tfDistributor.setColumns(30);
		
		JLabel lblWebsite = new JLabel("Website");
		
		tfWebsite = new JTextField();
		tfWebsite.setToolTipText("Official Website(s)");
		tfWebsite.setColumns(30);
		
		JLabel lblSynopsis = new JLabel("Synopsis");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					conn = sqliteConnection.dbConnector();
					String query1 = "INSERT INTO regMovie (\"title\",\"billcast\",\"director\",\"releasedate\",\"duration\",\"genre\",\"rating\",\"distributor\",\"website\",\"synopsis\") VALUES (?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst1 = conn.prepareStatement(query1);
					pst1.setString(1, tfMovieTitle.getText());
					pst1.setString(2, tfBilledCast.getText());
					pst1.setString(3, tfDirector.getText());
					pst1.setString(4, tfReleaseDate.getText());
					pst1.setString(5, tfDuration.getText());
					pst1.setString(6, tfGenre.getText());
					pst1.setString(7, tfRating.getText());
					pst1.setString(8, tfDistributor.getText());
					pst1.setString(9, tfWebsite.getText());
					pst1.setString(10, taSynopsis.getText());
					
					pst1.execute();
					JOptionPane.showMessageDialog(null, "Registered Successfully");
					
					tfMovieTitle.setText("");
					tfBilledCast.setText("");
					tfDirector.setText("");
					tfReleaseDate.setText("");
					tfDuration.setText("");
					tfGenre.setText("");
					tfRating.setText("");
					tfDistributor.setText("");
					tfWebsite.setText("");
					taSynopsis.setText("");
					
					pst1.close();
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTitle)
						.addComponent(lblBilledCast)
						.addComponent(lblDirector)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSynopsis)
								.addComponent(lblReleaseDate)
								.addComponent(lblGenre)
								.addComponent(lblRating)
								.addComponent(lblDuration)
								.addComponent(lblDistributor)
								.addComponent(lblWebsite))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tfGenre, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(tfDuration, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(tfReleaseDate, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(tfDirector, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(tfBilledCast, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(tfMovieTitle, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)))
								.addComponent(tfDistributor)
								.addComponent(tfWebsite)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
								.addComponent(tfRating)
								.addComponent(btnRegister, Alignment.TRAILING))))
					.addGap(499))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(tfMovieTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBilledCast)
						.addComponent(tfBilledCast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDirector)
						.addComponent(tfDirector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReleaseDate)
						.addComponent(tfReleaseDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDuration))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenre)
						.addComponent(tfGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRating)
						.addComponent(tfRating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfDistributor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistributor))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWebsite))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSynopsis)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnRegister)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		taSynopsis = new JTextArea();
		taSynopsis.setToolTipText("Theme of the movie");
		taSynopsis.setLineWrap(true);
		taSynopsis.setWrapStyleWord(true);
		scrollPane.setViewportView(taSynopsis);
		getContentPane().setLayout(groupLayout);

	}
}
