/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author Jason
 */
public class DatabaseQueryTool extends JFrame{
    
   private JTextArea display;
   private JComboBox authorListCombo;
   private JComboBox titleListCombo;
   private JTextArea query;
   private JButton submit;
   private DatabaseService ds = new DatabaseService();
   
   private TitleDisplayUpdater titleUpdater;
   private AuthorDisplayUpdater authorUpdater;
    
    public DatabaseQueryTool(){
        
        this.setLayout(new GridLayout(5, 1));
        display = new JTextArea();
        display.setSize(500,100);
        
        JScrollPane scrollPane = new JScrollPane(display);
        this.add(scrollPane);
        
        this.titleUpdater = new TitleDisplayUpdater(ds, display);
        this.authorUpdater = new AuthorDisplayUpdater(ds, display);
        authorListCombo = new JComboBox();
        
        populateAuthorList();
        updateSelectedAuthorTitles();
        
        authorListCombo.setSize(500, 20);
        authorListCombo.addActionListener(new AuthorComboBoxListener(titleUpdater));
        this.add(authorListCombo);
        
        
        titleListCombo = new JComboBox();
        
        populateTitleList();
        
        titleListCombo.setSize(500, 20);
        titleListCombo.addActionListener(new TitleComboBoxListener(authorUpdater));
        this.add(titleListCombo);
        
        
        query = new JTextArea();
        query.setSize(500, 20);
        this.add(query);
        
        submit = new JButton();
        submit.setText("Submit");
        this.add(submit);
        submit.setSize(500, 20);
        
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }  
    
    private void populateAuthorList(){
        List<Author> authors = ds.getAuthors();
        
        // for each author
        for (int i = 0; i < authors.size(); i++){
            authorListCombo.addItem(authors.get(i));
        }
    }
    
    private void updateSelectedAuthorTitles() {
        Author author = (Author) authorListCombo.getSelectedItem();
        titleUpdater.updateTitles(author);
    }
    
    private void populateTitleList() {
        // TODO make me work but don't also update the display since
        List<Title> titles = ds.getTitles();
        
        // for each title
        for (int j = 0; j < titles.size(); j++){
            titleListCombo.addItem(titles.get(j));
    }
    }
}
