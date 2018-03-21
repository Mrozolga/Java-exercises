package CSVReader;

import java.io.IOException;
import java.util.Locale;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) throws IOException {
        AdminUnitList ad = new AdminUnitList();
        ad.read("admin-units.csv");
//        double t1=System.nanoTime()/1e6;
//        AdminUnitList neighbours = ad.getNeighbors(ad.units.get(4453),15);
//        double t2=System.nanoTime()/1e6;
//        System.out.println("Bedkowice: \n");
//        System.out.printf("t2-t1=%f", t2-t1);
//        neighbours.list(System.out);
        //ad.filter(a->a.name.startsWith("K")).list(out);
        //ad.filter(a->a.getAdminLevel()==6).list(out);
       // ad.filter(a->a.getParent().name=="województwo małopolskie").list(out);
        AdminUnitQuery query = new AdminUnitQuery()
                .selectFrom(ad)
                .where(a->a.area>1000)
                .or(a->a.name.startsWith("Sz"))
                .sort((a,b)->Double.compare(a.area,b.area))
                .limit(100);
        query.execute().list(out);
    }
}