
package td2_image;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author hamster
 */
public class SeamCarving{
    Main main = null;
   
    public SeamCarving(Main main) {
        this.main = main;
    }
    
    protected void seamCaving() {
        int removeColumns = 50;
        int removeRows = 50;

        System.out.printf("image is %d columns by %d rows\n", main.img.getWidth(), 
                main.img.getHeight());
        SeamCarver sc = new SeamCarver(main.img);
        for (int i = 0; i < removeRows; i++) {
            int[] horizontalSeam = sc.findHorizontalSeam();
            sc.removeHorizontalSeam(horizontalSeam);
        }

        for (int i = 0; i < removeColumns; i++) {
            int[] verticalSeam = sc.findVerticalSeam();
            sc.removeVerticalSeam(verticalSeam);
        }
        BufferedImage outputImage = sc.picture();

        System.out.printf("new image size is %d columns by %d rows\n", sc.width(), sc.height());
        JFrame frame = new JFrame();
        main.icon = new ImageIcon(outputImage);
        frame.setContentPane(new JLabel(main.icon));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Seam carving img");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.repaint();

    }
}
