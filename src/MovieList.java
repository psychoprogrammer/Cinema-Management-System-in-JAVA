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

import javax.swing.JTable;
import javax.swing.JComboBox;


public class MovieList extends JInternalFrame {
	
	private JComboBox comboBox;
	private JComboBox comboBox1;
	
	Connection conn = null;
	private JTextField tfCast;
	private JTextField tfDirector;
	private JTextField tfReleaseDate;
	private JTextField tfDuration;
	private JTextField tfGenre;
	private JTextField tfRating;
	private JTextField tfDistributor;
	private JTextField tfWebsite;
	private JTextArea textArea;
	private String mt;
	private JComboBox comboBox2;
	private String st;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieList frame = new MovieList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
	
	public void fillComboBox1(){
		try{
			String query1 = "SELECT SecDate from secMovie WHERE MovieTitle=? ";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			
			pst1.setString(1, mt);
			ResultSet rs1 = pst1.executeQuery();
			
			while(rs1.next()){
				comboBox1.addItem(rs1.getString("SecDate"));
				st = rs1.getString("SecDate");
				comboBox2.removeAllItems();
				fillComboBox2();
			}
			
			
			
			//comboBox1.setSelectedItem("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void fillComboBox2(){
		try{
			String query1 = "SELECT SecTime from secMovie WHERE SecDate=? AND MovieTitle=?";
			PreparedStatement pst1 = conn.prepareStatement(query1);
			
			pst1.setString(1, st);
			pst1.setString(2, mt);
			ResultSet rs1 = pst1.executeQuery();
			
			while(rs1.next()){
				comboBox2.addItem(rs1.getString("SecTime"));
			}
			
			
			
			//comboBox1.setSelectedItem("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	


	/**
	 * Create the frame.
	 */
	public MovieList() {
		setTitle("Movie List");
		setClosable(true);
		setBounds(100, 100, 582, 477);
		
		conn = sqliteConnection.dbConnector();
		
		
		JLabel lblMovie = new JLabel("Movie");
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT * FROM regMovie WHERE title=? ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, (String) comboBox.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						mt = rs.getString("title");
						tfDirector.setText(rs.getString("director"));
						tfCast.setText(rs.getString("billcast"));
						tfReleaseDate.setText(rs.getString("releasedate"));
						tfDuration.setText(rs.getString("duration"));
						tfGenre.setText(rs.getString("genre"));
						tfRating.setText(rs.getString("rating"));
						tfDistributor.setText(rs.getString("distributor"));
						tfWebsite.setText(rs.getString("website"));
						textArea.setText(rs.getString("synopsis"));
						comboBox1.removeAllItems();
						fillComboBox1();
						
					}
					
					pst.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblCast = new JLabel("Cast");
		
		tfCast = new JTextField();
		tfCast.setEditable(false);
		tfCast.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director");
		
		tfDirector = new JTextField();
		tfDirector.setEditable(false);
		tfDirector.setColumns(10);
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		
		tfReleaseDate = new JTextField();
		tfReleaseDate.setEditable(false);
		tfReleaseDate.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		
		tfDuration = new JTextField();
		tfDuration.setEditable(false);
		tfDuration.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		
		tfGenre = new JTextField();
		tfGenre.setEditable(false);
		tfGenre.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		
		tfRating = new JTextField();
		tfRating.setEditable(false);
		tfRating.setColumns(10);
		
		JLabel lblDistributor = new JLabel("Distributor");
		
		tfDistributor = new JTextField();
		tfDistributor.setEditable(false);
		tfDistributor.setColumns(10);
		
		JLabel lblWebsite = new JLabel("Website");
		
		tfWebsite = new JTextField();
		tfWebsite.setEditable(false);
		tfWebsite.setColumns(10);
		
		JLabel lblSynopsis = new JLabel("Synopsis");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNextSessionDate = new JLabel("Session Timings");
		
		comboBox1 = new JComboBox();
		
		comboBox2 = new JComboBox();
		GroupLayout groupLayout_1 = new GroupLayout(getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDirector)
								.addComponent(lblWebsite)
								.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblRating)
									.addComponent(lblDuration))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addGap(8)
									.addComponent(lblMovie)))
							.addGap(18)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 192, Short.MAX_VALUE)
								.addComponent(tfRating, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(tfWebsite, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfDuration, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(tfDirector, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCast)
								.addComponent(lblReleaseDate)
								.addComponent(lblGenre)
								.addComponent(lblDistributor)
								.addComponent(lblNextSessionDate))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(tfDistributor)
									.addComponent(tfGenre)
									.addComponent(tfReleaseDate)
									.addComponent(tfCast, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(lblSynopsis)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
					.addGap(49))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMovie)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCast)
						.addComponent(tfCast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDirector)
						.addComponent(lblReleaseDate)
						.addComponent(tfReleaseDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfDirector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuration)
						.addComponent(tfDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenre)
						.addComponent(tfGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRating)
						.addComponent(tfRating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistributor)
						.addComponent(tfDistributor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWebsite)
						.addComponent(tfWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNextSessionDate)
						.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSynopsis)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().setLayout(groupLayout_1);
		
		fillComboBox();
		//fillComboBox1();

		

	}
}

