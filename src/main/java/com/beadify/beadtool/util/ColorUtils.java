package com.beadify.beadtool.util;

import com.beadify.beadtool.model.BeadColor;
import java.util.List;

public class ColorUtils {

    private static double colorDistance(int[] c1, int[] c2) {
        int rDiff = c1[0] - c2[0];
        int gDiff = c1[1] - c2[1];
        int bDiff = c1[2] - c2[2];
        return Math.sqrt(rDiff * rDiff + gDiff * gDiff + bDiff * bDiff);
    }

    public static BeadColor findClosestColor(int[] targetRGB, List<BeadColor> palette) {
        BeadColor closest = null;
        double minDistance = Double.MAX_VALUE;

        for (BeadColor color : palette) {
            double distance = colorDistance(targetRGB, color.getRGB());
            if (distance < minDistance) {
                minDistance = distance;
                closest = color;
            }
        }

        return closest;
    }
}
