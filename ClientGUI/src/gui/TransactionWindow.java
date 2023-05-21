package gui;

import client.Client;
import mysqlhelper.Account;
import mysqlhelper.PersonalData;
import pack.Actions;
import pack.Pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionWindow extends JFrame {
    private JButton send = new JButton("send");
    private JTextField toID = new JTextField();
    private JTextField fromID = new JTextField();
    private JTextField sum = new JTextField();
    private int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private int MAX_SZ = GroupLayout.DEFAULT_SIZE;
    Pack pack1;

    public TransactionWindow(Client client, Pack pack)
    {
        this.pack1 = pack;
        setSize(600,450);
        GroupLayout gl = new GroupLayout(getContentPane());
        setLayout(gl);
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                        .addGap(8,8, Integer.MAX_VALUE)
                        .addGroup(gl.createParallelGroup()
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(fromID, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(toID,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(sum, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(send,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                        )
                        .addGap(8,8, Integer.MAX_VALUE)
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGap(8,8,Integer.MAX_VALUE)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(fromID,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(toID, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(sum,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(send, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGap(8,8,Integer.MAX_VALUE)
        );
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                for(int i = 0; i<pack.accounts.size();i++)
                {
                    if(Integer.parseInt(fromID.getText()) == pack.accounts.get(i).ID)
                    {
                        check = true;
                    }
                }
                if(Integer.parseInt(send.getText()) <= 0 || check)
                {
                    send.setBackground(Color.red);
                }
                else
                {
                    Pack pack = new Pack();
                    pack.action = Actions.TRANSACTION;
                    pack.personalData = pack1.personalData;
                    ArrayList<Account> a = new ArrayList<>();
                    a.add(new Account(Integer.parseInt(fromID.getText())));
                    a.add(new Account(Integer.parseInt(toID.getText())));
                    pack.accounts = a;
                    try {
                        client.send(pack);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
}
