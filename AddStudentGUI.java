import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentGUI extends JFrame implements ActionListener {
    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaStudents;

    public AddStudentGUI() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(10, 10));

        // Top Input Panel
        JPanel pInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblName = new JLabel("Name:");
        txtName = new JTextField(20);
        lblMatric = new JLabel("Matric:");
        txtMatric = new JTextField(20);

        pInput.add(lblName);
        pInput.add(txtName);
        pInput.add(lblMatric);
        pInput.add(txtMatric);

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
        lblStudents = new JLabel("Students:");
        txtAreaStudents = new JTextArea(6, 30);
        txtAreaStudents.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaStudents);

        pSouth.add(lblStudents, BorderLayout.NORTH);
        pSouth.add(scrollPane, BorderLayout.CENTER);

        pane.add(pNorth, BorderLayout.NORTH);
        pane.add(pSouth, BorderLayout.CENTER);

        setTitle("Add Student Info");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                Student s = new Student(name, matric);
                MainMenuGUI.studentList.add(s);
                txtName.setText("");
                txtMatric.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaStudents.setText("");
            for (Student s : MainMenuGUI.studentList) {
                txtAreaStudents.append("Name : " + s.toString() + "\n");
            }
        }
    }
}
