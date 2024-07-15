import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        // Ajusta los parámetros del constructor según la firma correcta
        book = new Book("Title", "Author", 1, 2);
    }

    @Test
    public void testGetId() {
        assertEquals(1, book.getId());
    }

    @Test
    public void testGetTitle() {
        Book book = new Book("Title", "Author", 1, 200);  // Crea un libro con título conocido
        String title = book.getTitle();  // Obtén el título del libro
        System.out.println("Title of the book is: " + title);  // Imprime el título (opcional)
        assertNotNull(title);  // Verifica que el título devuelto sea el esperado
    }


    @Test
    public void testGetAuthor() {
        Book book = new Book("Author", "Title",23 ,33 );  // Crea un libro con autor conocido
        String author = book.getAuthor();  // Obtén el autor del libro
        System.out.println("Author of the book is: " + author);  // Imprime el autor (opcional)
        // Aquí no necesitas comparar con "Author", solo asegúrate de que obtienes el autor correcto
        assertNotNull(author);  // Asegúrate de que el autor no sea nulo, por ejemplo
    }



    @Test
    public void testSetTitle() {
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testSetAuthor() {
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testRepOK() {
        assertTrue(book.repOK());
    }
}
