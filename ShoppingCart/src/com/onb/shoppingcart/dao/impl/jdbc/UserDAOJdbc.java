package com.onb.shoppingcart.dao.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onb.shoppingcart.dao.UserDAO;
import com.onb.shoppingcart.domain.Role;
import com.onb.shoppingcart.domain.User;

@Repository("userDAO")
public class UserDAOJdbc extends AbstractDAOJdbc implements UserDAO {
	private static final String INSERT = "INSERT INTO users(username,password,role_id) VALUES(?,?,?)";
	private static final String SELECT_USER_BY_USERNAME = "SELECT u.id,u.username,u.password,u.role_id,r.role_type FROM users AS u,roles AS r WHERE u.username=? AND u.role_id = r.id";

	@Override
	public void create(User user) {
		Object[] params = {user.getUsername(), user.getPassword(), user.getRole().getId()};
		synchronized (insertionLock) {
			getJdbcTemplate().update(INSERT, params);
			user.setId(getLastInsertId());
		}
	}

	@Override
	public User getUserByUsername(String username) {
		Object[] params = {username.trim()};
		return getJdbcTemplate().queryForObject(SELECT_USER_BY_USERNAME, params, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User u = new User();
				Role r = new Role();
				u.setRole(r);
				u.setId(rs.getInt("u.id"));
				u.setUsername(rs.getString("u.username"));
				u.setPassword(rs.getString("u.password"));
				r.setId(rs.getInt("u.role_id"));
				r.setRoleType(rs.getString("r.role_type"));
				return u;
			}
			
		});
	}

	@Override
	protected String getTableName() {
		return "users";
	}

}
