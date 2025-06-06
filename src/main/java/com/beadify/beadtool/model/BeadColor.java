package com.beadify.beadtool.model; 

public class BeadColor{
    private String name; 
    private int r,g,b; 
    public BeadColor(String name, int r, int g, int b){
        this.name = name; 
        this.r = r;
        this.g = g; 
        this.b = b; 
    }

    public String getName(){return name;}
    public int[] getRGB(){
        return new int[]{r,g,b};
    }

    //convert to hex, css color
    public String getHex() {
    return String.format("#%02x%02x%02x", r, g, b);
}

}