package simpleFrame;

import java.awt.*;
import javax.swing.*;

public class simpleFrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                simpleFrame frame = new simpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class simpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public simpleFrame()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}
