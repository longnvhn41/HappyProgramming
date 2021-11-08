/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Dao Van Do
 */
public class MentorEntity {

    private int id;
    private String name;
    private String img;
    private String description;
    int rate;
    
    private Date dateOfBird;
    private String email;
    private String phone;
    private String accountName;
    private String sex;
    private String address;
    private String profession;
    private String serviceDescription;
    private String achievementDescition;
    private String frameWork;
    private String skill;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(Date dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getAchievementDescition() {
        return achievementDescition;
    }

    public void setAchievementDescition(String achievementDescition) {
        this.achievementDescition = achievementDescition;
    }

    public String getFrameWork() {
        return frameWork;
    }

    public void setFrameWork(String frameWork) {
        this.frameWork = frameWork;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    
}
