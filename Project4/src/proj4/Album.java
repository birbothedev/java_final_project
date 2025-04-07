package proj4;


public class Album {

    private final String name;
    private final int artistID;
    private final int albumID;

    public Album(String name, int artistID, int albumID){
        this.name = name;
        this.artistID = artistID;
        this.albumID = albumID;
    }

    public int getArtistID(){
        return artistID;
    }

    @Override
    public String toString(){
        return name;
    }
}
