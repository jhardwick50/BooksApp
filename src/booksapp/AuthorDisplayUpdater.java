/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import javax.swing.JTextArea;

/**
 *
 * @author Jason
 */
public class AuthorDisplayUpdater {
    
    private DatabaseService databaseService;
    private JTextArea display;
    
    public AuthorDisplayUpdater(DatabaseService databaseService, JTextArea display) {
        this.databaseService = databaseService;
        this.display = display;
    }
    
    public void updateAuthors(Title title) {
        throw new RuntimeException("Make me work");
    }
}
