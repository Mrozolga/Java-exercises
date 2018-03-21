package CSVReader;

import java.awt.geom.Area;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Predicate;


public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();
    Map<Long, AdminUnit> id_list = new HashMap<>();


    public void read(String filename) throws IOException {
        int i = 0;
        int area = 0;
        int density = 0;
        Long id;

        Map<Long, AdminUnit> mapa = new HashMap<>();
        Map<AdminUnit, Long> parent_id = new HashMap<>();
        Map<Long, List<AdminUnit>> parentid2child = new HashMap<>();
        CSVReader reader2 = new CSVReader(filename, ",", true);

        while (reader2.next()) {
            AdminUnit A = new AdminUnit();
            id = reader2.getLong("id");
            Long parent = null;
            if (!reader2.isMissing("name"))
                A.setName(reader2.get("name"));
            if (!reader2.isMissing("parent"))
                parent = reader2.getLong("parent");
            if (!reader2.isMissing("admin_level"))
                A.setAdminLevel(reader2.getInt("admin_level"));
            if (!reader2.isMissing("population"))
                A.setPopulation(reader2.getDouble("population"));
            if (!reader2.isMissing("area"))
                A.setArea(reader2.getDouble("area"));
            if (!reader2.isMissing("density"))
                A.setDensity(reader2.getDouble("density"));
            if (!parentid2child.containsKey(parent)) {
                List<AdminUnit> child = new ArrayList<>();
                child.add(A);
                parentid2child.put(parent, child);
            } else {
                List<AdminUnit> child = parentid2child.get(parent);
                child.add(A);
                parentid2child.put(parent, child);
            }

            for (AdminUnit n : units) {
                if (parent_id.get(n) != null) {
                    n.parent = id_list.get(parent_id.get(n));
                }
                if (parentid2child.containsKey(id_list.get(n))) {
                    n.children = parentid2child.get(id_list.get(n));
                }
                n.fixMissingValues();
            }

            if (!reader2.isMissing("x1") && !reader2.isMissing("y1")) {
                double Px = reader2.getDouble("x1");
                double Py = reader2.getDouble("y1");
                A.bbox.addPoint(Px, Py);
            }
            if (!reader2.isMissing("x3") && !reader2.isMissing("y3")) {
                double Px = reader2.getDouble("x3");
                double Py = reader2.getDouble("y3");
                A.bbox.addPoint(Px, Py);
            }
            units.add(A);
//            System.out.print(A.name);
//            System.out.print("\n");
            i++;
        }

    }


    void list(PrintStream out) {
        for (AdminUnit element : units) {
            out.print(element.toString());
        }
    }

    void list(PrintStream out, int offset, int limit) {
        for (int i = offset; i < limit; i++) {
            out.print(units.get(i).toString());
        }
    }

    public AdminUnitList selectByName(String pattern, boolean regex) {
        AdminUnitList ret = new AdminUnitList();
        if (regex) {
            for (AdminUnit element : units) {
                if (element.getName().matches(pattern))
                    ret.units.add(element);
            }
        } else {
            for (AdminUnit element : units) {
                if (element.getName().contains(pattern))
                    ret.units.add(element);
            }
        }
        return ret;
    }

    AdminUnitList getNeighbors(AdminUnit unit, double maxdistance) {
        AdminUnitList wynik = new AdminUnitList();
        for (AdminUnit n : units) {
            if (unit.adminLevel == n.adminLevel && unit != n) {
                if (unit.adminLevel == 6) {
                    if (unit.bbox.distanceTo(n.bbox) <= maxdistance) {
                        wynik.units.add(n);
                        System.out.print(unit.bbox.distanceTo(n.bbox) + "  " + n.getName() + " " + n.getAdminLevel() + "\n");
                    }
                } else {
                    if (unit.bbox.intersects(n.bbox)) {
                        wynik.units.add(n);
                        System.out.print(unit.bbox.distanceTo(n.bbox) + "  " + n.getName() + " " + n.getAdminLevel() + "\n");
                    }
                }
            }
        }
        return wynik;
    }

    public AdminUnitList sortInplaceByName() {
        class C_name implements Comparator<AdminUnit> {

            @Override
            public int compare(AdminUnit t1, AdminUnit t2) {
                return t1.name.compareTo(t2.name);
            }
        }
        C_name comp = new C_name();
        this.units.sort(comp);
        return this;
    }


    public AdminUnitList sortInplaceByArea() {
        Comparator<AdminUnit> comp = new Comparator<AdminUnit>() {
            @Override
            public int compare(AdminUnit t, AdminUnit t1) {
                return Double.compare(t.area, t1.area);
            }
        };
        this.units.sort(comp);
        return this;
    }

    AdminUnitList sortInplaceByPopulation() {
        Comparator<AdminUnit> comp = Comparator.comparingDouble(t -> t.population);
        this.units.sort(comp);
        return this;
    }

    AdminUnitList sortInplace(Comparator<AdminUnit> cmp) {
        this.units.sort(cmp);
        return this;
    }

    AdminUnitList sort(Comparator<AdminUnit> cmp) {
        // Tworzy wyjściową listę
        // Kopiuje wszystkie jednostki
        // woła sortInPlace
        AdminUnitList list = new AdminUnitList();
        for (AdminUnit element : units) {
            list.units.add(element);
        }
        list.sort(cmp);
        return this;
    }

    /**
     * @param pred referencja do interfejsu Predicate
     * @return nową listę, na której pozostawiono tylko te jednostki,
     * dla których metoda test() zwraca true
     */
    AdminUnitList filter(Predicate<AdminUnit> pred) {
        AdminUnitList list = new AdminUnitList();
        for (AdminUnit element : units) {
            if (pred.test(element))
            list.units.add(element);
        }
        return list;
    }
    AdminUnitList filter(Predicate<AdminUnit> pred, int limit){
        AdminUnitList list = new AdminUnitList();
        int i=0;
        for (AdminUnit element : units) {
            if (i>=limit) break;
            if (pred.test(element))
                list.units.add(element);
            i++;
        }
        return list;
    }
    AdminUnitList filter(Predicate<AdminUnit> pred, int offset, int limit){
        AdminUnitList list = new AdminUnitList();
        int i=0;
        for (AdminUnit element : units) {
            if (i>=limit) break;
            if (pred.test(element) && i>=offset)
                list.units.add(element);
            i++;
        }
        return list;
    }

}

