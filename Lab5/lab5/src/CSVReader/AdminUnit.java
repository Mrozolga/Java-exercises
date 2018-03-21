package CSVReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnit {
    String name;
    int adminLevel;
    double population;
    double area;
    double density;
    AdminUnit parent;
    List<AdminUnit> children;
    BoundingBox bbox = new BoundingBox();

    public AdminUnit(String name_, int adminLevel_, double population_, double area_, double density_) {
        name=name_;
        adminLevel=adminLevel_;
        population=population_;
        area=area_;
        density=density_;

    }


    public AdminUnit() {
    }

    public String toString()
    {
        String wynik = name+" "+adminLevel+" "+population+" "+area+" "+density+" "+bbox.toString();
        return wynik;
    }

    public String getName() {
        return name;
    }

    public AdminUnit getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void fixMissingValues()
    {
        this.population = this.density*this.area;
    }

    public void setParent(AdminUnit parent) {
        this.parent = parent;
    }

    public void setChildren(List<AdminUnit> children) {
        this.children = children;
    }


}
