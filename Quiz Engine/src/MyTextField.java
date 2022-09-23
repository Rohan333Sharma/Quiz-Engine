import java.awt.Font;
import java.awt.TextField;

public class MyTextField extends TextField
{
    MyTextField()
    {
        setFont(new Font("Arial",1,18));
    }
    MyTextField(String s)
    {
        setFont(new Font("Arial",1,18));
        setText(s);
    }
}
