package Beans;

public class Reader{
    int readerId;
    String name;
    String password;
    String phoneNumber;
    int limits;
    String address;

    public Reader(int readerId,String name,String password,String address,String phoneNumber,int limits){
        this.readerId=readerId;
        this.name=name;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.limits=limits;
        this.address=address;
    }

    public Reader(Reader r){
        this.readerId=r.getReaderId();
        this.name=r.getName();
        this.password=r.getPassword();
        this.phoneNumber=r.getPhoneNumber();
        this.limits=r.getLimits();
        this.address=r.getAddress();
    }

    public int getReaderId(){
        return readerId;
    }

    public void setReaderId(int readerId){
        this.readerId=readerId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public int getLimits(){
        return limits;
    }

    public void setLimits(int limits){
        this.limits=limits;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
