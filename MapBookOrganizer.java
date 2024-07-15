import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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
        if(book == null || !book.repOK()){
        throw new IllegalArgumentException("the book is invalid"); 
        }
        
        mapaLibrary.put(key, book);
        assert repOK() : "object invalid in putBook method";
    }
    
    /**
     * method to add a book to the collection when book have id
     * key is a ID of book
     * 
     * @param book, is a object book
     */
    public void pubBookKeyless(Book book)
    {
        if(book == null || !book.repOK()){
        throw new IllegalArgumentException("the book is invalid"); 
        }
        int key = book.getId();
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
     * this method search the book using the ID
     */
    /*
     * puedo crear un hashmap donde a cada libro le asigne una clave y 
     * esa clave sea la id
     * map<integer, Book> mapaLibrary = new hashMap<>();
     */
    public String searchingById(int key){
        if(key <= 0){
            throw new IllegalArgumentException("key invalid");
        }
        Book libro = mapaLibrary.get(key);
        String libroTitle = libro.getTitle();
        
        assert repOK() : "el metodo searchingById";
        return libroTitle + " by: \"" + libro.getAuthor() + "\"";
    }
    
    /**
     * this method is for search with a critery, auhor, title, id. 
     * evrething are searching from this method
     * 
     */
    public void searchWithCritery(int key, String title, String author, int id)
    {
        if(key > 0){
            mapaLibrary.containsKey(key);
        }
        if(title != null || !title.trim().isEmpty()){
            mapaLibrary.containsValue(title);
        }
        if(author != null || !author.trim().isEmpty()){
            mapaLibrary.containsValue(title);
        }
        if(key > 0){
            searchingById(key);
        }
        assert repOK() : "el metodo searchWithCritery()";
    }
    
    /**
     * this method is for organizes the books for author.
     * this method add the books by the same author to the array 
     * and print that
     * 
     */
    //usar hashMap
    public void organizedForAuthor() {
        /* crea una lista de arreglos desde el mapa
         * el parametro mapaLibrary.values() del ArrayList es porque el array va a
         * guardar los values del mapa es decir los libros
         * esto lo hace porque Collections.sort esta hecho para trabajar con listas
         * no con mapas
         */
        List<Book> books = new ArrayList<>(mapaLibrary.values());

        /* ordena los libros por autor en modo alfabetico
         * Collection.sort ordena la lista de libros.
         * importa el comparator para que compare books con book y ver cual debe 
         * ir antes, sirve para definir el ordenamiento de los objetos
         */
        Collections.sort(books, new Comparator<Book>() {
            @Override //esto quiere decir que un metodo esta sobreescribiendo otro
            //En este caso, indica que el método compare está sobrescribiendo el 
            //método abstracto compare de la interfaz Comparator.
            public int compare(Book b1, Book b2) { //metodo de la clase comparator
                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        /*
         * lo de arriba se podria escribr de forma mas compacta usando lambda
         * Collections.sort(books, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));

         */
        }); //notar que esta todo dentro del parametro de Collection.sort

        // crea un nuevo mapa y agrega todos los libros ordenados
        Map<Integer, Book> sortedMap = new LinkedHashMap<>();
        for (Book book : books) { //itera dentro del ArrayList books creado arriba
            sortedMap.put(book.getId(), book); //y agrega todo en este nuevo mapa ordenado 
            //aca el valor de key es book.getId() ya que usa la ID del libro 
        }

        //reemplaza el mapa original con el nuevo mapa ordenado
        mapaLibrary = sortedMap;

        assert repOK() : "object invalid in organizedForAuthor method";
    }
    
    
    /**
     * this method search and remove copy of duplicate book, and show
     * if no exist nothing book duplicate
     */
    public void noDuplicates() {
        // HashSet para almacenar titulos de libros
        Set<String> uniqueTitles = new HashSet<>();
        // Set para almacenar las key de los libros duplicados
        Set<Integer> duplicateKeys = new HashSet<>();
    
        // Itera sobre las entradas en el mapa
        /**
             * usa un fo-each ya que no se usa iterador porque
             * en un HashSet lo elementos no estan ordenados se 
             * guardan de forma random. 
             * entrySet() devuelve un conjunto de entradas de tipo Map.Entry
             * los cuales tienen una key y un value. este Map.Entry lo
             * guardamos en una var a la que llamamos "entry"
             */
        for (Map.Entry<Integer, Book> entry : mapaLibrary.entrySet()) {
                        
            /* guardamos la key y el value de las entradas
             * iteradas en vars separadas
             */
            Integer key = entry.getKey();
            Book book = entry.getValue();
    
            /* si el titulo ya esta en el set, es un duplicado
             * intemamos agregar el titulo de uniqueTitles, si esta accion
             * devuelve false quiere decir que ya esta esta entrada en el set
             * por lo que agrega la key a duplicateKeys
             */
            if (!uniqueTitles.add(book.getTitle())) {
                duplicateKeys.add(key);
            }
        }
        // si no hay duplicados
        if (duplicateKeys.isEmpty()) {
            System.out.println("No duplicate books found.");
        }
        /* si no elimina el duplicado
         * aca simplemente crea una var key de tipo obj integer para
         * iterar en los elementos almacenados en la var duplicateKeys
         * y los elimina
         */
        for (Integer key : duplicateKeys) {
            mapaLibrary.remove(key);
        }
    
        // imprime la ID (key) de los libros duplicados
        System.out.println("Removed duplicate books with IDs: " + duplicateKeys);
    
        assert repOK() : "object invalid in noDuplicates method";
    }
    
    
     /**
     * Checks the invariant of the class.
     * the MapBookOrganizer can´t be null
     * the books in MapBookOrganizer can´t be invalid
     * 
     * @return true if the object's state is valid, else false
     */
    public boolean repOK(){
        if (mapaLibrary == null) {
        return false;
        }
        for (Book libro : mapaLibrary.values()) {        
            if (!libro.repOK()) {
                return false;
            }
        }
        return true;
        }   
 }