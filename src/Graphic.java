import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Graphic{


    private int width;
    private int height;
    private BufferedImage img;
    private String fileName;
    private Color[][] colorValues;


    public Graphic(int width, int height, String fileName) {
        this.width = width;
        this.height = height;
        colorValues = new Color[width][height];
        this.fileName = fileName;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                colorValues[i][j] = new Color(255, 255, 255);
            }
        }

    }

    private void setPixelColor(int x, int y, Color color){
        if (x > width || y > height){
            System.out.println("Diese Position exisitert im Bild nicht");
        }
        else {
            colorValues[x][y] = color;
        }
    }

    // TODO: Methode impelementieren
    public void fillWithColor(Color color){

    }

    // TODO: Methode implementieren
    public void replaceColor(Color newColor, Color replacedColor){

    }

    // TODO: Methode implementieren
    public void fillWithVerticalStripes(Color color1, Color color2, int numberOfPixels){
        int counter = 0;

    }

    // TODO: Methode implementieren
    public void fillWithHorizontalStripes(Color color1, Color color2, int numberOfPixels){
        int counter = 0;

    }



    // TODO: Methode implementieren
    public void fillWithColorGradient(Color startColor, Color endColor, DIRECTION direction){

    }

    public void saveImageAsPNG(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                Color color = colorValues[i][j];
                int colorAsInt = 0<<24 | (color.getR()<<16) | (color.getG()<<8) | color.getB();
                img.setRGB(i, j, colorAsInt);
            }
        }
        try
        {
            File f = new File(fileName + ".png");
            ImageIO.write(img, "png", f);
            System.out.println("Bild in der Datei " + fileName + ".png gespeichert");

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }



}

