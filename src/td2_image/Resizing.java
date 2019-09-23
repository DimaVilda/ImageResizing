package td2_image;

import java.awt.image.BufferedImage;
import org.imgscalr.Scalr;

/**
 *
 * @author hamster
 */
public class Resizing {

    Main main = null;
    BufferedImage scaledImage = null;

    public Resizing(Main main, BufferedImage scaledImage) {
        this.main = main;
        this.scaledImage = scaledImage;
    }

    protected BufferedImage changeEchelle() throws IllegalArgumentException {
        if (main.jSliderResizer.getValue() < main.getPrecent()) {
            main.setPrecent(main.jSliderResizer.getValue());
            main.setWidth(main.getWIDTH() - main.jSliderResizer.getMajorTickSpacing());
            main.setHeight(main.getHEIGHT() - main.jSliderResizer.getMajorTickSpacing());
				
            scaledImage = Scalr.resize(main.img, Scalr.Method.QUALITY,
                    main.getWIDTH(),
                    main.getHEIGHT(),
                    Scalr.OP_ANTIALIAS);
        } else if (main.jSliderResizer.getValue() > main.getPrecent()) {
            main.setPrecent(main.jSliderResizer.getValue());

            main.setWidth(main.getWIDTH() + main.jSliderResizer.getMajorTickSpacing());
            main.setHeight(main.getHEIGHT() + main.jSliderResizer.getMajorTickSpacing());
            scaledImage = Scalr.resize(main.img, Scalr.Method.QUALITY,
                    main.getWIDTH(),
                    main.getHEIGHT(),
                    Scalr.OP_ANTIALIAS);
        }
        // refreshImage(scaledImage);
        return scaledImage;
    }

}
