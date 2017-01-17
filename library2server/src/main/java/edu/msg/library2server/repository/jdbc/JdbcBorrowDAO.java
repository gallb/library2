package edu.msg.library2server.repository.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;

import edu.msg.library2common.model.BaseEntity;
import edu.msg.library2common.model.Borrow;
import edu.msg.library2common.model.Publication;
import edu.msg.library2common.model.User;
import edu.msg.library2common.service.ServiceException;
import edu.msg.library2common.util.PropertyProvider;
import edu.msg.library2server.repository.BorrowDAO;
import edu.msg.library2server.util.PasswordEncrypter;

public class JdbcBorrowDAO implements BorrowDAO{
	private SqlHandler conMan;
	private Connection con = null;
	private PreparedStatement preparedStatement;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserDao.class);
	
	public JdbcBorrowDAO(){
		conMan = SqlHandler.getInstance();
	}
	
	public <X extends BaseEntity> List<X> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> List<X> getByName(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X extends BaseEntity> boolean insert(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> boolean update(X e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public <X extends BaseEntity> X getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertBorrow(User user, Publication pub) {
		boolean returnStatus = false;
	
		try {
			con = conMan.getConnection();
			System.out.println(con.isClosed());
			String sqlCommand = "insert into borrows (user_id, publication_id, borrow_from, borrow_until) "
					+ "values (?, ?, ?, ?)";

			preparedStatement = con.prepareStatement(sqlCommand);
			preparedStatement.setString(1, user.getUuid());
			preparedStatement.setString(2, pub.getUuid());
			
			preparedStatement.setDate(3, new Date(2017, 01, 10));
			preparedStatement.setDate(4, new Date(2017, 01, 20));
			
			preparedStatement.executeUpdate();

			LOGGER.info("User inserted!");
			returnStatus = true;
		} catch (SQLException e) {
			LOGGER.error(PropertyProvider.INSTANCE.getProperty("error.logger.jdbc_user_dao_insert"), e);
			throw new ServiceException(PropertyProvider.INSTANCE.getProperty("error.jdbc_user_dao"));
		}
		return returnStatus;
	}

}
