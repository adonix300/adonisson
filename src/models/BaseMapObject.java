package models;

public class BaseMapObject {
    private int x;
    private int y;
    private String icon;

    public BaseMapObject(int x,int y, String icon) {
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }


}
