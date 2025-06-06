package com.beadify.beadtool.service;

import com.beadify.beadtool.model.BeadColor;
import com.beadify.beadtool.util.ImageProcessor;
import com.beadify.beadtool.util.PaletteLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TemplateService {

    // Load Mard palette from resources/palettes/mard.json
    private final List<BeadColor> palette = PaletteLoader.loadPalette("mard.json");

    /**
     * Generates a 2D grid of matched bead color names from an uploaded image
     *
     * @param imageFile the uploaded image (PNG/JPEG)
     * @param width     target grid width (e.g., 29)
     * @param height    target grid height (e.g., 29)
     * @return 2D list of matched bead color names (as Strings)
     * @throws Exception if image can't be processed
     */
    public List<List<String>> generateGrid(MultipartFile imageFile, int width, int height) throws Exception {
        return ImageProcessor.processImage(imageFile.getInputStream(), width, height, palette);
    }
}
