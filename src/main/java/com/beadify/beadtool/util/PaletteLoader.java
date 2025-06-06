package com.beadify.beadtool.util;

import com.beadify.beadtool.model.BeadColor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//Read the JSON file that defines Mard's bead colors and convert it into a list of BeadColor objects.”
public class PaletteLoader {

    public static List<BeadColor> loadPalette(String fileName) {
        List<BeadColor> colors = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream input = PaletteLoader.class
                .getClassLoader()
                .getResourceAsStream("palettes/" + fileName)) {

            JsonNode root = mapper.readTree(input);
            for (JsonNode node : root) {
                String name = node.get("name").asText();
                String hex = node.get("color").asText().replace("#", "");
                int r = Integer.parseInt(hex.substring(0, 2), 16);
                int g = Integer.parseInt(hex.substring(2, 4), 16);
                int b = Integer.parseInt(hex.substring(4, 6), 16);
                colors.add(new BeadColor(name, r, g, b));
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to load palette " + fileName + ": " + e.getMessage());
        }

        return colors;
    }
}
