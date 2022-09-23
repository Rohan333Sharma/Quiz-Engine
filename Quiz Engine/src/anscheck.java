import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

public class anscheck 
{
	Frame anscheckf;
    JLabel namelans;
    MyLabel donemess;
    Label marks;
    Panel anscheckp;
    Font ft;
    JTextArea ta;
    JScrollPane sp;
    int quizlen = quizengine.quizlen;
    
    anscheck(Frame f, String[] answer_stud, String[] answer_quiz, ArrayList<String> arrlist_ques)
    {
    	anscheckf = new Frame("Quiz Engine - Quiz Submitted");
        namelans = new JLabel("Quiz Engine");
        marks = new Label();
        donemess = new MyLabel("Your quiz is submitted successfuly...");
        anscheckp = new Panel();
        ta = new JTextArea("");
        sp = new JScrollPane(ta);
        int score = 0, una = 0, inc = 0,iter=0;

        try
        {
            ft = Font.createFont(Font.TRUETYPE_FONT, new File("RufingPersonalUse.otf"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(anscheckf, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        for(int i=0;i<quizlen;i++)
        {
       	 if(answer_stud[i]==null)
                una++;
       	 else if(answer_stud[i].equals(answer_quiz[i]))
       		 score = score+4;
            else if(!(answer_stud[i].equals(answer_quiz[i])))
                inc++;
        }
        marks.setText("Marks: " + score + "/" + (quizlen*4));
        
        for(String str:arrlist_ques)
        {
        	String[] str2 = str.split("@@");
        	ta.setText(ta.getText() + "\n" + (iter+1) + ". " + str2[0]);
        	ta.setText(ta.getText() + "\n" + "   Correct Answer: " + answer_quiz[iter]);
        	ta.setText(ta.getText() + "\n" + "   Your Answer: " + answer_stud[iter] + "\n");
        	iter++;
        }
        
        
        namelans.setBounds(250, 20, 250, 80);
        namelans.setFont(ft.deriveFont(48f));
        donemess.setBounds(210, 110, 350, 50);
        marks.setBounds(500, 160, 230, 50);
        marks.setFont(new Font("Arial",1,30));
        ta.setEditable(false);
        ta.setCaretPosition(0);
        ta.getCaret().setSelectionVisible(false);
        ta.setFont(new Font("Arial",1,15));
        ta.setBackground(Color.YELLOW);
        sp.setBackground(Color.YELLOW);
        sp.setBounds(50,220,650,300);
        anscheckp.setLayout(null);
        anscheckp.setBackground(Color.YELLOW);
        anscheckp.add(namelans);
        anscheckp.add(marks);
        anscheckp.add(donemess);
        anscheckp.add(sp);
        anscheckf.add(anscheckp);
        anscheckf.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }            
        });
        anscheckf.setVisible(true);
        anscheckf.setSize(750,600);
    
    }        
    
}
