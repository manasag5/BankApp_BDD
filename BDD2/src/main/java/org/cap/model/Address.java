package org.cap.model;

public class Address {
private String doorno;
private String cityname;
public Address(String doorno, String cityname) {
	super();
	this.doorno = doorno;
	this.cityname = cityname;
}
public Address() {
}
public String getDoorno() {
	return doorno;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cityname == null) ? 0 : cityname.hashCode());
	result = prime * result + ((doorno == null) ? 0 : doorno.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Address other = (Address) obj;
	if (cityname == null) {
		if (other.cityname != null)
			return false;
	} else if (!cityname.equals(other.cityname))
		return false;
	if (doorno == null) {
		if (other.doorno != null)
			return false;
	} else if (!doorno.equals(other.doorno))
		return false;
	return true;
}
public void setDoorno(String doorno) {
	this.doorno = doorno;
}
public String getCityname() {
	return cityname;
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
@Override
public String toString() {
	return "Address [doorno=" + doorno + ", cityname=" + cityname + "]";
}

}

