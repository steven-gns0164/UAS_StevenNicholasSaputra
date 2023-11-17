/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class GameList {

    public GameList(int id) {
        listGameList(id);
    }

    private void listGameList(int id) {
        
        Controller con = new Controller();
        //=============BAGIAN CONTAINER================
        JFrame formGamelist = new JFrame("GameList Menu");
        formGamelist.setSize(320, 350);
        formGamelist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formGamelist.setLocationRelativeTo(null);
        formGamelist.setLayout(null);
        //================END CONTAINER=================
        
        JButton buttonTransactions = new JButton("Transactions");
        buttonTransactions.setBounds(170, 10, 120, 30);
        formGamelist.add(buttonTransactions);
        buttonTransactions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    formGamelist.dispose();
                    new TransactionsMenu(id);
            }
        });
        
        JLabel labelGamelist = new JLabel("Hi, Welcome to GameList");
        labelGamelist.setBounds(10, 10, 250, 30);
        formGamelist.add(labelGamelist);
        
        //Name
        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(10, 45, 80, 30);
        formGamelist.add(labelName);
        
        JTextField textName = new JTextField();
        textName.setBounds(90, 45, 150, 30);
        formGamelist.add(textName);
        
        
        //Genre
        JLabel labelGenre = new JLabel("Genre : ");
        labelGenre.setBounds(10, 80, 80, 30);
        formGamelist.add(labelGenre);
        
        JTextField textGenre = new JTextField();
        textGenre.setBounds(90,80, 150, 30);
        formGamelist.add(textGenre);
        
        //Price
        JLabel labelPrice = new JLabel("Price : ");
        labelPrice.setBounds(10, 115, 80, 30);
        formGamelist.add(labelPrice);
        
        JTextField textPrice = new JTextField();
        textPrice.setBounds(90, 115, 150, 30);
        formGamelist.add(textPrice);
        
        JButton buyGame = new JButton("Buy Game");
        buyGame.setBounds(90, 140, 150, 30);
        formGamelist.add(buyGame);
        buyGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String genre = textGenre.getText();
                String price = textPrice.getText();

                if (name.isEmpty() || genre.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(formGamelist, "Masih Kosong!", "Empty Field", JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean gameFound = con.getGame(name, genre, price);
                    if (gameFound) {
                        int idGame = con.getIDGames(name);
                        String idGametemp = String.valueOf(idGame);
                        String idUsertemp = String.valueOf(id);
                        boolean transFound = con.findTR(id, idGame);
                        if (!transFound) {
                            boolean succeed = con.inputDataToDB(idUsertemp, idGametemp);
                            formGamelist.dispose();
                            if (succeed) {
                                JOptionPane.showMessageDialog(formGamelist, "Data berhasil disimpan");
                                new TransactionsMenu(id);
                            }
                        } else {
                            JOptionPane.showMessageDialog(formGamelist, "Transactions Found", "Exist", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(formGamelist, "No Game Found", "Not Found", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }

        });
        
        formGamelist.setVisible(true);
    }
}
