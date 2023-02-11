package Entity;

import DTO.CD_DTO;
import java.io.Serializable;

/**
 *
 * @author giahu
 */
public class CD implements Serializable {

    private String collName;
    private boolean type;
    private String title;
    private float price;
    private String ID;
    private int year;

    public CD() {
    }

    public CD(String collName, boolean type, String title, float price, String ID, int year) {
        this.collName = collName;
        this.type = type;
        this.title = title;
        this.price = price;
        this.ID = ID;
        this.year = year;
    }

    public String getCollName() {
        return collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return collName + ", "
                + type + ", "
                + title + ", "
                + price + ", "
                + ID + ", "
                + year;
    }

    public CD_DTO toDTO() {
        CD_DTO dto = new CD_DTO();
        dto.setCollName(this.getCollName());
        dto.setType(this.isType());
        dto.setTitle(this.getTitle());
        dto.setPrice(this.getPrice());
        dto.setID(this.getID());
        dto.setYear(this.getYear());
        return dto;
    }
}
