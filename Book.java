public class Book {
    private String title;
    private String author;
    private Student borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Student getBorrower() {
        return borrower;
    }

    public void borrowBy(Student student) {
        this.borrower = student;
        student.setBorrowedBook(this);
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
