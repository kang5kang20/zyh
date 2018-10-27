package com.zyh.entity.company;

import java.io.Serializable;

public class ZyhCompany implements Serializable {
    private String id;

    private String name;

    private String logo;

    private String address;

    private String web;

    private String desct;

    private String image;

    private String label;

    private String city;

    private String province;

    private String area;

    private String street;

    private String trainlabel;

    private String state;

    private String contacts;

    private String contphone;
    
    private String type;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public String getDesct() {
        return desct;
    }

    public void setDesct(String desct) {
        this.desct = desct == null ? null : desct.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
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

    public String getTrainlabel() {
        return trainlabel;
    }

    public void setTrainlabel(String trainlabel) {
        this.trainlabel = trainlabel == null ? null : trainlabel.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContphone() {
        return contphone;
    }

    public void setContphone(String contphone) {
        this.contphone = contphone == null ? null : contphone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", logo=").append(logo);
        sb.append(", address=").append(address);
        sb.append(", web=").append(web);
        sb.append(", desct=").append(desct);
        sb.append(", image=").append(image);
        sb.append(", label=").append(label);
        sb.append(", city=").append(city);
        sb.append(", province=").append(province);
        sb.append(", area=").append(area);
        sb.append(", street=").append(street);
        sb.append(", trainlabel=").append(trainlabel);
        sb.append(", state=").append(state);
        sb.append(", contacts=").append(contacts);
        sb.append(", contphone=").append(contphone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}