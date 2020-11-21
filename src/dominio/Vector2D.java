package dominio;

public class Vector2D {
    private double x,y;

    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2D()
    {
        x = 0;
        y = 0;
    }

    public Vector2D subtract(Vector2D v) { return new Vector2D(x - v.getX(), y - v.getY());}


    public double getMagnitude()
    {
        return Math.sqrt(x*x + y*y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}