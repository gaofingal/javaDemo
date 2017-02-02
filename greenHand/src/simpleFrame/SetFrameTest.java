package simpleFrame;

import java.awt.*;
import javax.swing.*;

public class SetFrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SizeFrame();
                frame.setTitle("SizeFrame");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class SizeFrame extends JFrame{
    public SizeFrame()
    {
        //get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        //set frame width,heigth and  let platform pick screen location
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        //set frame icon
        Image img = new ImageIcon().getImage();
        setIconImage(img);
    }
}
