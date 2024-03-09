package empsyatem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class addemp extends JFrame implements ActionListener{
    Random ran= new Random();
    int number=ran.nextInt(99999);
    JTextField txtnm,txtfname,txtdes,txteml,txtadr,txtbd,txtslry,txtph,txtadhar,txtsurnm;
    JButton add,back;
    JComboBox acdm;
    JLabel Id;
    
     addemp()
    {
       
        
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Add  Emplyoee  Details");
        heading.setBounds(320,30,500,60);
        heading.setFont(new Font("serif",Font.BOLD,45));
        add(heading);
        //Name
        JLabel name=new JLabel("Name");
        name.setBounds(95,155,120,40);
        name.setFont(new Font("serif",Font.PLAIN,26));
        add(name); 
        txtnm=new JTextField();
        txtnm.setBounds(270, 160,200,37);
        add(txtnm);
        
        //father name
        JLabel fnm=new JLabel("Father name");
        fnm.setBounds(95,235,150,40);
        fnm.setFont(new Font("serif",Font.PLAIN,26));
        add(fnm); 
        txtfname=new JTextField();
        txtfname.setBounds(270, 235,200,37);
        add(txtfname);
        
        //surname
        JLabel surn=new JLabel("Surname");
        surn.setBounds(95,300,120,40);
        surn.setFont(new Font("serif",Font.PLAIN,26));
        add(surn); 
        txtsurnm=new JTextField();
        txtsurnm.setBounds(270, 305,200,37);
        add(txtsurnm);
        
        //email
        JLabel email=new JLabel("Email Id");
        email.setBounds(95,371,120,40);
        email.setFont(new Font("serif",Font.PLAIN,26));
        add(email); 
        txteml=new JTextField();
        txteml.setBounds(270,371,200,37);
        add(txteml);
        
        
        //Designation
        JLabel dsigntion=new JLabel("Designation");
        dsigntion.setBounds(95,435,120,40);
        dsigntion.setFont(new Font("serif",Font.PLAIN,24));
        add(dsigntion); 
        txtdes=new JTextField();
        txtdes.setBounds(270,435,200,37);
        add(txtdes);
        
        //Emplyoee Id
        JLabel id=new JLabel("Employee Id");
        id.setBounds(95,500,150,60);
        id.setFont(new Font("serif",Font.PLAIN,24));
        add(id);
        Id=new JLabel(""+number);
        Id.setBounds(270,515,200,37);
        Id.setFont(new Font("serif",Font.PLAIN,24));
        add(Id);
        
        //birthday
        JLabel bd=new JLabel("Birth date");
        bd.setBounds(650,152,140,60);
        bd.setFont(new Font("serif",Font.PLAIN,26));
        add(bd); 
        txtbd=new JTextField();
        txtbd.setBounds(870,160,200,37);
        add(txtbd);
        
        //salary
        JLabel salary=new JLabel("Salary");
        salary.setBounds(650,220,140,60);
        salary.setFont(new Font("serif",Font.PLAIN,26));
        add(salary); 
        txtslry=new JTextField();
        txtslry.setBounds(870,228,200,37);
        add(txtslry);
        
        
        //phone
        JLabel phone=new JLabel("Phone");
        phone.setBounds(650,290,120,50);
        phone.setFont(new Font("serif",Font.PLAIN,25));
        add(phone); 
        txtph=new JTextField();
        txtph.setBounds(870,299,200,37);
        add(txtph);
        
         //Higest Education
        JLabel edu=new JLabel("Highest Education");
        edu.setBounds(650,340,200,95);
        edu.setFont(new Font("serif",Font.PLAIN,25));
        add(edu); 
        String course[]={"BBA","BCA","BA","B.COM","BTech","MBA","MA","MCA","MTech","LLB","M.COM","MSC","BSC",};
        acdm= new JComboBox(course);
        acdm.setBounds(870,368,200,37);
        acdm.setBackground(Color.WHITE);
        add(acdm);
        
        //Adhar no
        JLabel adhar=new JLabel("Aadhar no");
        adhar.setBounds(650,420,140,60);
        adhar.setFont(new Font("serif",Font.PLAIN,26));
        add(adhar); 
        txtadhar=new JTextField();
        txtadhar.setBounds(870,435,200,37);
        add(txtadhar);
        
        //Address
        JLabel adr=new JLabel("Address");
        adr.setBounds(650,490,140,60);
        adr.setFont(new Font("serif",Font.PLAIN,26));
        add(adr); 
        txtadr=new JTextField();
        txtadr.setBounds(870,500,200,37);
        add(txtadr);
        
        //add button
        add=new JButton ("Add Details");
        add.setBounds(270,650,190,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("serif",Font.BOLD,23));
        add.addActionListener(this);
        add(add);

        
        //back button
        back=new JButton ("Back");
        back.setBounds(670,650,190,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,23));
        back.addActionListener(this);
        add(back);      
        
        setLayout(null);
        setSize(1200,900);
        setLocation(300,50);
        setVisible(true);
           
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
           String uname=txtnm.getText();
           String father=txtfname.getText();
           String surname=txtsurnm.getText();
           String Emailid=txteml.getText();
           String Designationemp=txtdes.getText();
           String Empid=Id.getText();
           String dob=txtbd.getText();
           String slry=txtslry.getText();
           String Phoneno=txtph.getText();
           String Edu=(String)acdm.getSelectedItem();
           String Adharcard=txtadhar.getText();
           String empaddress=txtadr.getText();
           
           try{
              conn c= new conn();
              String query="insert into addemp values('"+uname+"','"+father+"','"+surname+"','"+Emailid+"','"+Designationemp+"','"+Empid+"','"+dob+"','"+slry+"','"+Phoneno+"','"+Edu+"','"+Adharcard+"','"+empaddress+"')";
              
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Employee add successfully ....!!!");
              setVisible(false);
                new home();
              
           }catch(Exception e){
               e.printStackTrace();
           }
        }
           if(ae.getSource()==back){
               setVisible(false);
               new home();
        
    }
        }     
    
    public static void main(String args[])
    {
        new addemp();
        
    }
    
}

