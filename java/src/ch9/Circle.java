package ch9;

public class Circle implements Cloneable {
    Point p;
    double r;

    public Circle(Point p, double r){
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {
        Object obj = null;

        try{
            obj = super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return (Circle)obj;
    }

    public Circle deepCopy() {
        Object obj = null;

        try {
            obj = super.clone();
        }  catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Circle c = (Circle)obj;
        c.p = new Point(this.p.x, this.p.y);

        return c;
    }

    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}
