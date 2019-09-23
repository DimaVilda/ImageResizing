package td2_image;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.imgscalr.Scalr;

/**
 *
 * @author hamster
 */
public class Recadrage {

    Main main = null;
    BufferedImage scaledImage = null;

    public Recadrage(Main main, BufferedImage scaledImage) {
        this.main = main;
        this.scaledImage = scaledImage;
    }

    protected BufferedImage recadrerImg() {
        if (main.jSliderResizer.getValue() < main.getPrecent()) {
            main.setPrecent(main.jSliderResizer.getValue());
            if (main.img.getHeight() != main.getHEIGHT() && main.jSliderResizer.getValue() > 50) {
                main.setHeight(main.getHEIGHT() + main.jSliderResizer.getMajorTickSpacing());
                scaledImage = Scalr.crop(main.img,
                        main.getWIDTH(), main.getHEIGHT());
                main.icon = new ImageIcon(scaledImage);
                //main.lbl.setSize(scaledImage.getWidth(), scaledImage.getHeight());
                //main.lbl.setIcon(main.icon);
                main.lblImage.setIcon(main.icon);
            } else {
                main.setHeight(main.getHEIGHT() - main.jSliderResizer.getMajorTickSpacing());
                scaledImage = Scalr.crop(main.img, 0, main.img.getHeight() - main.getHEIGHT(),
                        main.getWIDTH(), main.getHEIGHT());
            }
        } else if (main.jSliderResizer.getValue() > main.getPrecent()) {
            main.setPrecent(main.jSliderResizer.getValue());
            if (main.img.getHeight() != main.getHEIGHT() && main.jSliderResizer.getValue() < 50) {
                main.setHeight(main.getHEIGHT() + main.jSliderResizer.getMajorTickSpacing());
                scaledImage = Scalr.crop(main.img, 0, main.img.getHeight() - main.getHEIGHT(),
                        main.getWIDTH(), main.getHEIGHT());
                main.icon = new ImageIcon(scaledImage);
                //main.lbl.setSize(scaledImage.getWidth(), scaledImage.getHeight());
                //main.lbl.setIcon(main.icon);
                main.lblImage.setIcon(main.icon);
            } else {
                main.setHeight(main.getHEIGHT() - main.jSliderResizer.getMajorTickSpacing());
                scaledImage = Scalr.crop(main.img,
                        main.getWIDTH(), main.getHEIGHT());
            }

        }
        return scaledImage;
    }
}
