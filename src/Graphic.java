import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Graphic{


    private int pixelDimension = 1;
    private int width;
    private int height;
    private BufferedImage img;
    String fileName;
    Color[][] colorValues;


    public Graphic(int width, int height, String fileName) {
        this.width = width;
        this.height = height;
        colorValues = new Color[width*pixelDimension][height*pixelDimension];
        this.fileName = fileName;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                colorValues[i][j] = new Color(255, 255, 255);
            }
        }

    }

    public void setPixelColor(int x, int y, Color color){
        System.out.println(color);
        for (int i = 0; i < pixelDimension; i++){
            for (int j = 0; j < pixelDimension; j++){
                colorValues[x+i][y+j] = color;
            }
        }
    }


    public void fillWithColorGradient(Color startColor, Color endColor, DIRECTION direction){

        double rDifference = endColor.getR() - startColor.getR();
        double rDifferencePerPixel = rDifference / height;
        int rCurrent = startColor.getR();

        double gDifference = endColor.getG() - startColor.getG();
        double gDifferencePerPixel = gDifference / height;
        int gCurrent = startColor.getG();

        double bDifference = endColor.getB() - startColor.getB();
        double bDifferencePerPixel = bDifference / height;
        int bCurrent = startColor.getB();

        switch (direction){
            case DOWN:
                for (int y = 0; y < height; y++){
                    rCurrent = (int) (rCurrent + rDifferencePerPixel);
                    gCurrent = (int) (gCurrent + gDifferencePerPixel);
                    bCurrent = (int) (bCurrent + bDifferencePerPixel);

                    System.out.println(rCurrent);
                    for (int x = 0; x < width; x++){
                        setPixelColor(x, y, new Color(rCurrent, gCurrent, bCurrent));
                    }
                }
                break;
            case UP:
                for (int y = height*pixelDimension; y > 0; y = y - pixelDimension){
                    rCurrent = (int) (rCurrent + rDifferencePerPixel);
                    gCurrent = (int) (gCurrent + gDifferencePerPixel);
                    bCurrent = (int) (bCurrent + bDifferencePerPixel);

                    System.out.println(rCurrent);
                    for (int x = 0; x < width; x++){
                        setPixelColor(x, y, new Color(rCurrent, gCurrent, bCurrent));
                    }
                }
                break;




        }



    }

    public void saveImage(){
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

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }






    public void writeout()
    {

    }

}

