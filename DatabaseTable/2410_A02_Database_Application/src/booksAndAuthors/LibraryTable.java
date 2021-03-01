package booksAndAuthors;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

/**
 * This class contains the GUI of our table. The buttons will be added to the frame.
 * The buttons will show the tables in the frame. 
 * @author Sabina Shrestha and Heberto Rodriguez
 *
 */


@SuppressWarnings("serial")
public class LibraryTable extends JFrame {

	private static JPanel contentPane;		
	private JTable table;
	private int search_field;
	private JTextField textField;
	private JRadioButton rdbtnBooks;
	private JRadioButton rdbtnAuthor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryTable frame = new LibraryTable();
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
	public LibraryTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBooks = new JButton("Books");
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM Books ";
					ResultSet results = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(results));				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBooks.setBounds(6, 20, 110, 29);
		contentPane.add(btnBooks);
		
		JButton btnAuthors = new JButton("Authors");
		btnAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
					Statement statement = connection.createStatement();
					String query = "SELECT * FROM Author ";
					ResultSet results = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(results));
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAuthors.setBounds(120, 20, 110, 29);
		contentPane.add(btnAuthors);
		
		JButton btnBooksAndAuthors = new JButton("Books And Authors");
		btnBooksAndAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
					Statement statement = connection.createStatement();
					String query = "SELECT Books.Title, Books.Genre, Author.FirstName, Author.LastName " +
						"FROM Books " + 
							"INNER JOIN BookAuthor ON BookAuthor.BooksID = Books.ID " +
							"INNER JOIN Author ON BookAuthor.AuthorID = Author.ID " +
							"ORDER BY Books.Title";
					ResultSet results = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(results));
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBooksAndAuthors.setBounds(231, 20, 155, 29);
		contentPane.add(btnBooksAndAuthors);
		
		table = new JTable();
		table.setBounds(16, 101, 665, 309);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = textField.getText().toLowerCase();
				String search_table = null;
				String column = null;
				//System.out.println(val);
				try {
					if (search_field == 1) {
						//System.out.println("-----------book----------");
						search_table = "Books";
						column = "Title";
						
					}
					else if(search_field == 2) {
						//System.out.println("-----------title----------");
						search_table = "Author";
						column = "FirstName";
					}
					Connection connection = DriverManager.getConnection("jdbc:derby:demoDatabase");
					Statement statement = connection.createStatement();
					String query = "select * from " + search_table + " where LOWER(" + column + ") like LOWER('%" + val + "%')";
					//System.out.print(query);
					ResultSet results = statement.executeQuery(query);
					//System.out.println(results);
					table.setModel(DbUtils.resultSetToTableModel(results));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField.setBounds(444, 62, 245, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
//		JButton btnNewButton = new JButton("Book");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				search_field = 1;
//			}
//		});
//		btnNewButton.setBounds(260, 66, 97, 29);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Author");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				search_field = 2;
//			}
//		});
//		btnNewButton_1.setBounds(147, 66, 97, 29);
//		contentPane.add(btnNewButton_1);
		
		rdbtnBooks = new JRadioButton("Books");
		rdbtnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnAuthor.setSelected(false);
				search_field = 1;
			}
		});
		rdbtnBooks.setBounds(473, 12, 110, 45);
		contentPane.add(rdbtnBooks);
		
		rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnBooks.setSelected(false);
				search_field = 2;

			}
		});
		rdbtnAuthor.setBounds(584, 13, 101, 42);
		contentPane.add(rdbtnAuthor);
		
	}
}
	
	