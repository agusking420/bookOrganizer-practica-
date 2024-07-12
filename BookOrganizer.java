import java.util.ArrayList;
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
        if(bookCollection == null){
            throw new IllegalArgumentException("a list can´t be a null");
        }
        //Arraylist of save a books
        bookCollection = new ArrayList<>();
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
    }
    
    /**
     * this method remove a book from the list
     */
    public void removeBook(int position){
        for(int i = 0 ; i < bookCollection.size() ; i++){
            if (position )
        }
    }
}
