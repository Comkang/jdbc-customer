package cn.customer.domain;

import java.util.Date;

public class Customer {
    private String id;
    private String customerName;
    private String sex;
    private Date birthday;
    private String email;
    private String hobbies;
    private String type;
    private String remark;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHobbies() {
        return hobbies;
    }
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", customerName=" + customerName + ", sex=" + sex + ", birthday=" + birthday
                + ", email=" + email + ", hobbies=" + hobbies + ", type=" + type + ", remark=" + remark + "]";
    }
    
    
}
