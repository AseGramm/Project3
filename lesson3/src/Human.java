public class Human {
    protected int age;
    public String name;
    protected float height;
    public static int eyeCount=2;
    public void sleep(int hours){
        System.out.println(name+", I am sleep");
    }
    public void sleep(int hours,int minutes){
        System.out.println("Sleep");
    }
    public void wakeUp(){
        System.out.println("WakeU");
    }
}
