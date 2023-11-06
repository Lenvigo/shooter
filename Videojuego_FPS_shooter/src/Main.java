import java.sql.Array;

public class Main {
    public static void main(String[] args) {
    }

    public static int getDamage (int speed, int armor, int distance){

        if (distance<=3   || (speed>500 && distance<20)){
          return speed/10;
        }
        if (speed>500 && distance>20){
            return Math.max((speed/10)-armor,0);
        } return Math.max((speed/10)-(armor+(distance/10)), 0);

    }

    /* la funcion siguiente es lo mismo simplificado
    public static boolean isDeadByBodyShot(int life, int damage){
        if (damage-life<=0)
        {return true;} return false;
    }*/

    public static boolean isDeadByBodyShot(int life, int damage){
        return life - damage <= 0;
    }

    public static int getNumObjects(boolean[][]map){
        int contador=0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]) {
                    contador++;
                }
            }
        } return contador;
    }

    public static boolean isHit(boolean[][] screen, int y, int x){
       return screen[y][x];
    }

    public static boolean isHeadShot(boolean [][] screen, int y, int x){

        return (screen[y][x-1]) && (screen[y][x]) && (screen[y][x+1]) &&
                (y==0 || (!screen[y-1][x])) ;
    }

    public static int[] getEnemyPosition( boolean[][] screen){
         int [] enemigo = {0,0};

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                if (screen[i][j]) {
                    enemigo[0]=i+2;enemigo[1]=j+1;
                    return enemigo;
                }

            }


        }return enemigo;
    }
}