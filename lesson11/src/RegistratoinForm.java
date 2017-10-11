import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegistratoinForm extends JFrame{
    private JPanel panel1;
    private JTextField loginRegField;
    private JTextField ageRegField;
    private JButton enterRegButton;
    private JPasswordField passRegField;
    private JPasswordField passRegField2;

    public RegistratoinForm() throws SQLException, ClassNotFoundException {
        setContentPane(panel1);
        setBounds(10,10,450,250);
        enterRegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(RegistratoinForm.this.passRegField.getPassword());
                String repitePassword = new String(RegistratoinForm.this.passRegField2.getPassword());
                if(RegistratoinForm.this.loginRegField.getText().length()==0|| RegistratoinForm.this.passRegField.getPassword().length==0){
                    JOptionPane.showMessageDialog(null,"Все поля должны быть заполнены","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(password.equals(repitePassword)==false){
                    JOptionPane.showMessageDialog(null,"Пароли должны совпадать","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String ageString = RegistratoinForm.this.ageRegField.getText();
                int age;
                try{
                    age = Integer.parseInt(ageString);

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Возраст указан неверно","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(age<4||age>99){
                    JOptionPane.showMessageDialog(null,"Возраст должен быть от 4 до 99","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Player player = new Player();
                player.login = RegistratoinForm.this.loginRegField.getText();
                player.pass_hash = password;
                player.age = age;
                PlayersRep playersRep = new PlayersRep();
                try {
                    playersRep.register(player);
                } catch (SQLIntegrityConstraintViolationException e1) {
                    JOptionPane.showMessageDialog(null,"Пользователь с таким логином уже существует","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null,"Ошибка регистрации","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                GameForm gameForm = new GameForm();
                gameForm.setVisible(true);
                setVisible(false);
            }
        });
    }
}
