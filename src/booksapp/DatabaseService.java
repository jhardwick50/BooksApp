/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jason
 */
public class DatabaseService {
    
    private Connection connection;
    
    public DatabaseService() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "Password");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    public List<Author> getAuthors(){
        
        PreparedStatement selectAuthors;
        ResultSet resultSet = null;
        List<Author> results = new ArrayList<>();
        try{
            selectAuthors = connection.prepareStatement("select * "
                    + "from authors "
                    + "order by lastName, firstName");
            resultSet = selectAuthors.executeQuery();
            while (resultSet.next()){
                Author author = new Author();

                author.setAuthorID(resultSet.getInt("authorID"));
                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                
                results.add(author);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();  
        }
        
        return results;
    }
    
    public List<Author> getAuthorsByTitle(Title title) {
       PreparedStatement selectAuthors;
        ResultSet resultSet = null;
        List< Author > results = new ArrayList<>();
        try{
            // query for specific author
            selectAuthors = connection.prepareStatement("select authors.* "
                    + "from authors, authorisbn, titles "
                    + "where authors.authorid = authorisbn.authorid and authorisbn.isbn = titles.isbn and titles.isbn = ? "
                    + "order by authors.lastName, authors.firstName");
            selectAuthors.setString(1, title.getIsbn()); // set authorid in query
            
            resultSet = selectAuthors.executeQuery();
           
            while (resultSet.next()){
                Author author = new Author();

                author.setFirstName(resultSet.getString("firstName"));
                author.setLastName(resultSet.getString("lastName"));
                //ToDO add other fields
                
                results.add(author);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();  
        }
        
        return results;
    }
    
    public List<Title> getTitles() {
        PreparedStatement selectTitles;
        ResultSet resultSet = null;
        List<Title> results = new ArrayList<>();
        try{
            selectTitles = connection.prepareStatement("select * "
                    + "from titles "
                    );
            resultSet = selectTitles.executeQuery();
            while (resultSet.next()){
                Title title = new Title();

                title.setTitle(resultSet.getString("title"));
                title.setIsbn(resultSet.getString("isbn"));
                
                results.add(title);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();  
        }
        return results;
    }
    
    public List<Title> getTitlesByAuthor(Author author) {
        
        PreparedStatement selectTitles;
        ResultSet resultSet = null;
        List< Title > results = new ArrayList<>();
        try{
            // query for specific author
            selectTitles = connection.prepareStatement("select titles.* "
                    + "from authors, authorisbn, titles "
                    + "where authors.authorid = authorisbn.authorid and authorisbn.isbn = titles.isbn and authors.authorid = ? "
                    + "order by titles.title");
            selectTitles.setInt(1, author.getAuthorID()); // set authorid in query
            
            resultSet = selectTitles.executeQuery();
           
            while (resultSet.next()){
                Title title = new Title();

                title.setTitle(resultSet.getString("title"));
                title.setCopyright(resultSet.getString("copyright"));
                title.setIsbn(resultSet.getString("isbn"));
                //ToDO add other fields
                
                results.add(title);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();  
        }
        
        return results;
    }
    
   
    
}
