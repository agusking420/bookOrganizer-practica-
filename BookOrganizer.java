import java.util.ArrayList;
import java.util.*;

/**
 * this class represent a book organizer.
 * this is a list of books
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookOrganizer
{
    // Arraylist of save a books
    private ArrayList <Book> bookCollection;

    /**
     * Constructor for objects of class BookOrganizer
     */
    public BookOrganizer()
    {
        //Arraylist of save a books
        bookCollection = new ArrayList<>();
        assert repOK() : "invalid obj in constructor";
    }

    /**
     * this method add a book to the list.
     * the book can´t be null.
     * 
     * @param new book to add to the list 
     */
    public void addBook(Book newBook)
    {
        if(newBook == null){
            throw new IllegalArgumentException("a book is invalid");
        }
        bookCollection.add(newBook);
        assert repOK() : "invalid obj in addBook method";
    }
    
    /**
     * this method add a book to the list.
     * the position can´t out of the rang of list
     * the book can´t be null.
     * 
     * @param position where add a book and new book to add to the list 
     */
    public void addBookIn(int position, Book newBook)
    {
        if(position < 0 || position > bookCollection.size()){
            throw new IllegalArgumentException("a position is out of range of this list");
        }
        if(newBook == null){
            throw new IllegalArgumentException("a book is invalid");
        }
        bookCollection.add(position, newBook);
        assert repOK() : "invalid obj in addBookIn method";
    }
    
    /**
     * this method remove a book from the list introducing a position of 
     * the book in the list
     */
    public void removeBook(int position)
    {
        if (position < 0 || position >= bookCollection.size()) {
            throw new IndexOutOfBoundsException("Position is out of range");
        }
        bookCollection.remove(position);
        assert repOK() : "invalid obj in removeBookId method";
    }
    
    /**
     * this method remove a book from the list using the id of the book
     */
    public void removeBookId(int id) {
        /*
         * bookCollection.iterator() retorna un objeto Iterator<Book> 
         * que se puede usar para recorrer la colección bookCollection.
         * Un Iterator es una estructura que permite recorrer una 
         * colección de elementos uno a uno.
         */
        Iterator<Book> iterator = bookCollection.iterator();
        /*
         * iterator.hasNext() verifica si hay más elementos en la 
         * colección para iterar. Retorna true si hay más elementos 
         * y false si no los hay. y se repite hasta que no haya mas
         */
        while (iterator.hasNext()) {
            Book libro = iterator.next(); //obtener el siguiente elemento
            if (libro.getId() == id) {
                iterator.remove();
                break; /* break
                *interrumpe automaticamente el while luego de eliminar 
                *el primer elemento con esa id, si se quisieran eliminar 
                *mas elementos se podria omitir.
                */
                
            }
        }
        assert repOK() : "invalid obj in removeBookId method";
    }
    
    /**
     * this method creates a array with a list of 
     * books in the bookCollection 
     */
    public String[] listBook(){
        String libros[] = new String[bookCollection.size()];
        for(int i = 0 ; i < bookCollection.size() ; i++){
            Book currLibro = bookCollection.get(i);
            libros[i] = currLibro.getTitle() + " by: \"" + 
                        currLibro.getAuthor();
        }
        return libros;
    }
    
    /**
     * search a book in the BookCollection using the title of that book.
     * 
     * @param title The title of the book to search for.
     * @return A string representation of the book if found, otherwise a 
     * message indicating the book was not found.
     */
    public String searchingByTitle(String title){
        for(int i = 0 ; i < bookCollection.size() ; i++){
            Book libro = bookCollection.get(i);
            String currLibro = libro.getTitle();
            if(currLibro.equals(title)){
                return libro.toString();
            }
        }
        return"book not found";
    }
    
    //este metodo a dif del de arriba te retorna el ob libro, no sus datos
    /**
     * Searches for a book in the BookCollection using the title of 
     * that book.
     *
     * @param title The title of the book to search for.
     * @return The book object if found, otherwise null.
     */
    public Book searchingObjByTitle(String title) {
        for (int i = 0; i < bookCollection.size(); i++) {
            Book libro = bookCollection.get(i);
            String currLibro = libro.getTitle();
            if (currLibro.equals(title)) {
                return libro;
            }
        }
        return null;
    }
    
    /**
     * search a book in the BookCollection using the Author of that book
     */
    public String searchingByAuthor(String author){
        for(int i = 0 ; i < bookCollection.size() ; i++){
            Book libro = bookCollection.get(i);
            String currLibro = libro.getTitle();
            if(currLibro.equals(author)){
                return libro.toString();
            }
        }
        return"book not found";
    }
    
    
    
    /**
     * Checks the invariant of the class.
     * the bookCollection can´t be null
     * the books in bookCollection can´t be invalid
     * 
     * @return true if the object's state is valid, else false
     */
    public boolean repOK(){
        if(bookCollection == null){
            return false;
        }
        for(Book libro : bookCollection){        
            if(!libro.repOK()){
                return false;
            }
        }
        return true;
    }
}

