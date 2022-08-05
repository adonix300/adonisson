package models;

public class GameMap {
    private String[][] pole;

    public GameMap(int n) {
        this.createMap(n);
    }

    public void createMap(int n){
        String[][] pole = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pole[i][j] = "|__";
            }
        }

        this.pole = pole;
    }
    public void printMap() {

        for (String[] strings : pole) {

            for (int j = 0; j < pole.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }
    }



    public String[][] getPole() {
        return pole;
    }

    public void setValue(int y,int x, String d){
        pole[y][x] = d;
    }

}
