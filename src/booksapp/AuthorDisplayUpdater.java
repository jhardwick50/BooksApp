/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Jason
 */
public class AuthorDisplayUpdater {
    
    private DatabaseService databaseService;
    private JTextArea display;
    /**
     * Update display screen
     * @param databaseService
     * @param display 
     */
    public AuthorDisplayUpdater(DatabaseService databaseService, JTextArea display) {
        this.databaseService = databaseService;
        this.display = display;
    }
    
    /**
     * Update the display with author information based on the title.
     * 
     * @param title The title
     */
    public void updateAuthors(Title title) {
        List<Author> authors = databaseService.getAuthorsByTitle(title);
        String text = "";
        for (Author author : authors) {
            text += author.getLastName() + ", " + author.getFirstName() + "\n";
        }
        display.setText(text);
    }
}
