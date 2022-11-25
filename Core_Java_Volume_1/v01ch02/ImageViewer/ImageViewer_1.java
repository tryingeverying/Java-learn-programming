import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * @version jdk.11
 * @author 沙丁鱼罐头
 */
public class ImageViewer_1 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            var frame = new ImageViewerFrame_1();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a label to show an image.
 */
class ImageViewerFrame_1 extends JFrame 
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame_1()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        // use a label to display the images
        var label = new JLabel();
        add(label);

        //set up the file chooser
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        //set up the menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(event ->{
            //show file chooser dialog
            int result = chooser.showOpenDialog(null);

            //if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}