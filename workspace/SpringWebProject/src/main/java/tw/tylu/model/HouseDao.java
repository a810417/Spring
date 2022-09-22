package tw.tylu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public House findById(int houseid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		return session.get(House.class, houseid);
	}

	public List<House> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<House> query = session.createQuery("from House", House.class);
		return query.list();
	}
}
