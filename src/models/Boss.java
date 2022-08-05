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

    public void moveBoss(int n) {
        boolean isMoved = false;
        while (!isMoved) {
            int x = getX() + (int) ((Math.random() * 4) - 2);
            int y = getY() + (int) ((Math.random() * 4) - 2);
            if (y < n && y > 0 && x < n && x > 0) {
                isMoved = true;
                setX(x);
                setY(y);
            }
        }
    }
}
