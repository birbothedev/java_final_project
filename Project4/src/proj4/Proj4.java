package proj4;


public class Proj4 {
    public static void main(String[] args) {

        MusicDB musicDB = new MusicDB();

        System.out.println("\n");
        System.out.println("Artist and Album Listing\n");
        System.out.println("Artists");
        System.out.println("--------------------");

        for (Artist artist : musicDB.getArtistList()){
            System.out.println(artist);
        }

        System.out.println("\n");
        System.out.println("Albums");
        System.out.println("--------------------");

        for (Album album : musicDB.getAlbumList()){
            System.out.println(album);
        }

        System.out.println("\n");
        System.out.println("Albums by Artist");
        System.out.println("--------------------");

        for (Artist artist : musicDB.getArtistList()){
            System.out.println(artist);
            for (Album album : musicDB.getAllAlbums(artist)){
                System.out.println("\t" + album);
            }
        }
    }
}