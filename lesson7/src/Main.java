import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    //Сериализация
    public static void writeUserToFile(User[] users,String fileName) throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        for(int i=0;i<users.length;i++){
            oos.writeObject(users[i]);
        }
        oos.close();
        fos.close();
    }
    //Десериализация
    public static void showUsers(String fileName) throws IOException {
        FileInputStream fis=new FileInputStream(fileName);
        ObjectInputStream ois=new ObjectInputStream(fis);
        while(true){
            Object obj= null;
            try {
                obj = ois.readObject();
            }
            catch (Exception e) {
                break;
            }
            User u=(User)obj;
            System.out.print(u.id);
            System.out.println(" "+u.name);
        }
        ois.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u=new User();
        u.id=100;
        u.name="User 100";
        User u2=new User();
        u2.id=200;
        u2.name="User 200";
        User[] users={u,u2};
        //writeUserToFile(users,"users.txt");
        //showUsers("users.txt");

        /*String s=String.valueOf(123);
        System.out.println(s);
        float f=Float.parseFloat("12.3f");
        System.out.println(f*2);*/

        //Коллекции
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(12);
        list.add(0,10);
        list.add(15);
        list.add(20);
        list.add(20);
        System.out.println(list);
        Integer k=20;
        list.remove(k);//По элементу
        System.out.println(list);
        list.remove(2);//По номеру элемента
        System.out.println(list);
        System.out.println(list.get(1));//Вывод элемента коллекции по его номеру
        System.out.println(list.size());//Количетво элементов в коллекции

        for(Integer i:list){
            System.out.println(i*i);
        }

        HashSet<String> set=new HashSet<String>();//Коллекция (множество) без повторений (вызов по названию объекта)
        set.add("hello");
        set.add("world");
        set.add("helloNew");
        set.add("zzz");
        System.out.println(set);

        HashMap<String,Integer> map =new HashMap<String, Integer>();//Коллекция ключ-значение (вызов по ключу)
        map.put("Ivanov",123465);
        map.put("Petrov",789456);
        map.put("Ivanov",456123);
        System.out.println(map);
        System.out.println(map.get("Ivanov"));
        map.remove("Ivanov");
        System.out.println(map);

        //TreeSet Коллекция в виде бинарного дерева
    }
}
