import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookOrganizerTest {
    private BookOrganizer organizer;
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void setUp() {
        organizer = new BookOrganizer();
        book1 = new Book("Title1", "Author1", 1, 100);
        book2 = new Book("Title2", "Author2", 2, 200);
        book3 = new Book("Title3", "Author3", 3, 150);
    }

    @Test
    public void testAddBook() {
        organizer.addBook(book1);
        assertEquals(1, organizer.listBook().length);
    }

    @Test
    public void testAddBookIn() {
        organizer.addBook(book1);
        organizer.addBookIn(0, book2);
        assertEquals(book2.toString(), organizer.searchingByTitle("Title2"));
    }

    @Test
    public void testRemoveBook() {
        organizer.addBook(book1);
        organizer.removeBook(0);
        assertEquals(0, organizer.listBook().length);
    }

    @Test
    public void testRemoveBookId() {
        organizer.addBook(book1);
        organizer.removeBookId(1);
        assertEquals(0, organizer.listBook().length);
    }

    @Test
    public void testSearchingByTitle() {
        organizer.addBook(book1);
        assertEquals(book1.toString(), organizer.searchingByTitle("Title1"));
    }

    @Test
    public void testSearchingObjByTitle() {
        organizer.addBook(book1);
        assertEquals(book1, organizer.searchingObjByTitle("Title1"));
    }

    @Test
    public void testListBook() {
        organizer.addBook(book1);
        organizer.addBook(book2);
        String[] bookList = organizer.listBook();
        assertEquals(2, bookList.length);
        assertEquals("Title1 by: \"Author1", bookList[0]);
        assertEquals("Title2 by: \"Author2", bookList[1]);
    }

    @Test
    public void testSearchingByAuthor() {
        organizer.addBook(book1);
        assertEquals(book1.toString(), organizer.searchingByAuthor("Author1"));
    }

    @Test
    public void testRepOK() {
        organizer.addBook(book1);
        organizer.addBook(book2);
        assertTrue(organizer.repOK());
    }
}

