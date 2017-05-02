/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booksapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
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
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setSize(500, 600);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setSize(500, 600);
        
        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setLayout(new BorderLayout());
        rightTopPanel.setSize(500, 100);
        rightPanel.add(rightTopPanel, BorderLayout.NORTH);
        
        JPanel rightBottomPanel = new JPanel();
        rightBottomPanel.setLayout(new BorderLayout());
        rightBottomPanel.setSize(500, 500);
        rightPanel.add(rightBottomPanel, BorderLayout.SOUTH);
        //panel.setSize();
        
        display = new JTextArea();
        //display.setSize(500,100);
        display.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(display);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.titleUpdater = new TitleDisplayUpdater(ds, display);
        this.authorUpdater = new AuthorDisplayUpdater(ds, display);
        authorListCombo = new JComboBox();
        
        populateAuthorList();
        updateSelectedAuthorTitles();
        
        //authorListCombo.setSize(500, 20);
        authorListCombo.addActionListener(new AuthorComboBoxListener(titleUpdater));
        rightTopPanel.add(authorListCombo, BorderLayout.NORTH);
        
        
        titleListCombo = new JComboBox();
        
        populateTitleList();
        
        //titleListCombo.setSize(500, 20);
        titleListCombo.addActionListener(new TitleComboBoxListener(authorUpdater));
        rightTopPanel.add(titleListCombo, BorderLayout.SOUTH);
        
        
        query = new JTextArea();
        query.setRows(30);
        rightBottomPanel.add(query, BorderLayout.NORTH);
        
        QueryDisplayUpdater queryUpdater = new QueryDisplayUpdater(ds, display);
        
        submit = new JButton();
        submit.setText("Query");
        rightBottomPanel.add(submit, BorderLayout.SOUTH);
        //submit.setSize(500, 20);
        submit.addActionListener(new QueryButtonListener(queryUpdater, query));
        
        
        this.setLayout(new BorderLayout());
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setVisible(true);
    }  
    
    /**
     * Populate the author combo box.
     */
    private void populateAuthorList(){
        List<Author> authors = ds.getAuthors();
        
        // for each author
        for (int i = 0; i < authors.size(); i++){
            authorListCombo.addItem(authors.get(i));
        }
    }
    /**
     * Update titles based on author selected.
     */
    private void updateSelectedAuthorTitles() {
        Author author = (Author) authorListCombo.getSelectedItem();
        titleUpdater.updateTitles(author);
    }
    
    /**
     * Populate the title combo box.
     */
    private void populateTitleList() {
        // TODO make me work but don't also update the display since
        List<Title> titles = ds.getTitles();
        
        // for each title
        for (int j = 0; j < titles.size(); j++){
            titleListCombo.addItem(titles.get(j));
    }
    }
}
