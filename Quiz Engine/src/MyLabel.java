import java.awt.Font;
import java.awt.Label;

class MyLabel extends Label
{
    MyLabel(String s)
    {
        setText(s);
        setFont(new Font("Arial",1,18));
    }
}
