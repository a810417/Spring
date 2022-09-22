package tw.tylu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {
	
	@Autowired
	private DataSource datasource;

	public House findById(int houseid) throws SQLException {
		Connection conn = datasource.getConnection();
		String sql = "SELECT * FROM House WHERE houseid = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, houseid);
		ResultSet rs = preState.executeQuery();

		House hBean = null;
		if (rs.next()) {
			hBean = new House();
			hBean.setHouseid(rs.getInt("houseid"));
			hBean.setHousename(rs.getNString("housename"));
		}

		rs.close();
		preState.close();
		conn.close();

		return hBean;
	}
}
