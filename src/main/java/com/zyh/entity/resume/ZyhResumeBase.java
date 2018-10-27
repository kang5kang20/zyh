package com.zyh.entity.resume;

import java.io.Serializable;
import java.util.Date;

public class ZyhResumeBase implements Serializable {
    private String id;

    private String userid;

    private String name;

    private String sex;

    private Date birthday;

    private String soldierdate;

    private Date workdate;

    private String bdzy;

    private String bdzw;

    private String soldierno;

    private String zzmm;

    private String idno;

    private String cellphone;

    private String phone;

    private String email;

    private String birthcity;

    private String evaluation;

    private String idurl;

    private String soldierurl;

    private String state;

    private String workstate;

    private String idbackurl;

    private String soldierbackurl;

    private String idcheckstate;

    private String soldiercheckstate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSoldierdate() {
        return soldierdate;
    }

    public void setSoldierdate(String soldierdate) {
        this.soldierdate = soldierdate == null ? null : soldierdate.trim();
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public String getBdzy() {
        return bdzy;
    }

    public void setBdzy(String bdzy) {
        this.bdzy = bdzy == null ? null : bdzy.trim();
    }

    public String getBdzw() {
        return bdzw;
    }

    public void setBdzw(String bdzw) {
        this.bdzw = bdzw == null ? null : bdzw.trim();
    }

    public String getSoldierno() {
        return soldierno;
    }

    public void setSoldierno(String soldierno) {
        this.soldierno = soldierno == null ? null : soldierno.trim();
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm == null ? null : zzmm.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBirthcity() {
        return birthcity;
    }

    public void setBirthcity(String birthcity) {
        this.birthcity = birthcity == null ? null : birthcity.trim();
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getIdurl() {
        return idurl;
    }

    public void setIdurl(String idurl) {
        this.idurl = idurl == null ? null : idurl.trim();
    }

    public String getSoldierurl() {
        return soldierurl;
    }

    public void setSoldierurl(String soldierurl) {
        this.soldierurl = soldierurl == null ? null : soldierurl.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate == null ? null : workstate.trim();
    }

    public String getIdbackurl() {
        return idbackurl;
    }

    public void setIdbackurl(String idbackurl) {
        this.idbackurl = idbackurl == null ? null : idbackurl.trim();
    }

    public String getSoldierbackurl() {
        return soldierbackurl;
    }

    public void setSoldierbackurl(String soldierbackurl) {
        this.soldierbackurl = soldierbackurl == null ? null : soldierbackurl.trim();
    }

    public String getIdcheckstate() {
        return idcheckstate;
    }

    public void setIdcheckstate(String idcheckstate) {
        this.idcheckstate = idcheckstate == null ? null : idcheckstate.trim();
    }

    public String getSoldiercheckstate() {
        return soldiercheckstate;
    }

    public void setSoldiercheckstate(String soldiercheckstate) {
        this.soldiercheckstate = soldiercheckstate == null ? null : soldiercheckstate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", soldierdate=").append(soldierdate);
        sb.append(", workdate=").append(workdate);
        sb.append(", bdzy=").append(bdzy);
        sb.append(", bdzw=").append(bdzw);
        sb.append(", soldierno=").append(soldierno);
        sb.append(", zzmm=").append(zzmm);
        sb.append(", idno=").append(idno);
        sb.append(", cellphone=").append(cellphone);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", birthcity=").append(birthcity);
        sb.append(", evaluation=").append(evaluation);
        sb.append(", idurl=").append(idurl);
        sb.append(", soldierurl=").append(soldierurl);
        sb.append(", state=").append(state);
        sb.append(", workstate=").append(workstate);
        sb.append(", idbackurl=").append(idbackurl);
        sb.append(", soldierbackurl=").append(soldierbackurl);
        sb.append(", idcheckstate=").append(idcheckstate);
        sb.append(", soldiercheckstate=").append(soldiercheckstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}