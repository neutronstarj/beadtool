package com.beadify.beadtool.util;

import com.beadify.beadtool.model.BeadColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageProcessor {

    public static List<List<String>> processImage(InputStream imageStream, int targetWidth, int targetHeight, List<BeadColor> palette) throws Exception {
        BufferedImage originalImage = ImageIO.read(imageStream);

        if (originalImage == null) {
            throw new IllegalArgumentException("Invalid image format.");
        }

        // Resize image
        Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        // Create bead color grid
        List<List<String>> beadGrid = new ArrayList<>();
        for (int y = 0; y < resized.getHeight(); y++) {
            List<String> row = new ArrayList<>();
            for (int x = 0; x < resized.getWidth(); x++) {
                int rgb = resized.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int gVal = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                BeadColor matched = ColorUtils.findClosestColor(new int[]{r, gVal, b}, palette);
                row.add(matched.getName());
            }
            beadGrid.add(row);
        }

        return beadGrid;
    }
}
