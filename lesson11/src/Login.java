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
                    return;
                }
                GameForm gameForm = null;
                try {
                    gameForm = new GameForm();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                gameForm.setVisible(true);
                setVisible(false);
            }
        });
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                try {
                    RegistratoinForm registratoinForm = new RegistratoinForm();
                    registratoinForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    registratoinForm.setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
