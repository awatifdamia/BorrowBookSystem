import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame implements ActionListener {
    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaBooks;

    public AddBookGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Top Input Panel
        JPanel pInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblTitle = new JLabel("Book Title:");
        txtTitle = new JTextField(20);
        lblAuthor = new JLabel("Author:");
        txtAuthor = new JTextField(20);

        pInput.add(lblTitle);
        pInput.add(txtTitle);
        pInput.add(lblAuthor);
        pInput.add(txtAuthor);

        // Center Button Panel
        JPanel pButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
        pButton.add(btnAdd);
        pButton.add(btnList);

        JPanel pNorth = new JPanel(new BorderLayout());
        pNorth.add(pInput, BorderLayout.NORTH);
        pNorth.add(pButton, BorderLayout.CENTER);

        // Bottom Display Area
        JPanel pSouth = new JPanel(new BorderLayout());
        lblBooks = new JLabel("Books:");
        txtAreaBooks = new JTextArea(6, 30);
        txtAreaBooks.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaBooks);

        pSouth.add(lblBooks, BorderLayout.NORTH);
        pSouth.add(scrollPane, BorderLayout.CENTER);

        pane.add(pNorth, BorderLayout.NORTH);
        pane.add(pSouth, BorderLayout.CENTER);

        setTitle("Add Book Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                Book b = new Book(title, author);
                MainMenuGUI.bookList.add(b);
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaBooks.setText("");
            for (Book b : MainMenuGUI.bookList) {
                txtAreaBooks.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }
}
