import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.util.*;
import javax.swing.*;

class student implements ActionListener
{
	Frame studentf;
    JLabel namels;
    MyLabel quess, quesno;
    Label timer, quespalet;
    Panel studentp, ques_paletp;
    JButton back_ends, saves, clears, starts, previous;
    Button[] b;
    Font ft;
    JRadioButton cb1, cb2, cb3, cb4, cb5;
    ButtonGroup bg;
    Thread time;
    int nextv=0, nexta=0, k=0, focint=0;
    ArrayList<Integer> arrlist_quesid, arrlist_random;
    ArrayList<String> arrlist_ques;
    ScrollPane scp;
    String[] answer_stud, answer_quiz;
    int quizlen = quizengine.quizlen  ,  warnings = quizengine.warnings ;
    boolean flag=false, time_stop=true;
    String connector = quizengine.connector;
    int min = quizengine.time_limit;
    
    
    student(Frame f)
    {
    	studentf = new Frame("Student");
        namels = new JLabel("Quiz Engine");
        timer = new Label("Remaining Time: ");
        quespalet = new Label("Question Palette");
        quesno = new MyLabel("");
        quess = new MyLabel("");
        studentp = new Panel();
        ques_paletp = new Panel();
        back_ends = new JButton("Back");
        saves = new JButton("Save & Next");
        clears = new JButton("Clear");
        starts = new JButton("Start");
        previous = new JButton("Previous");
        bg = new ButtonGroup();
        cb1 = new JRadioButton("", false);
        cb2 = new JRadioButton("", false);
        cb3 = new JRadioButton("", false);
        cb4 = new JRadioButton("", false);
        cb5 = new JRadioButton("", false);
        answer_stud = new String[quizlen];
        answer_quiz = new String[quizlen];        
        arrlist_quesid = new ArrayList<Integer>();
        arrlist_random = new ArrayList<Integer>();
        arrlist_ques = new ArrayList<String>();
        scp = new ScrollPane();
        b = new Button[quizlen];
        
        for(int i=0;i<quizlen;i++)
        {
        	b[i] = new Button(i+1+"");
        	b[i].setBackground(Color.WHITE);
        	b[i].addActionListener(this);
        	ques_paletp.add(b[i]);
        }
        
        try
        {
            ft = Font.createFont(Font.TRUETYPE_FONT, new File("RufingPersonalUse.otf"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(studentf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        starts.addActionListener((e)->
        {
            starts.setVisible(false);
            clears.setBounds(50, 490, 120, 40);
            previous.setBounds(200, 490, 120, 40);
            saves.setBounds(350, 490, 120, 40);
            back_ends.setText("End Quiz");
            back_ends.setBounds(550, 490, 170, 40);
            scp.setVisible(true);
            quespalet.setBounds(50,110,110,20);
            values();
            displayques(nextv);
            cb1.setBounds(50, 250, 150, 40);
            cb2.setBounds(50, 300, 150, 40);
            cb3.setBounds(50, 350, 150, 40);
            cb4.setBounds(50, 400, 150, 40);
            timer.setBounds(550, 100, 200, 20);
            time.start();
            flag = true;
        });
        

        clears.addActionListener((e)->
        {
            if(cb1.isSelected())
                cb5.setSelected(true);
            else if(cb2.isSelected())
                cb5.setSelected(true);
            else if(cb3.isSelected())
                cb5.setSelected(true);
            else if(cb4.isSelected())
                cb5.setSelected(true);
        });
        

        time = new Thread(()->
        {
            while(min>0)
            {
            	if(!time_stop)
            		break;
                try
                {
                    timer.setText("Remaning Time: "+min+":00");
                    Thread.sleep(1000);
                    min--;
                    for(int sec = 59;sec>0;sec--)
                    {
                        if(sec>9)
                            timer.setText("Remaning Time: "+min+":"+sec);
                        else
                            timer.setText("Remaning Time: "+min+":0"+sec);
                        Thread.sleep(1000);
                    }
                }
                catch(Exception et)
                {
                	JOptionPane.showMessageDialog(studentf, et.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(time_stop)
            {
                System.out.println("0");
                check(f);
            }
            
        });

        back_ends.addActionListener((e)->
        {
            if(back_ends.getText()=="Back")
            {
                
                studentf.dispose();
                f.setVisible(true);
            }
            else
                check(f);     
        });        
        

        saves.addActionListener((e)->
        {
            if(cb1.isSelected())
                answer_stud[nexta] = cb1.getText();
            else if(cb2.isSelected())
                answer_stud[nexta] = cb2.getText();
            else if(cb3.isSelected())
                answer_stud[nexta] = cb3.getText();
            else if(cb4.isSelected())
                answer_stud[nexta] = cb4.getText();
            else
            	answer_stud[nexta] = "";
            
            colorchange(nextv);

            if(nexta==quizlen-1)
                nexta=0;
            else
                nexta++;
            
            if(nextv == quizlen-1)
                nextv = 0;
            else
                nextv++;

            
            displayques(nextv);
            selector();
            
        });
        
        
        previous.addActionListener((e)->
        {
            if(nexta==0)
                nexta=quizlen-1;
            else
                nexta--;

            if(nextv == 0)
                nextv = quizlen-1;
            else
                nextv--;

            displayques(nextv);
            selector();
        });
        
        
        namels.setBounds(250, 20, 250, 80);
        namels.setFont(ft.deriveFont(48f));
        timer.setFont(new Font("Arial",1,14));
        back_ends.setBounds(175, 490, 100, 40);
        starts.setBounds(470, 490, 100, 40);
        quesno.setBounds(20, 190, 20, 40);
        quess.setBounds(50, 190, 550, 40);
        cb1.setFont(new Font("Arial",0,14));
        cb2.setFont(new Font("Arial",0,14));
        cb3.setFont(new Font("Arial",0,14));
        cb4.setFont(new Font("Arial",0,14));
        quespalet.setFont(new Font("Arial",1,14));
        ques_paletp.setLayout(new GridLayout());
        scp.setBounds(50,130,650,50);
        scp.setVisible(false);
        scp.add(ques_paletp);
        studentp.setLayout(null);
        studentp.setBackground(Color.YELLOW);
        studentp.add(timer);
        studentp.add(quespalet);
        studentp.add(quesno);
        studentp.add(quess);
        bg.add(cb1);
        bg.add(cb2);
        bg.add(cb3);
        bg.add(cb4);
        bg.add(cb5);
        studentp.add(cb1);
        studentp.add(cb2);
        studentp.add(cb3);
        studentp.add(cb4);
        studentp.add(namels);
        studentp.add(starts);
        studentp.add(back_ends);
        studentp.add(saves);
        studentp.add(previous);
        studentp.add(clears);
        studentp.add(scp);
        studentf.add(studentp);
        studentf.setVisible(true);
        studentf.setSize(750,600);
        studentf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                flag = false;
                System.exit(0);
            }
            public void windowDeactivated(WindowEvent e)
            {
                if(flag==true)
                {
                	if(warnings==0)
                		check(f);
                	else
                	{
                		JOptionPane.showMessageDialog(null,"Please do not leave the screen.");
                		warnings--;
                	}
                    
                }
            }
        });

    }

    public void actionPerformed(ActionEvent e)
    {
    	Button b = (Button) e.getSource();
    	nexta = Integer.parseInt(b.getLabel())-1;
    	nextv = nexta;    	
    	displayques(nextv);
    	selector();
	}
    
    void selector()
    {
    	if(cb1.getText().equals(answer_stud[nexta]))
            cb1.setSelected(true);
        else if(cb2.getText().equals(answer_stud[nexta]))
            cb2.setSelected(true);
        else if(cb3.getText().equals(answer_stud[nexta]))
            cb3.setSelected(true);
        else if(cb4.getText().equals(answer_stud[nexta]))
            cb4.setSelected(true);
    }
    
    void colorchange(int n)
    {
    	if(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())
    		b[n].setBackground(Color.GREEN);
    	else
    		b[n].setBackground(Color.WHITE);
    }    

    void values()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(connector);
            String valueq = "select * from quiz";
            String countq = "select count(*) from quiz";
            String getquesq = "select * from quiz where qid=?";
            PreparedStatement st = cn.prepareStatement(valueq);
            PreparedStatement pst = cn.prepareStatement(countq);
            PreparedStatement gqst = cn.prepareStatement(getquesq);
            
            ResultSet rse = pst.executeQuery();
            rse.next();
            int count = rse.getInt(1);
            rse = st.executeQuery();
            int j=0;
            while(rse.next())
            {
                arrlist_quesid.add(j,Integer.parseInt(rse.getString(1)));
                j++;
            }
            Random r = new Random();
            while(k<quizlen)
            {
                boolean b = true;
                int n = r.nextInt(count);
                int i=0;
                while(i<k)
                {
                    if(arrlist_random.get(i)==n)
                    {
                        b=false;
                        break;
                    }
                    i++;
                }
                if(b)
                {
                    arrlist_random.add(k, n);
                    k++;
                }
            }
            
            for(int i=0;i<quizlen;i++)
            {
            	gqst.setInt(1, arrlist_quesid.get(arrlist_random.get(i)));
                rse = gqst.executeQuery();
                rse.next();
                arrlist_ques.add(i,rse.getString(2)+"@@"+rse.getString(4)+"@@"+rse.getString(5)+"@@"+rse.getString(6)+"@@"+rse.getString(7).stripTrailing());
                
                answer_quiz[i]= rse.getString(3);
            }
            
            
        }
        catch(Exception ev)
        {
            JOptionPane.showMessageDialog(studentf, ev.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void displayques(int ne)
    {
        int no = ne+1;
        quesno.setText(""+no+".");
        cb5.setSelected(true);
        
        String str = arrlist_ques.get(ne);
        
        String[] splt = str.split("@@");
        quess.setText(splt[0]);
        cb1.setText(splt[1]);
        cb2.setText(splt[2]);
        cb3.setText(splt[3]);
        cb4.setText(splt[4]);
       
    }

    void check(Frame f)
    {
    	flag = false;
    	time_stop=false;
    	anscheck anc = new anscheck(f,answer_stud,answer_quiz,arrlist_ques);
    	studentf.dispose();
     }

}
