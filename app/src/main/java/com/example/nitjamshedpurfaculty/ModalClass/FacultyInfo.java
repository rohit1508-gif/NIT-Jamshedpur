package com.example.nitjamshedpurfaculty.ModalClass;

import java.net.URL;

import javax.net.ssl.SSLContext;

public class FacultyInfo  {
    String img;
    String name;
    String des;
    String link;
    public FacultyInfo(){}
    public FacultyInfo(String image,String name,String des,String link){
        this.img=image;
        this.name=name;
        this.des=des;
        this.link=link;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
