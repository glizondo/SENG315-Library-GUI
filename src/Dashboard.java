import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dashboard {

	private JFrame frame;
	private JMenuBar menuBar; // Create JFrame
	private JMenu fileMenu; // Created file menu
	private JMenu bookMenu; // Created book menu
	private JMenu searchMenu; // Created search menu
	private JMenu printMenu; // Created print menu
	private JMenu sortMenu; // Created print menu
	private JMenuItem exit;
	private JMenuItem add;
	private JMenuItem purchase;
	private JMenuItem update;
	private JMenuItem remove;
	private JMenuItem searchID;
	private JMenuItem searchAuthor;
	private JMenuItem printAll;
	private JMenuItem sortAscendingAuthor;
	private JMenuItem sortDescendingAuthor;
	private JMenuItem sortAscendingDatePublished;
	private JMenuItem sortDescendingDatePublished;
	private JPanel panel;
	private JLabel welcome;
	private JScrollPane scrollPane;
	private JTextArea text;
	private ListCreator library = new ListCreator();

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
		loadBooks();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		createMenuBar();

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 155));
		welcome = new JLabel("Welcome to the Book Library App. Top 10 books based on ratings");
		welcome.setForeground(Color.cyan);
		welcome.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel.add(welcome);
		text = new JTextArea(15, 30);
		text.setFont(new Font("SansSerif", Font.PLAIN, 16));
		scrollPane = new JScrollPane(text);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text.setLineWrap(true); // Sets the line-wrapping policy of the text area
		text.setWrapStyleWord(true); // Sets the style of wrapping used if the text area is wrapping lines
		panel.add(scrollPane);
		frame.add(panel);
		frame.setSize(500, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 255));
		menuBar.setForeground(Color.white);
		fileMenu = new JMenu("File");
		bookMenu = new JMenu("Book");
		searchMenu = new JMenu("Search");
		printMenu = new JMenu("Print");
		fileMenu.setForeground(Color.white);
		bookMenu.setForeground(Color.white);
		searchMenu.setForeground(Color.white);
		printMenu.setForeground(Color.white);
		fileMenu.setFont(new Font("SansSerif", Font.BOLD, 16));
		bookMenu.setFont(new Font("SansSerif", Font.BOLD, 16));
		searchMenu.setFont(new Font("SansSerif", Font.BOLD, 16));
		printMenu.setFont(new Font("SansSerif", Font.BOLD, 16));

		sortMenu = new JMenu("Sort All");
		sortMenu.setForeground(Color.white);
		sortMenu.setFont(new Font("SansSerif", Font.BOLD, 16));

		menuBar.add(fileMenu);
		menuBar.add(bookMenu);
		menuBar.add(searchMenu);
		menuBar.add(printMenu);
		menuBar.add(sortMenu);

		exit = new JMenuItem("Exit");
		add = new JMenuItem("Add");
		purchase = new JMenuItem("Purchase");
		update = new JMenuItem("Update");
		remove = new JMenuItem("Remove");
		searchID = new JMenuItem("ISBN");
		searchAuthor = new JMenuItem("Author");
		printAll = new JMenuItem("All");
		sortAscendingAuthor = new JMenuItem("Ascending by Author");
		sortDescendingAuthor = new JMenuItem("Descending by Author");
		sortAscendingDatePublished = new JMenuItem("Ascending by Published Date");
		sortDescendingDatePublished = new JMenuItem("Descending by Published Date");

		exit.setBackground(Color.cyan);
		exit.setForeground(Color.blue);
		exit.setFont(new Font("SansSerif", Font.BOLD, 16));
		add.setBackground(Color.CYAN);
		add.setForeground(Color.blue);
		add.setFont(new Font("SansSerif", Font.BOLD, 16));
		purchase.setBackground(Color.CYAN);
		purchase.setForeground(Color.blue);
		purchase.setFont(new Font("SansSerif", Font.BOLD, 16));
		update.setBackground(Color.CYAN);
		update.setForeground(Color.blue);
		update.setFont(new Font("SansSerif", Font.BOLD, 16));
		remove.setBackground(Color.CYAN);
		remove.setForeground(Color.blue);
		remove.setFont(new Font("SansSerif", Font.BOLD, 16));
		searchID.setBackground(Color.CYAN);
		searchID.setForeground(Color.blue);
		searchID.setFont(new Font("SansSerif", Font.BOLD, 16));
		searchAuthor.setBackground(Color.CYAN);
		searchAuthor.setForeground(Color.blue);
		searchAuthor.setFont(new Font("SansSerif", Font.BOLD, 16));
		printAll.setBackground(Color.CYAN);
		printAll.setForeground(Color.blue);
		printAll.setFont(new Font("SansSerif", Font.BOLD, 16));
		sortAscendingAuthor.setBackground(Color.CYAN);
		sortAscendingAuthor.setForeground(Color.blue);
		sortAscendingAuthor.setFont(new Font("SansSerif", Font.BOLD, 16));
		sortDescendingAuthor.setBackground(Color.CYAN);
		sortDescendingAuthor.setForeground(Color.blue);
		sortDescendingAuthor.setFont(new Font("SansSerif", Font.BOLD, 16));
		sortAscendingDatePublished.setBackground(Color.CYAN);
		sortAscendingDatePublished.setForeground(Color.blue);
		sortAscendingDatePublished.setFont(new Font("SansSerif", Font.BOLD, 16));
		sortDescendingDatePublished.setBackground(Color.CYAN);
		sortDescendingDatePublished.setForeground(Color.blue);
		sortDescendingDatePublished.setFont(new Font("SansSerif", Font.BOLD, 16));

		fileMenu.add(exit);
		bookMenu.add(add);
		bookMenu.add(purchase);
		bookMenu.add(update);
		bookMenu.add(remove);
		searchMenu.add(searchID);
		searchMenu.add(searchAuthor);
		printMenu.add(printAll);
		sortMenu.add(sortAscendingAuthor);
		sortMenu.add(sortDescendingAuthor);
		sortMenu.add(sortAscendingDatePublished);
		sortMenu.add(sortDescendingDatePublished);
		frame.setJMenuBar(menuBar);
		exit.addActionListener(new ExitListener());
		// add.addActionListener(new AddBookListener());
		// purchase.addActionListener(new PurchaseBookListener());
		// update.addActionListener(new UpdateBookListener());
		// remove.addActionListener(new RemoveBookListener());
		searchID.addActionListener(new SearchIDListener());
		// searchAuthor.addActionListener(new SearchAuthorListener());
		// printAll.addActionListener(new PrintAllListener());

		sortAscendingAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				library.readFile();
				List<Book> books = library.getList();
				library.selectionSortAscendingAuthor(books);
				String output = "";

				for (int i = 0; i < books.size(); i++) {
					output += books.get(i) + "\n";
				}
				text.setText(output);
			}

		});

	}
	


	private void loadBooks() {
		library.readFile();
		List<Book> books = library.getList();
		library.selectionSortAverageRating(books);
		String output = "";
		for (int i = 0; i < 10; i++) {
			output += books.get(i) + "\n";
		}
		text.setText(output);
	}

	private class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	private class SearchIDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String ID = JOptionPane.showInputDialog("Enter ISBN");
				int ISBN = Integer.parseInt(ID.trim());
				/*
				 * Book book = library.searchBook(ISBN); if(book != null) {
				 * text.setText(book.toString()); } else { JOptionPane.showMessageDialog(null,
				 * "There is no book with that ISBN"); }
				 */
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid ISBN");
			}

		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
