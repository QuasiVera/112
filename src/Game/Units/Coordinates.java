package Game.Units;

public class Coordinates {
    int x, y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public double distanceSearch(Coordinates coord){
//        double x =  this.x - coord.x;
//        double y =  this.y - coord.y;
        double distance = Math.sqrt(Math.pow(deltaCoord(coord)[0],2)+Math.pow(deltaCoord(coord)[1],2));
        return distance;

    }
    public int [] deltaCoord (Coordinates coord){
        int x =  this.x - coord.x;
        int y =  this.y - coord.y;
        return new int []{x,y};
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates coord = (Coordinates) obj;
        return coord.x == this.x && coord.y == this.y;
    }
}
