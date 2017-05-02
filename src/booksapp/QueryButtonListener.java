/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author Jason
 */
public class QueryButtonListener implements ActionListener {
    private QueryDisplayUpdater queryUpdater;
    private JTextArea query;
    
    public QueryButtonListener(QueryDisplayUpdater queryUpdater, JTextArea query){
        this.queryUpdater = queryUpdater;
        this.query = query;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Link to button and add constructor like others and call updater
        JButton queryButton = (JButton) e.getSource();
        String queryString = query.getText();
        
        queryUpdater.updateQueryResults(queryString);
    }
    
}
