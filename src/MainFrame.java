import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cinema Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmRegisterNewMovie = new JMenuItem("Register New Movie");
		mntmRegisterNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterMovie rm = new RegisterMovie();
				rm.setVisible(true);
				desktopPane.add(rm);
				try {
					rm.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		mnFile.add(mntmRegisterNewMovie);
		
		JMenuItem mntmScheduleSession = new JMenuItem("Schedule Session");
		mntmScheduleSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleSession ss = new ScheduleSession();
				ss.setVisible(true);
				desktopPane.add(ss);
				try{
					ss.setMaximum(true);
				}catch (PropertyVetoException e1) {
					// TODO catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		mnFile.add(mntmScheduleSession);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmDisplayMovieList = new JMenuItem("Display Movie List");
		mntmDisplayMovieList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieList ml = new MovieList();
				ml.setVisible(true);
				desktopPane.add(ml);
				try{
					ml.setMaximum(true);
				}catch (PropertyVetoException e1) {
					// TODO catch block
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		mnView.add(mntmDisplayMovieList);
		
		JSeparator separator_2 = new JSeparator();
		mnView.add(separator_2);
		
		JMenuItem mntmDisplayMovieSessions = new JMenuItem("Display Movie Sessions");
		mntmDisplayMovieSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieSessions ms = new MovieSessions();
				ms.setVisible(true);
				desktopPane.add(ms);
				try {
					ms.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});
		mnView.add(mntmDisplayMovieSessions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About ab = new About();
				ab.setVisible(true);
				desktopPane.add(ab);
				try {
					ab.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
