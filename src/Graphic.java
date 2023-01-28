import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Graphic{


    private int width;
    private int height;
    private BufferedImage img;
    String fileName;
    Color[][] colorValues;


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

    public void setPixelColor(int x, int y, Color color){
        colorValues[x][y] = color;
    }

    // TODO: Methode impelementieren
    public void fillWithColor(Color color){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                setPixelColor(x, y, color);
            }
        }

    }

    // TODO: Methode implementieren
    public void replaceColor(Color newColor, Color replacedColor){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (colorValues[x][y].equals(replacedColor)){
                    colorValues[x][y] = newColor;
                }
            }
        }
    }

    // TODO: Methode implementieren
    public void fillWithVerticalStripes(Color color1, Color color2, int numberOfPixels){
        int counter = 0;
        Color currentColor = color1;
        for (int x = 0; x < width; x++){
            if (counter == numberOfPixels){
                counter = 0;
                if (currentColor == color1){
                    currentColor = color2;
                }
                else {
                    currentColor = color1;
                }
            }

            for (int y = 0; y < height; y++){
                setPixelColor(x, y, currentColor);
            }

            counter++;
        }
    }

    // TODO: Methode implementieren
    public void fillWithHorizontalStripes(Color color1, Color color2, int numberOfPixels){
        int counter = 0;
        Color currentColor = color1;
        for (int y = 0; y < height; y++){
            if (counter == numberOfPixels){
                counter = 0;
                if (currentColor == color1){
                    currentColor = color2;
                }
                else {
                    currentColor = color1;
                }
            }

            for (int x = 0; x < width; x++){
                setPixelColor(x, y, currentColor);
            }

            counter++;
        }
    }



    // TODO: Methode implementieren
    public void fillWithColorGradient(Color startColor, Color endColor, DIRECTION direction){

        int steps;

        if (direction == DIRECTION.UP || direction == DIRECTION.DOWN){
            steps = height;
        }
        else {
            steps = width;
        }


        double rDifference = endColor.getR() - startColor.getR();
        double rDifferencePerPixel = rDifference / steps;
        double rCurrent = startColor.getR();

        double gDifference = endColor.getG() - startColor.getG();
        double gDifferencePerPixel = gDifference / steps;
        double gCurrent = startColor.getG();

        double bDifference = endColor.getB() - startColor.getB();
        double bDifferencePerPixel = bDifference / steps;
        double bCurrent = startColor.getB();


        switch (direction){
            case DOWN:
                for (int y = 0; y < height; y++){
                    rCurrent = rCurrent + rDifferencePerPixel;
                    gCurrent = gCurrent + gDifferencePerPixel;
                    bCurrent = bCurrent + bDifferencePerPixel;
                    for (int x = 0; x < width; x++){
                        setPixelColor(x, y, new Color((int) rCurrent, (int) gCurrent, (int) bCurrent));
                    }
                }
                break;
            case UP:
                for (int y = height-1; y >= 0; y--){
                    rCurrent = rCurrent + rDifferencePerPixel;
                    gCurrent = gCurrent + gDifferencePerPixel;
                    bCurrent = bCurrent + bDifferencePerPixel;

                    for (int x = 0; x < width; x++){
                        setPixelColor(x, y, new Color((int) rCurrent, (int) gCurrent, (int) bCurrent));
                    }
                }
                break;
            case RIGHT:
                for (int x = 0; x < width; x++){
                    rCurrent = rCurrent + rDifferencePerPixel;
                    gCurrent = gCurrent + gDifferencePerPixel;
                    bCurrent = bCurrent + bDifferencePerPixel;

                    for (int y = 0; y < height; y++){
                        setPixelColor(x, y, new Color((int) rCurrent, (int) gCurrent, (int) bCurrent));
                    }
                }
                break;
            case LEFT:
                for (int x = width-1; x >= 0; x--){
                    rCurrent = rCurrent + rDifferencePerPixel;
                    gCurrent = gCurrent + gDifferencePerPixel;
                    bCurrent = bCurrent + bDifferencePerPixel;

                    for (int y = 0; y < height; y++){
                        setPixelColor(x, y, new Color((int) rCurrent, (int) gCurrent, (int) bCurrent));
                    }
                }
                break;

        }

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

