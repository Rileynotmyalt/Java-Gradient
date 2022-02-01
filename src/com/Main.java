package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        BufferedImage bufferedImage = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);

        // get pix val
        int pix = bufferedImage.getRGB(0, 0);
        System.out.println(pix);

        int a = (pix >> 24) & 0xff;
        int r = (pix >> 16) & 0xff;
        int g = (pix >> 8) & 0xff;
        int b = pix & 0xff;

        System.out.println(a + " " + r + " " + g + " " + b + " ");

        a = 255;
        r = 255;
        g = 0;
        b = 0;

        pix = (a << 24) | (r << 16) | (g << 8) | b;

        bufferedImage.setRGB(0, 0, pix);
        bufferedImage.setRGB(1, 1, pix);

        System.out.println(bufferedImage.getRGB(0, 0));
        System.out.println(bufferedImage.getRGB(0, 1));
        System.out.println(bufferedImage.getRGB(1, 1));

        // jpeg not jpg, using png instead
        File f = new File("Output.png");
        ImageIO.write(bufferedImage, "png", f);
        System.out.println(f.getAbsolutePath());
    }

    /**
     * creates a valid integer from rgba values to be used to set pixels and make
     * things easier to work with
     */
    public static int intRGBA(int red, int green, int blue, int alpha) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
}
