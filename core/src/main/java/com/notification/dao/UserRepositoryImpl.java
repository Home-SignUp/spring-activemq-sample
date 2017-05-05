package com.notification.dao;

import com.notification.model.User;
import com.notification.model.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=:id",
            FIND_ALL_QUERY = "SELECT * FROM users",
            INSERT_QUERY = "INSERT INTO users (id,publicId) VALUES (:id,:publicId)", //INSERT_QUERY = "INSERT INTO users (id,publicId,status) VALUES (:id,:publicId,:status)",
            UPDATE_QUERY = "UPDATE users SET publicId=:publicId WHERE id=:id"; //UPDATE_QUERY = "UPDATE users SET publicId=:publicId,status=:status WHERE id=:id";

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void putUser(User user) {
        Map namedParameters = new HashMap();
        namedParameters.put("id", user.getId());
        namedParameters.put("publicId", Integer.valueOf(user.getPublicId()));
//        namedParameters.put("status", user.getStatus().getName());
        namedParameterJdbcTemplate.update(INSERT_QUERY, namedParameters);
    }

    @Override
    public void updateUser(User user) {
        Map namedParameters = new HashMap();
        namedParameters.put("id", user.getId());
        namedParameters.put("publicId", Integer.valueOf(user.getPublicId()));
//        namedParameters.put("status", user.getStatus().getName());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);
    }

    @Override
    public User getUser(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        User result = namedParameterJdbcTemplate.queryForObject(FIND_BY_ID_QUERY, params, new UserMapper());

        return result;
    }

    @Override
    public Map<String, User> getAllUsers() {
        Map<String, User> params = new HashMap<String, User>();
        List<User> result = namedParameterJdbcTemplate.query(FIND_ALL_QUERY, params, new UserMapper());

        Map<String, User> users = new HashMap<String, User>();
        for (User user : result)
            users.put(user.getId(), user);

        return users;
    }

    private static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setPublicId(rs.getInt("publicId"));
//            user.setStatus(NotificationStatus.valueOf(rs.getString("status")));

            return user;
        }
    }
}
