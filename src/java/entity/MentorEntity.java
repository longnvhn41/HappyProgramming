/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class MentorEntity {

    private int id;
    private String name;
    private String img;
    private String description;
    int rate;

    public MentorEntity() {
    }

    public MentorEntity(int id, String name, String img, String description, int rate) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.rate = rate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
