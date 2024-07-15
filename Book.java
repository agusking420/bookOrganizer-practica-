
/**
 * This class reprecents a book.
 * contains autor, title, id,and number of pages. 
 * 
 * @author R. Morosi. 
 * @version 11/07/24.
 */
public class Book
{
    //autor of the book
    private String author;
    //title of the book
    private String title;
    //id num of the book
    private int bookId;
    //num of pages in the book
    private int pages;

    /**
     * Constructor for objects of class Book
     * creates a book object with parameters provided by user
     * author can´t be null or void, in this case author is "unknow", 
     * title can´t be null or void, in this case title is "unknow", 
     * id and cantPages can´t be <=0.
     * 
     * @param author, is a author of book
     * @param title, is a title of book
     * @param id, is a id of book 
     * @param cantPages, is a cant of Pages in a book
     */
    public Book(String author, String title, int id, int cantPages)
    {
        if(author == null || author.trim().isEmpty()){
            author = "unknow";
        }
        else{
            this.author = author;
        }
        if(title == null || title.trim().isEmpty()){
            title = "unknow";}
        else{
            this.title = title;
        }
        if(id <= 0){
            throw new IllegalArgumentException("ID of book is invalid");
        }
        else{
            this.bookId = id;
        }
        if(cantPages <= 0){
            throw new IllegalArgumentException("cant of pages of book is invalid");
        }
        else{
        this.pages = cantPages;
        }
        assert repOK() : "invalid Obj in constructor";
    }

    /**
     * this method gets the title of the book, prints a message with 
     * the title.
     *
     * @return the title of the book 
     */
    public String getTitle()
    {
        System.out.println("title of this book is \"" + title + "\"");
        return title;
    }
    
    /**
     * this method gets the author of the book, and print a message 
     * with the author.
     * 
     * @return the author of the book 
     */
    public String getAuthor()
    {
        System.out.println("author of this book is " + author);
        return this.author;
    }
    
    /**
     * this method gets the ID of book,and print a message with the ID.
     * 
     * @return the ID of the book
     */
    public int getId()
    {
        System.out.println("ID of this book is " + bookId);
        return bookId;
    }
    
    /**
     * this method gets the pages of book, and print a message with 
     * the number of pages.
     * 
     * @return the number of pages in the boook 
     */
    public int getPages()
    {
        System.out.println("cant of pages of this book is " + pages);
        return pages;
    }
    
    /**
     * this method sets a new title for the book.
     * the new title can´t be null or empty
     * 
     * @param title, title of the book
     */
    public void setTitle(String title){
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("the author is invalid");
        }
        this.title = title;
        assert repOK() : "invalid Obj in method setTitle";
    }
    
    /**
     * this method sets a new author for the book.
     * the new author can´t be null or empty
     * 
     * @param author, author of the book
     */
    public void setAuthor(String author){
        if(author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("the author is invalid");
        }
        this.author = author;
        assert repOK() : "invalid Obj in method setAuthor";
    }
    
    /**
     * this method sets a new ID for the book.
     * new ID can´t be <= 0
     * 
     * @param id, the ID of the book
     */
    public void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException("the ID is invalid");
        }
        this.bookId = id;
        assert repOK() : "invalid Obj in method setId";
    }
    
    /**
     * this method sets a new number of pages for the book.
     * new numer of pages can´t be <= 0
     * 
     * @param pages, number of the pages in the book
     */
    public void setPages(int pages){
        if(pages <= 0){
            throw new IllegalArgumentException("the pages are invalid");
        }
        this.pages = pages;
        assert repOK() : "invalid Obj in method setPages";
    }
    
    /**
     * this method print all data of a book
     * 
     * @return A string representation of the book 
     */
    public String toString(){
        System.out.println("this book is \"" + title + "\""); 
        System.out.println(" by: " + author);
        System.out.println("a ID for it is: " + bookId); 
        System.out.println("and have " + pages + " pages");
        
        return "this book is \"" + title + "\" by: " + author + "a ID for it is: " + 
        bookId + "and have " + pages + " pages";
    }
    
    /**
     * Checks the invariant of the class.
     * Author and title can't be null or empty. Book ID and pages 
     * can't be <= 0.
     * 
     * @return true if the object's state is valid, else false
     */
    public boolean repOK(){
        if(author == null || author.trim().isEmpty()){
            return false;
        }
        if(title == null || title.trim().isEmpty()){
            return false;
        }
        if(bookId <= 0){
            return false;
        }
        if(pages <= 0){
            return false;
        }
        return true;
    }
}
