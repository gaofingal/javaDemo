package simpleFrame;

import javax.swing.*;
import java.awt.*;

public class NoteHelloWorld
{
    public static void main(String[] agrs)
    {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {

                JFrame frame = new NotHelloWordFrame();
                frame.setTitle("NotHelloWord");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * A frame that contains a message panel
 */
class NotHelloWordFrame extends JFrame
{
    public NotHelloWordFrame()
    {
        add(new NoteHelloWordComponent());
        pack();
    }
}

/**
 * A component that display a message
 */
class NoteHelloWordComponent extends JComponent
{
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

     private static final int DEFAULT_WIDTH = 300;
     private static final int DEFAULT_HEIGHT = 200;

     public void paintComponent(Graphics g)
     {
        g.drawString("Not a Hello Word program", MESSAGE_X, MESSAGE_Y);
     }

     public Dimension getPreferredSize()
     {
         return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
     }
}