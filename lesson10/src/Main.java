import javax.swing.*;
import java.awt.*;

public class Main {
    public static void setAbsoluteLayout(JFrame f){//Таблица
        Container c = f.getContentPane();
        c.setLayout(null);
        JButton button1 = new JButton("Press me1");
        button1.setSize(150,30);
        button1.setLocation(70,50);
        JButton button2 = new JButton("Press me2");
        button2.setSize(160,30);
        button2.setLocation(70,100);
        JButton button3 = new JButton("Press me3");
        button3.setSize(110,30);
        button3.setLocation(100,150);
        c.add(button1);
        c.add(button2);
        c.add(button3);
    }

    public static void setGridLayout(JFrame f) throws InterruptedException {//Таблица
        Container c = f.getContentPane();
        GridLayout gl = new GridLayout(13,1);
        c.setLayout(gl);

        JLabel label = new JLabel("Hello world");
        JTextField textField = new JTextField("textField");
        JPasswordField passwordField = new JPasswordField("passwordField");
        //String pass = new String(passwordField.getPassword());//Запись пароля
        JProgressBar progressBar = new JProgressBar();
        //progressBar.setMaximum(200);//Конечное значение
        //progressBar.setMinimum(-200);//Начальное значение
        progressBar.setValue(50);//Начальное положение
        JSlider slider = new JSlider();
        slider.setValue(75);
        slider.setToolTipText("Не трогать");//Всплывающий текст
        JCheckBox checkBox = new JCheckBox("Hello");
        checkBox.setSelected(true);//Установить да или нет
        //checkBox.isSelected();//Возвращает выбрано или нет
        JRadioButton radioButton1 = new JRadioButton("Hello1");
        JRadioButton radioButton2 = new JRadioButton("Hello2");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        radioButton2.setSelected(true);//Установить да или нет
        //radioButton2.isSelected();//Возвращает выбрано или нет
        JPanel panel = new JPanel();//Контейнер
        panel.setBackground(Color.GRAY);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuAbout = new JMenu("About");
        JMenuItem menuNew = new JMenuItem("New");
        JMenuItem menuOpen = new JMenuItem("Open");
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        f.add(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuAbout);
        menuFile.add(menuNew);
        menuFile.add(menuOpen);
        menuFile.add(menuEdit);
        menuEdit.add(copyItem);
        menuEdit.add(pasteItem);


        f.add(label);
        f.add(textField);
        f.add(passwordField);
        f.add(progressBar);
        f.add(slider);
        f.add(checkBox);
        f.add(radioButton1);
        f.add(radioButton2);
        f.add(panel);
    }

    public static void setFlowLayout(JFrame f){//В строку с авто-переносом
        Container c = f.getContentPane();
        FlowLayout fl = new FlowLayout();
        c.setLayout(fl);
        JButton button1 = new JButton("Press me1");
        JButton button2 = new JButton("Press me2");
        JButton button3 = new JButton("Press me3");
        JButton button4 = new JButton("Press me4");
        JButton button5 = new JButton("Press me5");
        c.add(button1);
        c.add(button2);
        c.add(button3);
        c.add(button4);
        c.add(button5);
    }

    public static void setBorderLayout(JFrame f){//Стороны света
        Container c = f.getContentPane();
        BorderLayout bl = new BorderLayout();
        c.setLayout(bl);
        JButton button1 = new JButton("Press me1");
        JButton button2 = new JButton("Press me2");
        JButton button3 = new JButton("Press me3");
        JButton button4 = new JButton("Press me4");
        JButton button5 = new JButton("Press me5");
        c.add(button1,BorderLayout.WEST);
        c.add(button2,BorderLayout.EAST);
        c.add(button3,BorderLayout.NORTH);
        c.add(button4,BorderLayout.SOUTH);
        c.add(button5,BorderLayout.CENTER);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Swing");
        frame.setSize(300,400);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.setResizable(false);//Отключение изменения размера окна

        //setBorderLayout(frame);
        //setFlowLayout(frame);
        setGridLayout(frame);
        //setAbsoluteLayout(frame);

        frame.setVisible(true);
    }
}
