package gui;

import client.Client;
import mysqlhelper.Account;
import pack.Pack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CardWindow extends JFrame {
    private JButton transaction = new JButton();
    public CardWindow(Pack pack, Client client){
        transaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionWindow(client,pack).setVisible(true);
            }
        });
        this.setSize(600,450);
         GroupLayout gl = new GroupLayout(getContentPane());
         setLayout(gl);
         switch (pack.accounts.size())
         {
             case 1:
                 gl.setVerticalGroup(
                         gl.createSequentialGroup()
                                 .addGap(10)
                                 .addComponent(transaction,60,60,60)
                                 .addGap(10)
                                 .addGroup(
                                        gl.createParallelGroup()
                                                .addComponent(new Card(pack.accounts.get(0)),10,100,100)
                                                .addGap(10)
                                 )
                 );
                 gl.setHorizontalGroup(
                     gl.createParallelGroup()
                             .addGroup(
                                gl.createSequentialGroup()
                                    .addGap(10)
                                    .addComponent(transaction,0,580, 580)
                                    .addGap(10)
                             )
                             .addGroup(
                                     gl.createSequentialGroup()
                                             .addGap(10)
                                             .addComponent(new Card(pack.accounts.get(0)),0,580,580)
                                             .addGap(10)
                             )

                 );
                 break;
             case 2:
                 gl.setVerticalGroup(
                         gl.createSequentialGroup()
                                 .addGap(10)
                                 .addComponent(transaction,60,60,60)
                                 .addGap(10)
                                 .addGroup(
                                         gl.createParallelGroup()
                                                 .addComponent(new Card(pack.accounts.get(0)),10,100,100)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),10,100,100)
                                                 .addGap(10)
                                 )
                 );
                 gl.setHorizontalGroup(
                         gl.createParallelGroup()
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(transaction,0,580, 580)
                                                 .addGap(10)
                                 )
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(0)),0,580,580)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),0,580,580)
                                                 .addGap(10)
                                 )

                 );
                 break;
             case 3:
                 gl.setVerticalGroup(
                         gl.createSequentialGroup()
                                 .addGap(10)
                                 .addComponent(transaction,60,60,60)
                                 .addGap(10)
                                 .addGroup(
                                         gl.createParallelGroup()
                                                 .addComponent(new Card(pack.accounts.get(0)),10,100,100)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),10,100,100)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(2)),10,100,100)
                                                 .addGap(10)
                                 )
                 );
                 gl.setHorizontalGroup(
                         gl.createParallelGroup()
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(transaction,0,580, 580)
                                                 .addGap(10)
                                 )
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(0)),0,580,580)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),0,580,580)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(2)),0,580,580)
                                                 .addGap(10)

                                 )

                 );
                 break;
             default:
                 gl.setVerticalGroup(
                         gl.createSequentialGroup()
                                 .addGap(10)
                                 .addComponent(transaction,60,60,60)
                                 .addGap(10)
                                 .addGroup(
                                         gl.createParallelGroup()
                                                 .addComponent(new Card(pack.accounts.get(0)),10,100,100)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),10,100,100)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(2)),10,100,100)
                                                 .addGap(10)
                                 )
                 );
                 gl.setHorizontalGroup(
                         gl.createParallelGroup()
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(transaction,0,580, 580)
                                                 .addGap(10)
                                 )
                                 .addGroup(
                                         gl.createSequentialGroup()
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(0)),0,580,580)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(1)),0,580,580)
                                                 .addGap(10)
                                                 .addComponent(new Card(pack.accounts.get(2)),0,580,580)
                                                 .addGap(10)

                                 )

                 );
         }

    }

}
