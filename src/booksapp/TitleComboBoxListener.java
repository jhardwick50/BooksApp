/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Jason
 */
public class TitleComboBoxListener implements ActionListener {
    private AuthorDisplayUpdater authorUpdater;
    
    TitleComboBoxListener (AuthorDisplayUpdater authorUpdater){
        this.authorUpdater = authorUpdater;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox titleListBox = (JComboBox) e.getSource();
        Title title = (Title) titleListBox.getSelectedItem();
        
        authorUpdater.updateAuthors(title);    }
    
}
