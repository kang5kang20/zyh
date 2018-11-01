package com.zyh.entity.consult;

import java.io.Serializable;
import java.util.Date;

public class ZyhConsult implements Serializable {
    private String id;

    private String phone;

    private String createuser;

    private Date createtime;

    private String question;

    private String answer;

    private String handuser;

    private String state;

    private String userid;

    private String handuserid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getHanduser() {
        return handuser;
    }

    public void setHanduser(String handuser) {
        this.handuser = handuser == null ? null : handuser.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getHanduserid() {
        return handuserid;
    }

    public void setHanduserid(String handuserid) {
        this.handuserid = handuserid == null ? null : handuserid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", createuser=").append(createuser);
        sb.append(", createtime=").append(createtime);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", handuser=").append(handuser);
        sb.append(", state=").append(state);
        sb.append(", userid=").append(userid);
        sb.append(", handuserid=").append(handuserid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}