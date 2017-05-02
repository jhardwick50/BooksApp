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
public class QueryDisplayUpdater {
    private DatabaseService databaseService;
    private JTextArea display;
    
    public QueryDisplayUpdater(DatabaseService databaseService, JTextArea display) {
        this.databaseService = databaseService;
        this.display = display;
}
    public void updateQueryResults(String query) {
        // Execute query on databse service
        List<String> queryResults = databaseService.runQuery(query);
        String text = "";
        for (String result : queryResults) {
            text += result + "\n";
        }
        display.setText(text);
    }
}
