package com.zyh.entity.company;

import java.io.Serializable;

public class ZyhCompanyTrain implements Serializable {
    private String id;

    private String name;

    private String label;

    private String labeltxt;

    private String classdesc;

    private String companyid;

    private String weburl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getLabeltxt() {
        return labeltxt;
    }

    public void setLabeltxt(String labeltxt) {
        this.labeltxt = labeltxt == null ? null : labeltxt.trim();
    }

    public String getClassdesc() {
        return classdesc;
    }

    public void setClassdesc(String classdesc) {
        this.classdesc = classdesc == null ? null : classdesc.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl == null ? null : weburl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", label=").append(label);
        sb.append(", labeltxt=").append(labeltxt);
        sb.append(", classdesc=").append(classdesc);
        sb.append(", companyid=").append(companyid);
        sb.append(", weburl=").append(weburl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}