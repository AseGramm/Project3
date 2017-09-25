public class User {
    public int id;
    public String name;
    public float height;

    @Override
    public boolean equals(Object obj) {
        //super.equals()//super обращение к родителю
        User user2=(User)obj;
        return this.id==user2.id;
    }
    @Override
    public int hashCode(){
        return 123;
    }
    @Override
    public String toString() {
        return String.format("[%d] Name:%s Height:%.2f",id,name,height);
        //return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
