package databaselayer;

import java.sql.SQLException;

import modellayer.Video;

public interface UpdateVideoDAOIF {
	void updateVideo(int id, String header, String shortDescription, String category, int pointsForCompletion);

}
