import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//testclassnasheee

public class MapBookOrganizerTest {
    private MapBookOrganizer mapOrganizer;
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void setUp() {
        mapOrganizer = new MapBookOrganizer();
        book1 = new Book("Title1", "Author1", 1, 100);
        book2 = new Book("Title2", "Author2", 2, 200);
        book3 = new Book("Title1", "Author1", 3, 150); // Duplicado por título
    }

    @Test
    public void testPutBook() {
        mapOrganizer.putBook(1, book1);
        assertEquals(1, mapOrganizer.mapaLibrary.size());
    }

    @Test
    public void testPubBookKeyless() {
        mapOrganizer.pubBookKeyless(book2);
        assertEquals(1, mapOrganizer.mapaLibrary.size());
    }

    @Test
    public void testRemoveBook() {
        mapOrganizer.putBook(1, book1);
        mapOrganizer.removeBook(1);
        assertEquals(0, mapOrganizer.mapaLibrary.size());
    }

    @Test
    public void testSearchingById() {
        mapOrganizer.putBook(1, book1);
        assertEquals("Title1 by: \"Author1\"", mapOrganizer.searchingById(1));
    }

    @Test
    public void testOrganizedForAuthor() {
        mapOrganizer.putBook(1, book1);
        mapOrganizer.putBook(2, book2);
        mapOrganizer.organizedForAuthor();
        assertEquals("Author1", mapOrganizer.mapaLibrary.get(1).getAuthor());
        assertEquals("Author2", mapOrganizer.mapaLibrary.get(2).getAuthor());
    }

    @Test
    public void testNoDuplicates() {
        mapOrganizer.putBook(1, book1);
        mapOrganizer.putBook(2, book2);
        mapOrganizer.putBook(3, book3);
        mapOrganizer.noDuplicates();
        assertEquals(2, mapOrganizer.mapaLibrary.size()); // book1 y book3 tienen el mismo título
    }

    @Test
    public void testRepOK() {
        mapOrganizer.putBook(1, book1);
        mapOrganizer.putBook(2, book2);
        assertTrue(mapOrganizer.repOK());
    }
}
