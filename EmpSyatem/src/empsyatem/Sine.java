package empsyatem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Sine extends JFrame implements ActionListener{
    
    JTextField username,password,email;
    JButton create,back;
    Sine()
    {
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        //user name 
        JLabel stxt1=new JLabel("User Name");
        stxt1.setBounds(60,50,120,60);
        stxt1.setFont(new Font("serif",Font.BOLD,25));
        add(stxt1);
        username=new JTextField();
        username.setBounds(270, 65,200, 37);
        add(username);
        
       // password
        JLabel stxt2=new JLabel("Password");
        stxt2.setBounds(60,140,120,60);
        stxt2.setFont(new Font("serif",Font.BOLD,25));
        add(stxt2);
        password=new JTextField();
        password.setBounds(270, 145,200, 37);
        add(password);
        
        //email
        JLabel stxt3=new JLabel("Email");
        stxt3.setBounds(60,230,120,60);
        stxt3.setFont(new Font("serif",Font.BOLD,25));
        add(stxt3);
        email=new JTextField();
        email.setBounds(270, 233,200, 37);
        add(email);
        
        //create button
        create=new JButton ("Create");
        create.setBounds(85,370,160,50);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("serif",Font.BOLD,24));
        create.addActionListener(this);
        add(create);
        
        //back button
        back=new JButton ("Back");
        back.setBounds(300,370,160,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,23));
        back.addActionListener(this);
        add(back);
        
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/signin.png"));
        Image img2=img1.getImage().getScaledInstance(470,470, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel limg=new JLabel(img3);
        limg.setBounds(270,0,1100,500);
        add(limg);
        
        
        setSize(1100,570);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String user=username.getText();
            String pass=password.getText();
            String eml=email.getText();
            
            try{
                conn c= new conn();
                String query="insert into sign values('"+user+"','"+pass+"','"+eml+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account create successfull");
                
                setVisible(false);
                new login();
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
        }
        else
        {
            setVisible(false);
            new login();
        }
    }
    
    public static void main(String args[])
    {
        new Sine();
    }
}
