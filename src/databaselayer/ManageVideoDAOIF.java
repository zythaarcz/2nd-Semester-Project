package databaselayer;

import java.sql.SQLException;

import modellayer.Video;

public interface ManageVideoDAOIF {
	Video retrieveVideo(int id) throws SQLException;
}
