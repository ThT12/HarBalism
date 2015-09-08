package main.dbconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.dbconnect.DbConnector;

public class DbPlant {
	private String name;
	private String startHarvestDate;
	private String endHarvestDate;


	public DbPlant(int id_plant) throws SQLException{
		Statement stmt = DbConnector.createDbConnector();
		ResultSet rs = stmt.executeQuery("SELECT * FROM plant WHERE id_plant = " + id_plant);

		if (!rs.isBeforeFirst()) {
			this.setName("Plant Not Found");
			this.setStartHarvestDate("01/01");
			this.setEndHarvestDate("12/31");
		}
		else {
			rs.first();
			this.setName(rs.getString("name_plant"));
			this.setStartHarvestDate(rs.getString("start_harvest_date"));
			this.setEndHarvestDate(rs.getString("end_harvest_date"));

			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartHarvestDate() {
		return startHarvestDate;
	}

	public void setStartHarvestDate(String startHarvestDate) {
		this.startHarvestDate = startHarvestDate;
	}

	public String getEndHarvestDate() {
		return endHarvestDate;
	}

	public void setEndHarvestDate(String endHarvestDate) {
		this.endHarvestDate = endHarvestDate;
	}
}
