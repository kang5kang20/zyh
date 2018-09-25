package com.zyh.entity.resume;

import java.io.Serializable;

public class ZyhResumeIntention implements Serializable {
    private String id;

    private String userid;

    private String workcity;

    private String position;

    private String type;

    private String expectation;

    private String posttime;

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

    public String getWorkcity() {
        return workcity;
    }

    public void setWorkcity(String workcity) {
        this.workcity = workcity == null ? null : workcity.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation == null ? null : expectation.trim();
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime == null ? null : posttime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", workcity=").append(workcity);
        sb.append(", position=").append(position);
        sb.append(", type=").append(type);
        sb.append(", expectation=").append(expectation);
        sb.append(", posttime=").append(posttime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}