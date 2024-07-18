package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.TheaterDTO;

public class TheaterDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public TheaterDAO() {
		conn = DBConnection.getConnection();
	}

	public ArrayList<TheaterDTO> getTheaterByTheaterName(String theaterName) {
		// TODO Auto-generated method stub
		return null;
	}
}
