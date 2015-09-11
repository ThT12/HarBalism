package main.dbconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.java.app.area.AreaSize;
import main.java.app.area.HarvestArea;
import main.java.app.area.HarvestAreas;
import main.java.app.hiking.Hiking;
import main.java.app.hiking.Hikings;
import main.java.app.plant.Plant;

public class DbHikings {
	Hikings hikings;
	

	public DbHikings(String userName) throws Exception{
		Statement stmt = DbConnector.createDbConnector();
		ResultSet rs = stmt.executeQuery("SELECT DISTINCT plant.id_plant,plant.name_plant,plant.start_harvest_date,plant.end_harvest_date "
				+ "FROM plant INNER JOIN harvest_area ON plant.id_plant = harvest_area.id_plant "
				+ "INNER JOIN hiking_to_area ON harvest_area.id_harvest_area = hiking_to_area.id_harvest_area "
				+ "INNER JOIN hiking ON hiking_to_area.id_hiking = hiking.id_hiking "
				+ "INNER JOIN user ON hiking.id_user = user.id_user  "
				+ "WHERE user.name_user ='" + userName +"'");

		Map<Integer, Plant> plantList = new HashMap<Integer, Plant>();
		
		while (rs.next()) {
			Plant plant = new Plant(rs.getString("name_plant"),rs.getString("start_harvest_date"), rs.getString("end_harvest_date"));
			plantList.put(rs.getInt("id_plant"), plant);
		}
		
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		
		
		rs = stmt.executeQuery("SELECT * FROM hiking INNER JOIN  user ON hiking.id_user = user.id_user "
				+ "WHERE user.name_user ='" + userName +"'");
		
		Map<Integer, Hiking> hikingList = new HashMap<Integer, Hiking>();
		
		while (rs.next()) {
			Hiking hiking = new Hiking(rs.getString("hiking_name"));
			hikingList.put(rs.getInt("id_hiking"), hiking);
		}
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		
		
		rs = stmt.executeQuery("SELECT DISTINCT harvest_area.name_harvest_area, harvest_area.id_plant,"
				+ "harvest_area.size,harvest_area.disponibility, harvest_area.latitude, harvest_area.longitude,"
				+ "hiking_to_area.id_hiking FROM harvest_area "
				+ "INNER JOIN hiking_to_area ON harvest_area.id_harvest_area = hiking_to_area.id_harvest_area "
				+ "INNER JOIN hiking ON hiking_to_area.id_hiking = hiking.id_hiking "
				+ "INNER JOIN user ON hiking.id_user = user.id_user  "
				+ "WHERE user.name_user ='" + userName +"'");
		
		HarvestAreas has = new HarvestAreas();
		
		while (rs.next()) {
			
			HarvestArea ha = new HarvestArea(rs.getString("name_harvest_area"),rs.getDouble("latitude"),rs.getDouble("longitude"), 
					AreaSize.valueOf(rs.getString("size")),
					rs.getDouble("disponibility"), plantList.get(rs.getInt("id_plant")), hikingList.get(rs.getInt("id_hiking")));
			has.addHarvestArea(ha);
			hikingList.get(rs.getInt("id_hiking")).addHarvestArea(ha);
		}
		try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		
		Hikings hikings = new Hikings();
		for (Entry<Integer, Hiking> entry : hikingList.entrySet()) {
			hikings.addHiking(entry.getValue());
		}
		
		this.hikings = hikings;
	}
	
	public Hikings getHikings() {
		return hikings;
	}

	public void setHikings(Hikings hikings) {
		this.hikings = hikings;
	}
}
