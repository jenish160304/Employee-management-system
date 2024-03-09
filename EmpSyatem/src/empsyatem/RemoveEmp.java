package empsyatem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveEmp extends JFrame implements ActionListener
{
    Choice empID;
    JButton delete,back;

    RemoveEmp() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblId= new JLabel("Employeee Id");
        lblId.setFont(new Font("serif",Font.BOLD,25));
        lblId.setBounds(50,50,150,60);
        add(lblId);

        empID=new Choice();
        empID.setBounds(220,60,200,70);
        empID.setFont(new Font("serif",Font.PLAIN,25));
        add(empID);
        
        try{
            
             conn c= new conn();
            String query="select * from addemp";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next())
            {
                empID.add(rs.getString("EmployeeId"));
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        //name
        JLabel lblname= new JLabel("Name :");
        lblname.setFont(new Font("serif",Font.BOLD,25));
        lblname.setBounds(50,100,150,60);
        add(lblname);
        JLabel lblnm= new JLabel();
        lblnm.setFont(new Font("serif",Font.BOLD,25));
        lblnm.setBounds(200,100,150,60);
        add(lblnm);
        
        
         //phone
        JLabel lblph= new JLabel("Phone :");
        lblph.setFont(new Font("serif",Font.BOLD,25));
        lblph.setBounds(50,150,150,60);
        add(lblph);
        JLabel lblphone= new JLabel();
        lblphone.setFont(new Font("serif",Font.BOLD,25));
        lblphone.setBounds(200,150,150,60);
        add(lblphone);
        
        //email
        JLabel lblem= new JLabel("Email :");
        lblem.setFont(new Font("serif",Font.BOLD,25));
        lblem.setBounds(50,200,150,60);
        add(lblem);
        JLabel lblemail= new JLabel();
        lblemail.setFont(new Font("serif",Font.BOLD,25));
        lblemail.setBounds(200,200,300,60);
        add(lblemail);
        
         try{
            
             conn c= new conn();
            String query="select * from addemp where EmployeeId='"+empID.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next())
            {
               lblnm.setText(rs.getString("Name"));
               lblphone.setText(rs.getString("Phoneno"));
               lblemail.setText(rs.getString("Emial"));
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        empID.addItemListener(new ItemListener(){
           
            public void itemStateChanged(ItemEvent e) {  
                
                
            try{
            
                     conn c= new conn();
                    String query="select * from addemp where EmployeeId='"+empID.getSelectedItem()+"'";
                     ResultSet rs=c.s.executeQuery(query);
            
                     while(rs.next())
                      {
                              lblnm.setText(rs.getString("Name"));
                              lblphone.setText(rs.getString("Phoneno"));
                              lblemail.setText(rs.getString("Emial"));
                
                       }
            
                } catch (SQLException ex) {
                    Logger.getLogger(RemoveEmp.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        });
        
        
        //delete
        delete=new JButton("Delete");
        delete.setBounds(100,300,150,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("serif",Font.BOLD,23));
//        delete.addActionPerformed1(this);
        delete.addActionListener(this);
        add(delete);
        
        
        //back
        back=new JButton("Back");
        back.setBounds(330,300,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("serif",Font.BOLD,23));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/delete.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel imge=new JLabel(i3);
        imge.setBounds(600,0,600,450);
        add(imge);
        
        
        setSize(1250, 500);
        setLocation(340, 150);
        setVisible(true);


    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
            if(ae.getSource()==delete)
            {
                try{
                    conn c= new conn();
                    String selectedEmpID = empID.getSelectedItem();
                    String query="delete from addemp where EmployeeId='"+selectedEmpID+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee deleted Successfully");
                    setVisible(false);
                    
                    new View();
                    setVisible(false);
                    
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                 
            }
            else
            {
                setVisible(false);
                new home().setVisible(true);
            }
            
    }

    public static void main(String args[]) {
        new RemoveEmp();
    }

   

   
}
