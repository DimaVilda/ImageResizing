package td2_image;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import static java.lang.Math.sqrt;
import java.util.stream.IntStream;

/**
 *
 * @author hamster
 */
public class DisplayGradient {

    ColorsEnum colors = null;
    Main main = null;

    BufferedImage image;
    BufferedImage transformedImage;

    private int ALPHA = 24;
    private int RED = 16;
    private int GREEN = 8;
    private int BLUE = 0;
    private int x , y;

    public DisplayGradient(ColorsEnum colors, Main main) {
        this.colors = colors;
        this.main = main;
    }

    protected BufferedImage displayGrad() {
        image = main.img;
        x = image.getHeight();
        y = image.getWidth();
        int [][] grad = null;
                switch (colors) {
                    case RED:
                        grad = gradient(RED);
                        break;
                    case GREEN:
                        grad = gradient(GREEN);
                        break;
                    case BLUE:
                        grad = gradient(BLUE);
                        break;

        }
        return afficherTableau(grad,x,y);
    }

    public int[][] gradient(int colour) {

        int[][] gradientImage = new int[y][x];
        int i0;
        int i1;
        int intensity;
        // suivant x
        for (int i : IntStream.range(0, y).toArray()) {
            for (int j : IntStream.range(0, x - 1).toArray()) {
                i0 = extract(image.getRGB(i, j), colour);
                i1 = extract(image.getRGB(i, j + 1), colour);
                intensity = (int) Math.pow((i0 - i1), 2);
                gradientImage[i][j] = intensity;
            }
        }

        //suivant y
        for (int j : IntStream.range(0, x).toArray()) {
            for (int i : IntStream.range(0, y - 1).toArray()) {
                i0 = extract(image.getRGB(i, j), colour);
                i1 = extract(image.getRGB(i + 1, j), colour);
                intensity = (int) Math.pow((i0 - i1), 2);
                gradientImage[i][j] += intensity;
            }
        }

        //norme du gradient
        for (int j : IntStream.range(0, x).toArray()) {
            for (int i : IntStream.range(0, y).toArray()) {
                intensity = (int) sqrt(gradientImage[i][j] / 2);
                gradientImage[i][j] = rgb(255, intensity, intensity, intensity);
            }
        }

        return gradientImage;
    }

    public BufferedImage afficherTableau(int[][] image, int height, int width) {

        transformedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i : IntStream.range(0, width).toArray()) {
            for (int j : IntStream.range(0, height).toArray()) {
                transformedImage.setRGB(i, j, image[i][j]);
            }
        }
        return transformedImage;

    }

    private int extract(int p, int INT_SHIFT) {
        return (p >> INT_SHIFT) & 0xff;
    }

    private int rgb(int a, int r, int g, int b) {
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

}
