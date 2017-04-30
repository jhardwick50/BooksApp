/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Jason
 */
public class AuthorComboBoxListener implements ActionListener{
    private TitleDisplayUpdater titleUpdater;
    
    AuthorComboBoxListener(TitleDisplayUpdater titleUpdater){
        this.titleUpdater = titleUpdater;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox authorListBox = (JComboBox) e.getSource();
        Author author = (Author) authorListBox.getSelectedItem();
        
        titleUpdater.updateTitles(author);
    }
    
}
