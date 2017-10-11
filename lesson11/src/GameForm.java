import javax.swing.*;

public class GameForm extends JFrame{
    private JPanel panel;

    public GameForm(){
        setContentPane(panel);
        setBounds(10,20,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
