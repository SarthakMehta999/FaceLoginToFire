package fiture.quiamco.com.homefiture.Adapter;

/**
 * Created by User on 14/10/2017.
 */

public class Points {

   private String name,points,category;

    public Points() {
    }

    public Points(String name, String points, String category) {
        this.name = name;
        this.points = points;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
