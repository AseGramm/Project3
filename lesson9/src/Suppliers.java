public class Suppliers {
    public int id;
    public String adress;
    public String email;
    public String name;
    public String phone;
    public String date_reg;

    @Override
    public String toString() {
        String s = String.format("ID:%d, Name:%s, Email:%s, Adress:%s, Phone:%s, DateReg:%s \n",id,name,email,adress,phone,date_reg);
        return s;
    }
}
