package Game;

public class Location {
    int currentX;
    int currentY;
    public Location(int x,int y){
        currentX=x;
        currentY=y;
    }
    public int getY(){
        return currentY;
    }
    public int getX(){
        return currentX;
    }

    public void setCurrentX(int x) {
        currentX = x;
    }

    public void setCurrentY(int y) {
        currentY = y;
    }
}