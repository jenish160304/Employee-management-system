package empsyatem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Updateemp extends JFrame implements ActionListener{
   
    JTextField txtnm,txtfname,txtdes,txteml,txtadr,txtbd,txtslry,txtph,txtadhar,txtsurnm;
    JButton add,back;
    JComboBox acdm;
    JLabel Id;
    String Empid;
    
     Updateemp(String EMPID)
    {
       this.Empid=EMPID;
        
        getContentPane().setBackground(Color.pink);
        
        JLabel heading=new JLabel("Update Emplyoee Details");
        heading.setBounds(320,30,500,60);
        heading.setFont(new Font("serif",Font.BOLD,45));
        add(heading);
        //Name
        JLabel name=new JLabel("Name");
        name.setBounds(95,155,120,40);
        name.setFont(new Font("serif",Font.PLAIN,26));
        add(name); 
        JLabel lblname=new JLabel();
        lblname.setBounds(270, 160,200,37);
        add(lblname);
        
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
        JLabel lblemail=new JLabel();
        lblemail.setBounds(270,371,200,37);
        add(lblemail);
        
        
        //Designation
        JLabel dsigntion=new JLabel("Designation");
        dsigntion.setBounds(95,435,120,40);
        dsigntion.setFont(new Font("serif",Font.PLAIN,24));
        add(dsigntion); 
        txtdes=new JTextField();
        txtdes.setBounds(270,435,200,37);
        add(txtdes);
        
        //Emplyoee Id
        JLabel lblid=new JLabel("Employee Id");
        lblid.setBounds(95,500,150,60);
        lblid.setFont(new Font("serif",Font.PLAIN,24));
        add(lblid);
        Id=new JLabel("");
        Id.setBounds(270,515,200,37);
        Id.setFont(new Font("serif",Font.PLAIN,24));
        add(Id);
        
        //birthday
        JLabel bd=new JLabel("Birth date");
        bd.setBounds(650,152,140,60);
        bd.setFont(new Font("serif",Font.PLAIN,26));
        add(bd); 
        JLabel lbldob=new JLabel();
        lbldob.setBounds(870,160,200,37);
        add(lbldob);
        
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
        JLabel lbladhar=new JLabel();
        lbladhar.setBounds(870,435,200,37);
        add(lbladhar);
        
        //Address
        JLabel adr=new JLabel("Address");
        adr.setBounds(650,490,140,60);
        adr.setFont(new Font("serif",Font.PLAIN,26));
        add(adr); 
        txtadr=new JTextField();
        txtadr.setBounds(870,500,200,37);
        add(txtadr);
        
        
        try{
            conn c= new conn();
            String query="select * from addemp where EmployeeId = '"+Empid+"' ";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next())
            {
                lblname.setText(rs.getString("Name"));
                txtfname.setText(rs.getString("Fathername"));
                txtsurnm.setText(rs.getString("Surname"));
                lblemail.setText(rs.getString("Emial"));
                txtdes.setText(rs.getString("Designation"));
                txtslry.setText(rs.getString("Salary"));
                txtph.setText(rs.getString("Phoneno"));
                lbladhar.setText(rs.getString("Adharcaredno"));
                txtadr.setText(rs.getString("Address"));
                
                Id.setText(rs.getString("EmployeeId"));
                lbldob.setText(rs.getString("Birthdate"));
                
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
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

    Updateemp() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
          
           String father=txtfname.getText();
           String surname=txtsurnm.getText();
          
           String Designationemp=txtdes.getText();
           
            String empid=Id.getText();
           String slry=txtslry.getText();
           String Phoneno=txtph.getText();
           String Edu=(String)acdm.getSelectedItem();
           
           String empaddress=txtadr.getText();
           
           try{
              conn c= new conn();
              String query="update addemp set Fathername= '"+father+"',Surname= '"+surname+"',Designation= '"+Designationemp+"',Salary= '"+slry+"',Phoneno= '"+Phoneno+"',Education= '"+Edu+"',Address= '"+empaddress+"' where EmployeeId= '"+empid+"'";
              
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null," DATA UPDATED successfully ....!!!");
              setVisible(false);
                new View();
              
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
        new Updateemp("");
        
    }
    
}

