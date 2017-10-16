import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayersRep {
    public static int playerId;

    public void login(String login, String password) throws Exception {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT id FROM players WHERE login = ? AND pass_hash = ?");
        ps.setString(1,login);
        ps.setString(2,password);
        ResultSet result = ps.executeQuery();
        if(result.next()==false){
            throw new Exception("Неверен логин или пароль");
        }
        PlayersRep.playerId = result.getInt("id");
    }
    public void register(Player player) throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO players(login,pass_hash,age) VALUES(?,?,?)");
        ps.setString(1,player.login);
        ps.setString(2,player.pass_hash);
        ps.setInt(3,player.age);
        ps.executeUpdate();
        ResultSet result = ps.getGeneratedKeys();
        PlayersRep.playerId = result.getInt(1);
    }
}
