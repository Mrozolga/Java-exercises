package CSVReader;
import static java.lang.Math.*;

public class BoundingBox {
    double xmin=Double.NaN;
    double ymin=Double.NaN;
    double xmax=Double.NaN;
    double ymax=Double.NaN;
    boolean empty = true;

    void addPoint(double x, double y){
        if(!this.isEmpty()) {
            if (xmin > x)
                xmin = x;
            if (ymin > y)
                ymin = y;
            if (xmax < x)
                xmax = x;
            if (ymax < y)
                ymax = y;

        }
        else
        {
            xmin=x;
            xmax=x;
            ymin=y;
            ymax=y;
            empty=false;
        }
    }

    boolean contains(double x, double y){
        if(x<=xmax && x>=xmin && y<=ymax && y>=ymin) return true;
        else return false;
    }


    boolean contains(BoundingBox bb){
        if(this.contains(bb.xmin,bb.ymax) && this.contains(bb.xmax,bb.ymin)) return true;
        else return false;
    }

    boolean intersects(BoundingBox bb){
        if(this.contains(bb.xmin,bb.ymin)||this.contains(bb.xmin,bb.ymax)||this.contains(bb.xmax,bb.ymin)||this.contains(bb.xmax,bb.ymax)||
                bb.contains(this.xmin,this.ymin)||bb.contains(this.xmin,this.ymax)||bb.contains(this.xmax,this.ymin)||bb.contains(this.xmax,this.ymax))
        {
            return true;
        }
        else
            return false;
    }
    /**
     * Powiększa rozmiary tak, aby zawierał bb oraz poprzednią wersję this
     * @param bb
     * @return
     */
    BoundingBox add(BoundingBox bb){
        if (!this.contains(bb)) {
            this.addPoint(bb.xmin, bb.ymin);
            this.addPoint(bb.xmax, bb.ymax);
        }
        return this;
    }

    boolean isEmpty(){
       if(empty==true) return true;
       return false;
    }


    double getCenterX(){
        if(!isEmpty()) {
            double wynik;
            wynik = (xmin + xmax) / 2;
            return wynik;
        }
        else
        throw new RuntimeException("Not implemented");
    }

    double getCenterY(){
        if(!isEmpty()) {
            double wynik;
            wynik = (ymin + ymax)/2;
            return wynik;
        }
        else throw new RuntimeException("Not implemented");
    }

    /**
     * Oblicza odległość pomiędzy środkami this bounding box oraz bbx
     * @param bbx prostokąt, do którego liczona jest odległość
     * @return if !isEmpty odległość, else wyrzuca wyjątek lub zwraca maksymalną możliwą wartość double
     * Ze względu na to, że są to współrzędne geograficzne, zamiast odległosci euklidesowej możesz użyć wzoru haversine
     * (ang. haversine formula)
     */
    double distanceTo(BoundingBox bbx){
        if (!isEmpty() && !bbx.isEmpty()) {
            double dl=Haversine.distance(this.getCenterY(), this.getCenterX(), bbx.getCenterY(), bbx.getCenterX());
            return dl;
        }
        else throw new RuntimeException("Not implemented");
    }
    public String toString()
    {
        if (empty==true) return "";
        else
        {
            String wynik ="P1: ("+ xmin +" "+ ymin+") "+"P2: ("+xmax+" "+ymax+")";
            return wynik;
        }
    }

}

