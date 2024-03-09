package empsyatem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame implements ActionListener{
    
    
    JButton add,view,remove,update;
    
  home(){
             
    setLayout(null);    
    
    // home image
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/h1.jpg"));
    Image i2=i1.getImage().getScaledInstance(1450, 830, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel imge=new JLabel(i3);
    imge.setBounds(1,0,1350,850);
    add(imge);
    
     //heading
    JLabel hading= new JLabel("Emplyoee Management System");
    hading.setBounds(700,15,650,100);
    hading.setForeground(Color.white);
    hading.setFont(new Font("Raleway",Font.BOLD,40));
    imge.add(hading);
    
    //add employee button
    add= new JButton("Add Employee");
    add.setBounds(780,110,170,50);
    add.setFont(new Font("Raleway",Font.BOLD,17));
    add.addActionListener(this);
    imge.add(add);
    
        //view Employee button
    view= new JButton("View Employee");
    view.setBounds(1100,110,170,50);
    view.setFont(new Font("Raleway",Font.BOLD,17));
    view.addActionListener(this);
    imge.add(view);
    
    //update employee button
//    update= new JButton("Update Employee");
//    update.setBounds(780,210,170,50);
//    update.setFont(new Font("Raleway",Font.BOLD,15));
//    update.addActionListener(this);
//    imge.add(update);
    
    //remove employee button
    remove= new JButton("Remove Employee");
    remove.setBounds(950,210,170,50);
    remove.setFont(new Font("Raleway",Font.BOLD,15));
    remove.addActionListener(this);
    imge.add(remove);
    
    setSize(1370,850);
    setLocation(200,50);
    setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            new addemp();
            setVisible(false);
        }else if(ae.getSource()==view){
            new View();
            setVisible(false);
            
        }else if(ae.getSource()==remove){
            setVisible(false);
            new RemoveEmp();
            
        }
//else if(ae.getSource()==update){
//            setVisible(false);
//            new Updateemp();
//            
//           }
     }
  
    public static void main(String args[])
    {
        new home();
    }
    
}
