public class Point{
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return this.x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return this.y;
    }

    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPoint(Point p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public Point getPoint(){
        return this;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public void move(Point p){
        this.x += p.getX();
        this.y += p.getY();
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveTo(Point p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double distanceTo(int x, int y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distanceTo(Point p){
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }

    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean equals(Point p){
        return this.x == p.getX() && this.y == p.getY();
    }

    public boolean equals(int x, int y){
        return this.x == x && this.y == y;
    }

    public boolean equals(Object o){
        if(o instanceof Point){
            Point p = (Point) o;
            return this.x == p.getX() && this.y == p.getY();
        }
        return false;
    }

    public Point clone(){
        return new Point(this.x, this.y);
    }
}
