import java.awt.Font;
public class Animation {
    public static void runAnimation() {
        int n = 60;

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(15,255,80);
        StdDraw.enableDoubleBuffering();
        Font font = new Font("Arial", Font.BOLD, 10);
        StdDraw.setFont(font);




        int[][] grid = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j =0; j<n; j++){
                grid[i][j]= (int)(Math.random()*2);
            }
        }

        drawRows(grid);

        while (true){

            grid=getNewState(grid);
            drawRows(grid);
            StdDraw.clear(StdDraw.BLACK);
        }





    }
    public static int[][] getNewState(int[][] grid){
        int[][] a = new int[grid.length][grid.length];

        for (int i=1; i< grid.length; i++){
            for (int j =0; j< grid.length; j++){
                a[i][j]=grid[i-1][j];
            }
        }

        for (int i=0; i<a.length; i++){
            a[0][i]=(int)(Math.random()*2);
        }

        return a;
    }
    public static void drawRows(int[][] grid){
        for (int i=0; i< grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                if (grid[i][j] == 1) {
                    StdDraw.text(.5+j, .5+i, "1");
                }
                else StdDraw.text(.5+j, .5+i, "0");
            }
        }

        StdDraw.show();
        StdDraw.pause(80);
        }
}
