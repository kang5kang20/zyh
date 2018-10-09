package com.zyh.entity.news;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZyhNews implements Serializable {
    private String id;

    private Date pubtime;

    private String imgurl;

    private String content;

    private String title;

    private String ifhome;

    private String createuser;

    private Integer readcount;

    private String ifground;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIfhome() {
        return ifhome;
    }

    public void setIfhome(String ifhome) {
        this.ifhome = ifhome == null ? null : ifhome.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public String getIfground() {
        return ifground;
    }

    public void setIfground(String ifground) {
        this.ifground = ifground == null ? null : ifground.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pubtime=").append(pubtime);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", content=").append(content);
        sb.append(", title=").append(title);
        sb.append(", ifhome=").append(ifhome);
        sb.append(", createuser=").append(createuser);
        sb.append(", readcount=").append(readcount);
        sb.append(", ifground=").append(ifground);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}