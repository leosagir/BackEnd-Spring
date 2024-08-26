package lern.spring.users.repository;

import lern.spring.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {

        private final DataSource dataSource;
        private final JdbcTemplate jdbcTemplate;

        @Autowired
    public UserRepositoryJDBCImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<User> USER_ROW_MAPPER = ((row, rowNumber) -> {
        Long id = row.getLong("id");
        String name = row.getString("name");
        String email = row.getString("email");
        String password = row.getString("password");
        return new User(id, name, email, password);
    });


  @Override
    public User save(User user) {

        if(user.getId()==null){
    return createUser(user);
        }else{
    return updateUser(user);
        }
    }

    @Override
    public List<User> findAll() {
    String queryStr = "SELECT * FROM l08_user";
        return jdbcTemplate.query(queryStr, USER_ROW_MAPPER);
    }

    @Override
    public User updateUser(User user) {
        String updateQuery = "UPDATE l08_user SET name = ?, email = ?, password = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(updateQuery,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getId());
        return user;
    }


    @Override
    public User deleteUser(User user) {
        return null;
    }

//    public User save(User user) {
//        String updateQuery = "UPDATE l08_user SET name = ?, email = ?, password = ? WHERE id = ?";
//        int rowsAffected = jdbcTemplate.update(updateQuery,
//                user.getName(),
//                user.getEmail(),
//                user.getPassword(),
//                user.getId());
//
//        if (rowsAffected == 0) {
//            String insertQuery = "INSERT INTO l08_user (id, name, email, password) VALUES (?, ?, ?, ?)";
//            jdbcTemplate.update(insertQuery,
//                    user.getId(),
//                    user.getName(),
//                    user.getEmail(),
//                    user.getPassword());
//        }
// return user;
//}
private User createUser(User user) {
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
    simpleJdbcInsert
    .withTableName("l08_user")
    .usingGeneratedKeyColumns("id");

    Map<String,Object> parametrs = new HashMap<String,Object>();
    parametrs.put("name", user.getName());
    parametrs.put("email", user.getEmail());
    parametrs.put("password", user.getPassword());

    Long generatedId =simpleJdbcInsert.executeAndReturnKey(parametrs).longValue();
    user.setId(generatedId);

    return user;
}
}
