import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class admin 
{
	Frame adminf;
    JLabel namela;
    MyLabel cl, qidl, quesl, ansl, optionl1, optionl2, optionl3, optionl4;
    Panel adminp;
    JButton backa, savea, cleara, deletea, openbutton;
    MyTextField qid, ques, ans, option1, option2, option3, option4, openfile;
    Choice c;
    Font ft;
    String connector = quizengine.connector;
    JScrollPane sp;
    JTable showques;
    
    admin(Frame f)
    {
        adminf = new Frame("Quiz Engine - Admin");
        namela = new JLabel("Quiz Engine");
        cl = new MyLabel("Select action to be done :");
        qidl = new MyLabel("Question Id :");
        quesl = new MyLabel("Question :");
        ansl = new MyLabel("Answer :");
        optionl1 = new MyLabel("Option 1 :");
        optionl2 = new MyLabel("Option 2 :");
        optionl3 = new MyLabel("Option 3 :");
        optionl4 = new MyLabel("Option 4 :");
        adminp = new Panel();
        backa = new JButton("Back");
        savea = new JButton("Save");
        cleara = new JButton("Clear");
        deletea = new JButton("Delete");
        openbutton = new JButton("Browse");
        qid = new MyTextField();
        ques = new MyTextField();
        ans = new MyTextField();
        openfile = new MyTextField("");
        option1 = new MyTextField();
        option2 = new MyTextField();
        option3 = new MyTextField();
        option4 = new MyTextField();
        c = new Choice();
        showques = new JTable();
        sp = new JScrollPane(showques);
        
        try
        {
            ft = Font.createFont(Font.TRUETYPE_FONT, new File("RufingPersonalUse.otf"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(adminf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

		
		c.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ei)
            {
                if(c.getSelectedItem() == "Add Question")
                {
                    qidl.setVisible(true);
                    quesl.setVisible(true);
                    ansl.setVisible(true);
                    optionl1.setVisible(true);
                    optionl2.setVisible(true);
                    optionl3.setVisible(true);
                    optionl4.setVisible(true);
                    qid.setVisible(true);
                    ques.setVisible(true);
                    ans.setVisible(true);
                    option1.setVisible(true);
                    option2.setVisible(true);
                    option3.setVisible(true);
                    option4.setVisible(true);
                    cleara.setVisible(true);
                    savea.setVisible(true);
                    deletea.setVisible(false);
                    openbutton.setVisible(false);
                    openfile.setVisible(false);
                    sp.setVisible(false);
                }
                if(c.getSelectedItem() == "Delete Question")
                {
                    qidl.setVisible(true);
                    qid.setVisible(true);
                    cleara.setVisible(true);
                    deletea.setVisible(true);
                    deletea.setText("Delete");
                    quesl.setVisible(false);
                    ansl.setVisible(false);
                    optionl1.setVisible(false);
                    optionl2.setVisible(false);
                    optionl3.setVisible(false);
                    optionl4.setVisible(false);
                    ques.setVisible(false);
                    ans.setVisible(false);
                    option1.setVisible(false);
                    option2.setVisible(false);
                    option3.setVisible(false);
                    option4.setVisible(false);
                    savea.setVisible(false);
                    openbutton.setVisible(false);
                    openfile.setVisible(false);                    	
                }
                if(c.getSelectedItem() == "Select File")
                {
                    qidl.setVisible(false);
                    qid.setVisible(false);
                    cleara.setVisible(true);
                    deletea.setVisible(true);
                    deletea.setText("Upload");
                    openbutton.setVisible(true);
                    openfile.setVisible(true);
                    quesl.setVisible(false);
                    ansl.setVisible(false);
                    optionl1.setVisible(false);
                    optionl2.setVisible(false);
                    optionl3.setVisible(false);
                    optionl4.setVisible(false);
                    ques.setVisible(false);
                    ans.setVisible(false);
                    option1.setVisible(false);
                    option2.setVisible(false);
                    option3.setVisible(false);
                    option4.setVisible(false);
                    savea.setVisible(false);
                    sp.setVisible(false);
                }
                if(c.getSelectedItem() == "Delete All Questions")
                {
                    qidl.setVisible(false);
                    qid.setVisible(false);
                    cleara.setVisible(false);
                    deletea.setVisible(false);
                    openbutton.setVisible(false);
                    openfile.setVisible(false);
                    quesl.setVisible(false);
                    ansl.setVisible(false);
                    optionl1.setVisible(false);
                    optionl2.setVisible(false);
                    optionl3.setVisible(false);
                    optionl4.setVisible(false);
                    ques.setVisible(false);
                    ans.setVisible(false);
                    option1.setVisible(false);
                    option2.setVisible(false);
                    option3.setVisible(false);
                    option4.setVisible(false);
                    savea.setVisible(false);
                    sp.setVisible(false);
                    int option = JOptionPane.showConfirmDialog(adminf, "Are You Sure?", "Sure", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option==JOptionPane.YES_OPTION)
                    {
                    	try
                    	{
                    		Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection cn = DriverManager.getConnection(connector);
                            String deleteallq = "delete from quiz";
                            PreparedStatement st = cn.prepareStatement(deleteallq);
                            st.execute();
                            JOptionPane.showMessageDialog(adminf,"Done");
                    	}
                    	catch(Exception e)
                    	{
                            JOptionPane.showMessageDialog(adminf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } 
                if(c.getSelectedItem() == "Show All Questions")
                {
                    qidl.setVisible(false);
                    qid.setVisible(false);
                    cleara.setVisible(false);
                    deletea.setVisible(false);
                    openbutton.setVisible(false);
                    openfile.setVisible(false);
                    quesl.setVisible(false);
                    ansl.setVisible(false);
                    optionl1.setVisible(false);
                    optionl2.setVisible(false);
                    optionl3.setVisible(false);
                    optionl4.setVisible(false);
                    ques.setVisible(false);
                    ans.setVisible(false);
                    option1.setVisible(false);
                    option2.setVisible(false);
                    option3.setVisible(false);
                    option4.setVisible(false);
                    savea.setVisible(false);
                    
                    try
                    {
                    	Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection cn = DriverManager.getConnection(connector);
                        String countq = "select count(*) from quiz";
                        String showq = "select * from quiz";
                        PreparedStatement pst = cn.prepareStatement(countq);
                        ResultSet rs = pst.executeQuery();
                        rs.next();
                        int count = rs.getInt(1);
                        
                        String[][] data = new String[count][7];
                        
                        String[] column ={"Qid", "Question", "Answer", "Option 1", "Option 2", "Option 3", "Option 4"};
                        pst = cn.prepareStatement(showq);                        
                        rs = pst.executeQuery();
                        for(int i=0;i<count;i++)
                        {
                        	rs.next();
                        	for(int j=0;j<7;j++)
                        	{
                        		data[i][j] = rs.getString(j+1);
                        	}
                        }
                        
                        DefaultTableModel model = new DefaultTableModel(data, column);
                        showques.setModel(model);
                        sp.setBounds(50,190,650,250);                        
                        sp.setVisible(true);
                        adminf.validate();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(adminf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
		
		backa.addActionListener((e)->
        {
            adminf.dispose();
            f.setVisible(true);
        });
		
		cleara.addActionListener((e)->
        {
            qid.setText("");
            ques.setText("");
            ans.setText("");
            option1.setText("");
            option2.setText("");
            option3.setText("");
            option4.setText("");
        });

        savea.addActionListener((e)->
        {
            actionadmin("Save");
        });

        deletea.addActionListener((e)->
        {
            if(deletea.getText().equals("Delete"))
                actionadmin("Delete");
            else
            {
                 if(openfile.getText().equals(""))
                     JOptionPane.showMessageDialog(adminf, "Please select a file.", "Error", JOptionPane.ERROR_MESSAGE);
                 else
                	 uploadfile();
            }

        });
        
        openbutton.addActionListener((e)->
        {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("open");
            int i = fc.showOpenDialog(adminf);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File fil = fc.getSelectedFile();
                String fp = fil.getPath();
                openfile.setText(fp);
            }
        });
        
        namela.setBounds(250, 20, 250, 80);
        namela.setFont(ft.deriveFont(48f));
        c.add("-Select-");
        c.add("Add Question");
        c.add("Delete Question");
        c.add("Select File");
        c.add("Show All Questions");
        c.add("Delete All Questions");
        c.setBounds(350, 150, 150, 20);
        cl.setBounds(50, 150, 250, 20);
        openfile.setBounds(50, 230, 450, 30);
        openbutton.setBounds(520, 230, 80, 30);
        qidl.setBounds(50,190,120,30);
        quesl.setBounds(50, 230, 100, 30);
        ansl.setBounds(50, 270, 100, 30);
        optionl1.setBounds(50, 310, 100, 30);
        optionl2.setBounds(50, 350, 100, 30);
        optionl3.setBounds(50, 390, 100, 30);
        optionl4.setBounds(50, 430, 100, 30);
        qid.setBounds(200,190,400,30);
        ques.setBounds(200, 230, 400, 30);
        ans.setBounds(200, 270, 400, 30);
        option1.setBounds(200, 310, 400, 30);
        option2.setBounds(200, 350, 400, 30);
        option3.setBounds(200, 390, 400, 30);
        option4.setBounds(200, 430, 400, 30);
        backa.setBounds(50, 490, 100, 40);
        cleara.setBounds(350, 490, 100, 40);
        savea.setBounds(500, 490, 100, 40);
        deletea.setBounds(500, 490, 100, 40);
        qidl.setVisible(false);
        quesl.setVisible(false);
        ansl.setVisible(false);
        optionl1.setVisible(false);
        optionl2.setVisible(false);
        optionl3.setVisible(false);
        optionl4.setVisible(false);
        qid.setVisible(false);
        ques.setVisible(false);
        ans.setVisible(false);
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
        cleara.setVisible(false);
        savea.setVisible(false);
        deletea.setVisible(false);
        openbutton.setVisible(false);
        openfile.setVisible(false);
        sp.setVisible(false);
        openfile.setEditable(false);
        adminp.setLayout(null);
        adminp.setBackground(Color.YELLOW);
        adminp.add(namela);
        adminp.add(cl);
        adminp.add(c);
        adminp.add(qidl);
        adminp.add(quesl);
        adminp.add(ansl);
        adminp.add(optionl1);
        adminp.add(optionl2);
        adminp.add(optionl3);
        adminp.add(optionl4);
        adminp.add(qid);
        adminp.add(ques);
        adminp.add(ans);
        adminp.add(option1);
        adminp.add(option2);
        adminp.add(option3);
        adminp.add(option4);
        adminp.add(backa);
        adminp.add(savea);
        adminf.add(openbutton);
        adminf.add(openfile);
        adminp.add(cleara);
        adminp.add(deletea);
        adminp.add(sp);
        adminf.add(adminp);
        adminf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        adminf.setVisible(true);
        adminf.setSize(750,600);
	}
    
    void actionadmin(String s)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(connector);
            if(s=="Save")
            {
                String saveq = "insert into quiz values(?,?,?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(saveq);
                st.setInt(1, Integer.parseInt(qid.getText()));
                st.setString(2, ques.getText());
                st.setString(3, ans.getText());
                st.setString(4, option1.getText());
                st.setString(5, option2.getText());
                st.setString(6, option3.getText());
                st.setString(7, option4.getText());
                st.executeUpdate();
                cn.close();
                JOptionPane.showMessageDialog(adminf, "Done");
            }
            if(s=="Delete")
            {
                    String deletq = "delete from quiz where qid=?";
                    PreparedStatement st = cn.prepareStatement(deletq);
                    st.setInt(1, Integer.parseInt(qid.getText()));
                    st.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(adminf, "Done");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(adminf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void uploadfile()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(connector);
            String uq = openfile.getText().replace('\\', '/');
            String uploadq = "load data infile '"+ uq +"' into table quiz fields terminated by ',' enclosed by '\"' lines terminated by '\n' ignore 1 lines";
            PreparedStatement st = cn.prepareStatement(uploadq);
            st.executeUpdate();
            JOptionPane.showMessageDialog(adminf,"Done");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(adminf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
