package models;

public class Boss extends BaseMapObject {
    private int health;

    public Boss(int x, int y, String icon, int health) {
        super(x, y, icon);
        this.health = health;
    }

    public void setHealth(int health) {
        this.health = health;

    }
    public int getHealth(){
        return health;
    }
}
