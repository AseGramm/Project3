import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame{
    private JPanel panel1;
    private JTextField login;
    private JTextField password;
    private JButton inButton;
    private JButton regButton;

    public Login() throws SQLException, ClassNotFoundException {
        JdbcConnection.init();

        setContentPane(panel1);

        inButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = Login.this.login.getText();
                String password = Login.this.password.getText();
                try {
                    PlayersRep pRep = new PlayersRep();
                    pRep.login(login,password);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
