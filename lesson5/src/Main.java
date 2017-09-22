import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception{
        File f=new File("1.txt");
        if(!f.exists()){//Проверка на наличие файла или директории
            f.createNewFile();
        }
        if(f.canWrite()){//Проверка на возможность записи в файл
            System.out.println("Файл доступен для записи");
        }
        else{
            System.out.println("Файл не доступен для записи");
        }
        if(f.isHidden()){//Проверка на скрытость файла
            System.out.println("Файл скрытый");
        }
        else{
            System.out.println("Файл не скрыт");
        }
        //f.delete();//Удаление файла
        System.out.println(f.getAbsolutePath());//Возврат абсолютного пути к файлу
        System.out.println(f.getFreeSpace());//Возвращает кол-во свободных байт на данном разделе диска(где сам файл)
        if(f.isFile()){//True если это файл, False если это директория(f.isDirectory() работает наоборот)
            System.out.println("Это файл");
        }
        else{
            System.out.println("Это директория");
        }
        System.out.println(f.lastModified());//Кол-во милисекунд с 01.01.1970
        System.out.print("Размер файла:");
        System.out.println(f.length());//Возвращает размер файла
        File f2=new File("2.txt");
        /*if(!f.renameTo(f2)){//Переименовывает файл
            System.out.println("Переименовате не удалось");
        }
        System.out.println(f.getAbsolutePath());//???*/
        f.setWritable(true);//True - доступен для записи, False - не доступен для записи
        f.setLastModified(0);//Устанавливает время последнего изменения
        File dir=new File("test\\");
        if(!dir.exists()){
            dir.mkdir();//Cоздаёт каталог(dir.mkdirs создаёт путь из папок)
        }
        /*dir.list();//Возвращает все файлы в папке String[]
        dir.listFiles();//Возвращает все файлы в папке File[] */
        File[] files=dir.listFiles();
        for(int i=0;i<files.length;i++){
            files[i].setWritable(true);
        }

        String s="hello world!";
        s=s.concat(" Hi");//Добавление "Hi" в конец строки s(объединение строк)
        System.out.println(s);
        s="<"+s+">";//Объединение строк 2
        System.out.println(s);
        if(s.indexOf("!")>=0){//Поиск подстроки в строке
            System.out.println("! есть");
        }
        if(s.equals("<hello world! Hi>")){//Сравнение строк
            System.out.println("Строки равны");
        }
        if(s.equalsIgnoreCase("<heLLo world! Hi>")){//Сравнение строк с игнорирование регистра
            System.out.println("Строки равны");
        }
        System.out.println(s.toUpperCase());//Меняет на верхний регистр всю строку
        System.out.println(s.toLowerCase());//Меняет на нижний регистр всю строку
        String format=String.format("My name is %s. I have %d year old. My height is %.2f cm","Vasya",26,178.5f);//Форманирование как в printf в Си %s-строка, %d-целое число, %f-вещественное число, %c-символ
        System.out.println(format);
    }
}
