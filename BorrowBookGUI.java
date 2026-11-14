import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBookGUI extends JFrame implements ActionListener {
    private JLabel lblStudent, lblBook, lblBorrowHeader, lblBorrowOutput;
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;

    public BorrowBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Top Selection Panel
        JPanel pTop = new JPanel(new GridLayout(2, 2, 5, 5));
        lblStudent = new JLabel("Student Name & Matric:");
        lblBook = new JLabel("Book Title & Author:");

        cmbStudent = new JComboBox<>();
        for (Student s : MainMenuGUI.studentList) {
            cmbStudent.addItem(s);
        }

        cmbBook = new JComboBox<>();
        for (Book b : MainMenuGUI.bookList) {
            cmbBook.addItem(b);
        }

        pTop.add(lblStudent);
        pTop.add(cmbStudent);
        pTop.add(lblBook);
        pTop.add(cmbBook);

        // Center Button Panel
        JPanel pCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnBorrow = new JButton("Borrow");
        btnBorrow.addActionListener(this);
        pCenter.add(btnBorrow);

        JPanel pNorth = new JPanel(new BorderLayout());
        pNorth.add(pTop, BorderLayout.NORTH);
        pNorth.add(pCenter, BorderLayout.CENTER);

        // Bottom Borrow Information Panel
        JPanel pBottom = new JPanel(new GridLayout(2, 1));
        lblBorrowHeader = new JLabel("Borrow Information :");
        lblBorrowOutput = new JLabel(" ");
        pBottom.add(lblBorrowHeader);
        pBottom.add(lblBorrowOutput);

        pane.add(pNorth, BorderLayout.NORTH);
        pane.add(pBottom, BorderLayout.SOUTH);

        setTitle("Borrow Book");
        setSize(520, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrow) {
            Student selectedStudent = (Student) cmbStudent.getSelectedItem();
            Book selectedBook = (Book) cmbBook.getSelectedItem();

            if (selectedStudent != null && selectedBook != null) {
                selectedBook.borrowBy(selectedStudent);
                lblBorrowOutput.setText(selectedStudent.getName() + " with matric number "
                        + selectedStudent.getMatric() + " has borrow a book with title "
                        + selectedBook.getTitle() + ".");
            }
        }
    }
}
