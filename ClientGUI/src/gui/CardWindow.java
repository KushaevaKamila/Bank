package gui;

import javax.swing.*;

public class CardWindow extends JFrame {
    public CardWindow(){
         this.setSize(1000,500);
         Card card = new Card("debit", "e0e030300dengi");
    }
    public class Card extends JPanel{
        public JButton exit = new JButton("X");
        public JLabel type = new JLabel();
        public JLabel money= new JLabel();
        public Card(String type, String money){
            this.type.setText(type);
            this.money.setText(money);
            GroupLayout gl = new GroupLayout(getContentPane());
            setLayout(gl);

            gl.setHorizontalGroup(
                    gl.createSequentialGroup()
                            .addComponent(this.money,20,50,100)
                            .addComponent(this.type,20,50,100)
            );
            gl.setVerticalGroup(
                    gl.createParallelGroup()
                            .addComponent(this.money,20,50,100)
                            .addComponent(this.type,20,50,100)
            );
        }
    }
}
