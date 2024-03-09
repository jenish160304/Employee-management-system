package empsyatem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{
    
    
    JButton login,signin,cancel;
    JTextField username,password;

    login()
    {
        getContentPane().setBackground(Color.PINK);
        setLayout(null);
        
        //usernmae
        JLabel txt1=new JLabel("User Name");
        txt1.setBounds(60,50,120,60);
        txt1.setFont(new Font("serif",Font.BOLD,25));
        add(txt1);
        
        username=new JTextField();
        username.setBounds(270, 70,200, 37);
        add(username);
        
        //password
        JLabel txt2=new JLabel("Password");
        txt2.setBounds(60,155,120,40);
        txt2.setFont(new Font("serif",Font.BOLD,25));
        add(txt2);
        password=new JTextField();
        password.setBounds(270, 160,200,37);
        add(password);
        
        
        //login button
        login=new JButton ("LOGIN");
        login.setBounds(60,290,160,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif",Font.BOLD,20));
        login.addActionListener(this);
        add(login);
       
        
        //signup button
        signin=new JButton ("SignUp");
        signin.setBounds(270,290,160,40);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("serif",Font.BOLD,23));
        signin.addActionListener(this);
        add(signin);
        
        //cancle Button
        cancel=new JButton ("Cancel");
        cancel.setBounds(150,375,160,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,23));
        cancel.addActionListener(this);
        add(cancel);
        
        //Logain image
        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("image/second.png"));
        Image img2=img1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        JLabel limg=new JLabel(img3);
        limg.setBounds(180,8,1100,500);
        add(limg);
        
        setSize(1000,550);
        setLocation(450,200);
        setVisible(true);
    
    }
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String luser=username.getText();
                String upassword=password.getText();
            try{               
                
                conn c= new conn();
                String query="select * from sign where username ='"+luser+"' and password ='"+upassword+"'";
                ResultSet rs=c.s.executeQuery(query);       
            
            
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "login success....");
                    setVisible(false);
                    new home();                
                }
                else{
                   JOptionPane.showMessageDialog(null, "invalid user name password");
                   setVisible(true);
                   username.setText("");
                   password.setText("");
               
                }     
            } 
            catch(Exception e){
                e.printStackTrace();
            }
        
        
        }else if(ae.getSource()==signin){
       
           try {
         
                new Sine();
        
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==cancel){
            System.exit(0);
            
        }
    }      
    
    public static void main(String args[])
    {
        new login();
        
    }
}
