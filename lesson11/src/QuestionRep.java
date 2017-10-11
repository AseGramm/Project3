import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionRep {
    public ArrayList<Question> getQuestions() throws SQLException {
        Connection con = JdbcConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM questions");
        ResultSet result = ps.executeQuery();
        ArrayList<Question> questions = new ArrayList<Question>();
        while(result.next()){
            Question question = new Question();
            question.id = result.getInt("id");
            question.words = result.getString("words").split(";");
            question.answer = result.getString("answer");
            question.answer_img = result.getString("answer_img");
            questions.add(question);
        }
        return questions;
    }
}
