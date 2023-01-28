public class Main {

    public static void main(String[] args) {
        Graphic graphic = new Graphic(100, 100, "test");
        graphic.fillWithColorGradient(new Color(0,0,0), new Color(255,100,10), DIRECTION.LEFT);
        graphic.saveImageAsPNG();


    }
}
