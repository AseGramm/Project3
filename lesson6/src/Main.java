import java.io.*;

public class Main {
    public static void goToWork(IWorker employer){
        employer.goToWork();
    }
    public static void pay(IWorker employer){
        employer.pay();
    }
    public static void main(String[] args) throws IOException {
        /*User u=new User();
        //Object o=new Object();
        u.id=10;
        u.name="Vasya";
        u.height=170.5f;
        User u2=new User();
        u2.id=10;
        u2.name="Kolya";
        u2.height=180.5f;
        System.out.println(u.hashCode());
        System.out.println(u2.hashCode());
        if(u.equals(u2)){
            System.out.println("Объекты совпадают");
        }
        System.out.println(u);
        System.out.println(u2.toString());*/

        Boss b=new Boss();
        Worker w=new Worker();
        Cleaner c=new Cleaner();
        //w.goToWork();
        //w.pay();
        goToWork(w);
        goToWork(b);
        goToWork(c);

        //Читаем данные из текстового файла
        /*File f=new File("1.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);*/
        BufferedReader br=new BufferedReader(new FileReader(new File("1.txt")));
        String content="";
        while(true){
            String s=br.readLine();//Читает до первого Enter
            if(s==null){//Проверка на конец файла
                break;
            }
            content+=s+"\n";
        }
        content+="Hello";
        PrintWriter writer=new PrintWriter("1.txt","UTF-8");
        writer.println(content);
        writer.close();


    }
}
