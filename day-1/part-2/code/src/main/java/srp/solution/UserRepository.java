package srp.solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(User user) {

    }

    public User findByEmail(String email) throws SQLException {
        String sql = "select * from user where email = " + email;
        User user = new User();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
        }
        return user;
    }

}
