package models;

public class Hero extends BaseMapObject {
    private int health;
    public Hero(int x,int y, String icon, int health) {
        super(x,y,icon);
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

}
