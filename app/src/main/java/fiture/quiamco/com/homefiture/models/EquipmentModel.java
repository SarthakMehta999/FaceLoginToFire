package fiture.quiamco.com.homefiture.models;

/**
 * Created by ShawnErl on 06/08/2018.
 */

public class EquipmentModel {
    private String equipmentname;
    private String equipmentimage;
    private int equipmentid;

    public int getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(int equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public String getEquipmentimage() {
        return equipmentimage;
    }

    public void setEquipmentimage(String equipmentimage) {
        this.equipmentimage = equipmentimage;
    }
}
