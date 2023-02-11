package DTO;

import Entity.CD;

/**
 *
 * @author giahu
 */
public class CD_DTO {

    private String collName;
    private boolean type;//true = audio, false = video
    private String title;
    private float price;
    private String ID;
    private int year;

    public CD_DTO() {
    }

    public CD_DTO(String ID) {
        this.ID = ID;
    }

    public CD_DTO(String collName, boolean type, String title, float price, String ID, int year) {
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

    public String getType() {
        if (type) {
            return "Audio";
        } else {
            return "Video";
        }
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
        if (this.isType()) {
            return collName + ", Audio, "
                    + title + ", "
                    + price + ", "
                    + ID + ", "
                    + year;
        } else {
            return collName + ", Video, "
                    + title + ", "
                    + price + ", "
                    + ID + ", "
                    + year;
        }
    }

    public CD toEntity() {
        CD entity = new CD();
        entity.setCollName(this.getCollName());
        entity.setType(this.isType());
        entity.setTitle(this.getTitle());
        entity.setPrice(this.getPrice());
        entity.setID(this.getID());
        entity.setYear(this.getYear());
        return entity;
    }
}
