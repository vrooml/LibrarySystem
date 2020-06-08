package Beans;

public class Reader{
    int readerId;
    String name;
    String password;
    int phoneNumber;
    int limits;

    public Reader(int readerId,String name,String password,int phoneNumber,int limits){
        this.readerId=readerId;
        this.name=name;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.limits=limits;
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

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public int getLimits(){
        return limits;
    }

    public void setLimits(int limits){
        this.limits=limits;
    }
}
