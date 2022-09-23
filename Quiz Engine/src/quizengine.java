import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

class quizengine
{
    Frame mainf;
    JLabel namelm;
    Panel mainp;
    JButton admin, student;
    Font ft;
    
    //----------------------------------- IMPORTANT VARIABLES -----------------------------------------------------
    
    static int quizlen = 5  ,  warnings = 5  ,  time_limit = 1 ;    //time is in minutes
    
    //-------------------------------------------------------------------------------------------------------------    
    //----------------------------------- FOR CONNECTION TO MYSQL -------------------------------------------------
    
    String admin_password = "admin" ;
    static String connector = "jdbc:mysql://localhost/quizengine?user=root&password=password";
    
    //-------------------------------------------------------------------------------------------------------------  
    
    quizengine()
    {
        mainf = new Frame("Quiz Engine");
        namelm = new JLabel("Quiz Engine");
        mainp = new Panel();
        admin = new JButton("Admin");
        student = new JButton("Student");
        
        
        try
        {
            ft = Font.createFont(Font.TRUETYPE_FONT, new File("RufingPersonalUse.otf"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(mainf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        admin.addActionListener((e)->
        {
        	
            try
            {
                String p = JOptionPane.showInputDialog(mainf, "Enter password:");
                if(p.equals(admin_password))
                {
                	admin a = new admin(mainf);
                    mainf.dispose();
                }
                else
                    JOptionPane.showMessageDialog(mainf, "Incorrect Password");
            }
            catch(Exception ea)
            {
                JOptionPane.showMessageDialog(mainf, ea.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        student.addActionListener((e)->
        {
            mainf.dispose();
            student s = new student(mainf);
        });


        namelm.setBounds(250, 80, 250, 80);
        namelm.setFont(ft.deriveFont(48f));
        admin.setBounds(175, 300, 100, 40);
        admin.setFont(ft.deriveFont(18f));
        student.setBounds(470, 300, 100, 40);
        student.setFont(ft.deriveFont(18f));
        mainp.setLayout(null);
        mainp.setBackground(Color.YELLOW);
        mainp.add(namelm);
        mainp.add(admin);
        mainp.add(student);
        mainf.add(mainp);
        mainf.setSize(750,600);
        mainf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        mainf.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        quizengine qe = new quizengine();
    }
    
}
