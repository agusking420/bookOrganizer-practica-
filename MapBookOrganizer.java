import java.util.Map;
import java.util.HashMap;

/**
 * this class have the same funtion to the BookOrganizer class, but 
 * using a map collection.
 * this class is a collection of books and every books have her key(ID).
 * 
 * @author R. Morosi 
 * @version 12/07
 */
public class MapBookOrganizer
{
    //Map collection
    Map<Integer, Book> mapaLibrary;

    /**
     * Constructor for objects of class MapBookOrganizer
     */
    public MapBookOrganizer()
    {
        mapaLibrary = new HashMap<>();
        assert repOK() : "object invalid in constructor";
    }
    
    /**
     * method to add a book to the collection
     * 
     * @param key, key is a ID of book
     * @param book, is a object book
     */
    public void putBook(int key, Book book){
        if(key < 0){
        throw new IllegalArgumentException("the key is invalid");
        }
        if(book == null || !key.repOK()){
        throw new IllegalArgumentException("the book is invalid"); 
        }
        
        mapaLibrary.put(key, book); 
        assert repOK() : "object invalid in putBook method";
    }
    
    /**
     * method to remove a book to the collection using key(ID) of book
     * 
     * @param key, key is a ID of book
     */
    public void removeBook(int key)
    {
        if(mapaLibrary.containsKey(key)){
            mapaLibrary.remove(key); 
        }else{
            throw new IllegalArgumentException("This key isn´t in this collection");
        }
        assert repOK() : "object invalid in putBook method";
    }
   
    /**
     * method to set keys of map collection
     * 
     * @return keys, keys are a id's of books
     */
    
    public String setId(){
        
    }
    
    /**
     * this method search the book using the ID
     */
    /*
     * puedo crear un hashmap donde a cada libro le asigne una clave y 
     * esa clave sea la id
     * map<integer, Book> mapaLibrary = new hashMap<>();
     */
    public void searchingById(){
        
    }
    
    /**
     * this method is for search with a critery, auhor, title, id. 
     * evrething are searching from this method
     * 
     */
    public void searchWithCritery(){
        //TODO
    }
    
    /**
     * this method is for organizes the books for author.
     * this method add the books by the same author to the array 
     * and print that
     * 
     */
    //usar hashMap
    public void organizedForAuthor(){
        //TODO
    }
    
    /**
     * this method search and remove copy of duplicate book, and show
     * if no exist nothing book duplicate
     */
    //usar hashSet
    public void noDuplicates(){
        //TODO
    }
    
     /**
     * Checks the invariant of the class.
     * the MapBookOrganizer can´t be null
     * the books in MapBookOrganizer can´t be invalid
     * 
     * @return true if the object's state is valid, else false
     */
    public boolean repOK(){
        if(mapaLibrary == null){
            return false;
        }
        if(!mapaLibrary.keySet() <= 0){
                return false;
        }
        if(!mapaLibrary.values().repOK()){
                return false;
        }
        return true;
    }
 }

