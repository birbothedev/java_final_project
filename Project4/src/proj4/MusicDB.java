package proj4;

import java.sql.*;
import java.util.ArrayList;

public class MusicDB {
    Connection connection;

    private final ArrayList<Artist> artistList = new ArrayList<>();
    private final ArrayList<Album> albumList = new ArrayList<>();

    public MusicDB(){
        try {
            getArtistInfo();
            getAlbumInfo();
        } catch (SQLException e){
            System.out.println("Error loading data: " + e);
        }
    }

    public ArrayList<Artist> getArtistList() {
        return artistList;
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public ArrayList<Album> getAllAlbums(Artist artist){
        ArrayList<Album> getAlbums = new ArrayList<>();
        // loop through albums and only take ones that have the same artist id as the artist
        for (Album album : albumList){
            if (album.getArtistID() == artist.getArtistID()){
                getAlbums.add(album);
            }
        }
        return getAlbums;
    }

    public void getArtistInfo() throws SQLException {
        // got this code from Dr J's lecture video
        connection = getConnection();
        Statement statement = connection.createStatement();
        String artistQuery = "SELECT * FROM Artists";
        ResultSet artists = statement.executeQuery(artistQuery);


        while (artists.next()){
            String name = artists.getString("name");
            int artistID = artists.getInt("ArtistID");

            artistList.add(new Artist(name, artistID));
        }

        artists.close();
        statement.close();
    }

    private void getAlbumInfo() throws SQLException {
        connection = getConnection();
        Statement statement = connection.createStatement();
        String albumQuery = "SELECT * FROM Albums";
        ResultSet albums = statement.executeQuery(albumQuery);

        while (albums.next()){
            String name = albums.getString("name");
            int artistID = albums.getInt("ArtistID");
            int albumID = albums.getInt("AlbumID");

            albumList.add(new Album(name, artistID, albumID));
        }

        albums.close();
        statement.close();
    }

    private Connection getConnection() throws SQLException {
        // got this code from Dr J's lecture video
        String dbUrl = "jdbc:sqlite:music_artists.sqlite";

        // syntax recommended by the ide
        return DriverManager.getConnection(dbUrl);
    }
}
