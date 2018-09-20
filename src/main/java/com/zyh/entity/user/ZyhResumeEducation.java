package com.zyh.entity.user;

import java.io.Serializable;
import java.util.Date;

public class ZyhResumeEducation implements Serializable {
    private String id;

    private String userid;

    private String school;

    private Date beginday;

    private Date endday;

    private String category;

    private String major;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Date getBeginday() {
        return beginday;
    }

    public void setBeginday(Date beginday) {
        this.beginday = beginday;
    }

    public Date getEndday() {
        return endday;
    }

    public void setEndday(Date endday) {
        this.endday = endday;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", school=").append(school);
        sb.append(", beginday=").append(beginday);
        sb.append(", endday=").append(endday);
        sb.append(", category=").append(category);
        sb.append(", major=").append(major);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}