package com.zyh.entity.company;

import java.io.Serializable;
import java.util.Date;

public class ZyhCompanyPosition implements Serializable {
    private String id;

    private String companyid;

    private String compnayname;

    private String positionname;

    private String workcity;

    private String fixyear;

    private String maxage;

    private String moneyarea;

    private String desct;

    private String required;

    private Date optime;

    private Float minmoney;

    private Float maxmoney;

    private String state;

    private String workaddress;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getCompnayname() {
        return compnayname;
    }

    public void setCompnayname(String compnayname) {
        this.compnayname = compnayname == null ? null : compnayname.trim();
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

    public String getWorkcity() {
        return workcity;
    }

    public void setWorkcity(String workcity) {
        this.workcity = workcity == null ? null : workcity.trim();
    }

    public String getFixyear() {
        return fixyear;
    }

    public void setFixyear(String fixyear) {
        this.fixyear = fixyear == null ? null : fixyear.trim();
    }

    public String getMaxage() {
        return maxage;
    }

    public void setMaxage(String maxage) {
        this.maxage = maxage == null ? null : maxage.trim();
    }

    public String getMoneyarea() {
        return moneyarea;
    }

    public void setMoneyarea(String moneyarea) {
        this.moneyarea = moneyarea == null ? null : moneyarea.trim();
    }

    public String getDesct() {
        return desct;
    }

    public void setDesct(String desct) {
        this.desct = desct == null ? null : desct.trim();
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public Float getMinmoney() {
        return minmoney;
    }

    public void setMinmoney(Float minmoney) {
        this.minmoney = minmoney;
    }

    public Float getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(Float maxmoney) {
        this.maxmoney = maxmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress == null ? null : workaddress.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyid=").append(companyid);
        sb.append(", compnayname=").append(compnayname);
        sb.append(", positionname=").append(positionname);
        sb.append(", workcity=").append(workcity);
        sb.append(", fixyear=").append(fixyear);
        sb.append(", maxage=").append(maxage);
        sb.append(", moneyarea=").append(moneyarea);
        sb.append(", desct=").append(desct);
        sb.append(", required=").append(required);
        sb.append(", optime=").append(optime);
        sb.append(", minmoney=").append(minmoney);
        sb.append(", maxmoney=").append(maxmoney);
        sb.append(", state=").append(state);
        sb.append(", workaddress=").append(workaddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}