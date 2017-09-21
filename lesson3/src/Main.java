public class Main {
    static int add(int a,int b){
        int c=a+b;
        return c;
    }
    static void min(int a,int b){
        if(a<b)
            System.out.println(a);
        else
            System.out.println(b);
    }
    public static void main(String[] args) {
        //int sum=add(1,6);
        //System.out.println(sum);
        //min(12,6);
        Human h=new Human();
        Human h2=h;
        h.name="Vasyan";
        h2.name="Kirill";
        System.out.println(h.name);
        System.out.println(h2.name);
        h.sleep(12);
        Woman w=new Woman();
        w.name="Julia";
        w.cook();
        Man m=new Man("Maksim");
        m.name="Maksim";
        m.cook();
        //h.eyeCount=300;
        Human.eyeCount=400;
        System.out.println(m.eyeCount);
    }
}
