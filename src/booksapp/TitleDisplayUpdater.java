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
public class TitleDisplayUpdater {
    
    private DatabaseService databaseService;
    private JTextArea display;
    
    public TitleDisplayUpdater(DatabaseService databaseService, JTextArea display) {
        this.databaseService = databaseService;
        this.display = display;
    }
    
    public void updateTitles(Author author) {
        List<Title> titles = databaseService.getTitlesByAuthor(author);
        String text = "";
        for (Title title : titles) {
            text += title.getTitle() + ", " + title.getCopyright() + ", " + title.getIsbn() + "\n";
        }
        display.setText(text);
    }
}
