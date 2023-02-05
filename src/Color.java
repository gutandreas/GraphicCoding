public class Color {

    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {

        boolean rInRange = r >= 0 && r <= 255;
        boolean gInRange = g >= 0 && g <= 255;
        boolean bInRange = b >= 0 && b <= 255;

        if (!(rInRange && gInRange && bInRange)){
            System.out.println("Ungültiger Farbwert");
        }
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString(){
        return r + ", " + g + ", " + b;
    }

    @Override
    public boolean equals(Object o){
        boolean rEqual = this.r == ((Color) o).getR();
        boolean gEqual = this.g == ((Color) o).getG();
        boolean bEqual = this.g == ((Color) o).getB();
        return rEqual && gEqual && bEqual;
    }
}
