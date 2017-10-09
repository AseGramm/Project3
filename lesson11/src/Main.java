import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login lf = new Login();
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setVisible(true);
        lf.setBounds(10,10,450,300);
    }
}
