package empsyatem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;


public class View extends JFrame implements ActionListener {
    
    JTable table;
    JScrollPane jsp;
    ResultSet rs;
    JLabel search;
    Choice empid;
    
    JButton Search, print, update,back;
    
    View()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        search=new JLabel("Search by Id  :");
        search.setBounds(20,20,150,30);
        search.setFont(new Font("serif",Font.BOLD,22));
        add(search);
        
        empid=new Choice();
        empid.setBounds(180,25,200,200);
        add(empid);
        
        //choice in side data 
        try{
            conn c=new conn();
                 rs=c.s.executeQuery("select * from addemp");
            while(rs.next())
            {
                 
                 empid.add(rs.getString("EmployeeId"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        table=new JTable();
        try{
            conn c=new conn();
            rs=c.s.executeQuery("select * from addemp");
            table.setModel(DbUtils.resultSetToTableModel(rs));  
            
            jsp= new JScrollPane(table);
            jsp.setBounds(5,150,1400,400);
            table.setFont(new Font("serif",Font.PLAIN,15));
            add(jsp); 
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        //search button
        Search=new JButton ("Search");
        Search.setBounds(20,80,140,40);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        Search.setFont(new Font("serif",Font.BOLD,23));
        Search.addActionListener(this);
        add(Search);
        
        //print button
//        print=new JButton ("Print");
//        print.setBounds(180,80,140,40);
//        print.setBackground(Color.BLACK);
//        print.setForeground(Color.WHITE);
//        print.setFont(new Font("serif",Font.BOLD,23));
//        print.addActionListener(this);
//        add(print);
        
        //update button
        update=new JButton ("Update");
        update.setBounds(250,80,140,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("serif",Font.BOLD,23));
        update.addActionListener(this);
        add(update);
        
        
        //bak buttton
        back=new JButton ("Back");
        back.setBounds(500,80,140,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,23));
        back.addActionListener(this);
        add(back);
        
        
        
        
        
        setSize(1400,1000);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search)
        {
            String query="select * from addemp where EmployeeId='"+empid.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new Updateemp(empid.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new home();
        }
    }
    
    public static void main(String args[])
    {
        new View();
    }
    
}
