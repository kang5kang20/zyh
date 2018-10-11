package com.zyh.entity.resume;

import java.io.Serializable;

public class ZyhResumeEducation implements Serializable {
    private String id;

    private String userid;

    private String school;

    private String edtime;

    private String category;

    private String major;

    private String edstate;

    private String desct;

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

    public String getEdtime() {
        return edtime;
    }

    public void setEdtime(String edtime) {
        this.edtime = edtime == null ? null : edtime.trim();
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

    public String getEdstate() {
        return edstate;
    }

    public void setEdstate(String edstate) {
        this.edstate = edstate == null ? null : edstate.trim();
    }

    public String getDesct() {
        return desct;
    }

    public void setDesct(String desct) {
        this.desct = desct == null ? null : desct.trim();
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
        sb.append(", edtime=").append(edtime);
        sb.append(", category=").append(category);
        sb.append(", major=").append(major);
        sb.append(", edstate=").append(edstate);
        sb.append(", desct=").append(desct);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}