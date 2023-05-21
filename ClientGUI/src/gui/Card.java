package gui;

import mysqlhelper.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JPanel{
    public Integer ID;
    public Integer personalID;
    public JButton exit = new JButton("X");
    public JLabel type = new JLabel();
    public JLabel money = new JLabel();
    public JLabel number = new JLabel();
    public Card(Account card) {
        this.type.setText(card.type);
        this.money.setText(card.money.toString());
        ID = card.ID;
        personalID = card.personalID;
        this.number.setText(ID.toString());
                GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        this.setBackground(Color.PINK);
        this.type.setFont(this.type.getFont().deriveFont (64.0f));
        this.money.setFont(this.money.getFont().deriveFont (24.0f));
        gl.setVerticalGroup(
                gl.createParallelGroup()
                        .addComponent(this.number,10,30,30)
                        .addComponent(this.type,10,70,70)
                        .addComponent(this.money,10,100,100)
                        .addComponent(this.exit,10,100,100)
        );
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                        .addComponent(this.number,10,100,100)
                        .addComponent(this.type,10,150,150)
                        .addComponent(this.money,10,250,250)
                        .addComponent(this.exit,10,100,100)
        );
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}