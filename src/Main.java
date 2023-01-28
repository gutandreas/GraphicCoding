public class Main {

    public static void main(String[] args) {
        Graphic graphic = new Graphic(10, 10, "test");
        graphic.fillWithHorizontalStripes(new Color(255, 0,0), new Color(0, 255, 0), 2);
        graphic.replaceColor(new Color(0, 100, 100), new Color(255, 0,0));
        //graphic.fillWithColor(new Color(255, 0, 0));
        //graphic.fillWithColorGradient(new Color(0,0,0), new Color(255,100,10), DIRECTION.LEFT);
        graphic.saveImageAsPNG();


    }
}
