package com.zyh.entity.usercollect;

import java.io.Serializable;
import java.util.Date;

public class ZyhUserCollect implements Serializable {
    private String id;

    private String userid;

    private String articleid;

    private String arttype;

    private String title;

    private String imgurl;

    private Date pubtime;

    private String comtype;

    private String city;

    private String area;

    private String street;

    private String label;

    private String trainlabel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid == null ? null : articleid.trim();
    }

    public String getArttype() {
        return arttype;
    }

    public void setArttype(String arttype) {
        this.arttype = arttype == null ? null : arttype.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public String getComtype() {
        return comtype;
    }

    public void setComtype(String comtype) {
        this.comtype = comtype == null ? null : comtype.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getTrainlabel() {
        return trainlabel;
    }

    public void setTrainlabel(String trainlabel) {
        this.trainlabel = trainlabel == null ? null : trainlabel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", articleid=").append(articleid);
        sb.append(", arttype=").append(arttype);
        sb.append(", title=").append(title);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", pubtime=").append(pubtime);
        sb.append(", comtype=").append(comtype);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", street=").append(street);
        sb.append(", label=").append(label);
        sb.append(", trainlabel=").append(trainlabel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}