package proj4;

public class Artist {

    private final String name;
    private final int artistID;

    public Artist(String name, int artistID){
        this.name = name;
        this.artistID = artistID;
    }

    public String getName(){
        return name;
    }

    public int getArtistID() {
        return artistID;
    }

    @Override
    public String toString(){
        return name;
    }
}
