/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;


import java.util.List;
import org.junit.Test;

/**
 *
 * @author Jason
 */
public class DatabaseServiceTests {
    @Test
    public void test_getAuthors(){
        
        DatabaseService service = new DatabaseService();
        List<Author> result = service.getAuthors();
        
        for(Author author : result){
            System.out.println(author.getAuthorID());
        }
    }
    
}
