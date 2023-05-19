package gui;

import javax.swing.*;


public class RegWindow extends JFrame {
    private int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private int MAX_SZ = GroupLayout.DEFAULT_SIZE;
    private JLabel lblPhone;
    private JLabel lblName;
    private JLabel lblPassword;
    private JLabel lblPassword2;

    private JTextField tfPhone;
    private JTextField tfName;
    private JTextField tfPassword;
    private JTextField tfPassword2;

    private JButton btnReg;
    private JButton btnCancel;


    public RegWindow(){
        setSize(600,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GroupLayout gl = new GroupLayout(getContentPane());
        setLayout(gl);
        lblPhone = new JLabel("Номер телефона: ");
        lblName = new JLabel("ФИО: ");
        lblPassword = new JLabel("Пароль: ");
        lblPassword2 = new JLabel("Повтор пароля: ");
        tfPhone = new JTextField();
        tfName = new JTextField();
        tfPassword = new JTextField();
        tfPassword2 = new JTextField();
        btnReg = new JButton("Зарегистрироваться");
        btnCancel = new JButton("Я уже смешарик");

        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                        .addGap(8,8, Integer.MAX_VALUE)
                        .addGroup(gl.createParallelGroup()
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(lblPhone, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(tfPhone,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(lblName, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(tfName,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(lblPassword, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(tfPassword,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addComponent(lblPassword2, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(tfPassword2,MAX_SZ, MAX_SZ, MAX_SZ)
                                )
                                .addGroup(
                                        gl.createSequentialGroup()
                                                .addGap(8,8,Integer.MAX_VALUE)
                                                .addComponent(btnReg, MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8)
                                                .addComponent(btnCancel,MIN_SZ, MIN_SZ, MIN_SZ)
                                                .addGap(8,8,Integer.MAX_VALUE)
                                )
                        )
                        .addGap(8,8, Integer.MAX_VALUE)
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGap(8,8,Integer.MAX_VALUE)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblPhone,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(tfPhone, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblName,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(tfName, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblPassword,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(tfPassword, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblPassword2,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(tfPassword2, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnReg,MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addComponent(btnCancel, MIN_SZ, MIN_SZ, MIN_SZ)
                        )
                        .addGap(8,8,Integer.MAX_VALUE)
        );
        gl.linkSize(0, lblPhone, lblName, lblPassword, lblPassword2);
        gl.linkSize(0,btnReg,btnCancel);
    }
}