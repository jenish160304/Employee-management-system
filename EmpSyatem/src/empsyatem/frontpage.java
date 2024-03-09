package empsyatem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class frontpage extends JFrame implements ActionListener
{
     frontpage()
     {
         getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        
        JLabel h1=new JLabel("EMPLOYEE   MANAGEMENT   SYSTEM");
        h1.setBounds(5,10,1500,80);
        h1.setFont(new Font("serif",Font.PLAIN,70));
        h1.setForeground(Color.red);
        add(h1);
        //Image
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("image/front.jpg"));
       Image i2=i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel img=new JLabel(i3);
       img.setBounds(1,75,1350,850);
       add(img);
        
        //Click Button
        JButton click=new JButton ("CLICK HERE TO CONTINUE");
        click.setBounds(500,630,300,70);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        img.add(click);
        
        click.addActionListener(this);
        
        
        setSize(1370,850);
        setLocation(200,50);
        setVisible(true);
        
        while(true)
        {
            h1.setVisible(false);
            
            try
            {
                Thread.sleep(650);
                
            }catch(Exception e)
            {
            }    
            h1.setVisible(true);
            try
            {
                Thread.sleep(650);
                
            }catch(Exception e)
            {            
            }
            
            
        
        }
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(true);
        new login();
    }
    
    public static void main(String[] args)
    {
        new frontpage();
    }
    
}
    

