import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuGUI extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JButton btnAddStudent, btnAddBook, btnBorrowBook;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    public MainMenuGUI() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        lblTitle = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        btnAddStudent.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnBorrowBook.addActionListener(this);

        pane.add(lblTitle);
        pane.add(btnAddStudent);
        pane.add(btnAddBook);
        pane.add(btnBorrowBook);

        setTitle("Main Menu");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudent) {
            new AddStudentGUI();
        } else if (e.getSource() == btnAddBook) {
            new AddBookGUI();
        } else if (e.getSource() == btnBorrowBook) {
            new BorrowBookGUI();
        }
    }

    public static void main(String[] args) {
        new MainMenuGUI();
    }
}
