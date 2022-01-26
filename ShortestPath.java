/*In a GPS navigation system, Given a set of points, the closest-pair problem is to find the two points that are nearest
 to each other.*/
 import java.util.Scanner;
 class ShortestPath{
     public static void main(String args[]){
        println("How many Points You want to Enter : ");
        Scanner scan =new Scanner(System.in);
        int totalPoints=scan.nextInt();
        if(totalPoints<2){
            println("Atleast Take 2 Points.");
            System.exit(0);
        }
        double rows[][]=new double[totalPoints][2];
        // get points
        println("Enter "+totalPoints +" Points");
        for(int i=0;i<rows.length;i++){
            println("Enter "+i+" Points x and y coordinate");
            for(int j=0;j<rows[0].length;j++){
                rows[i][j]=scan.nextDouble();
            }
        }
        scan.close();
        printPoints(rows);
        NavigateDistance Nav =new NavigateDistance(rows);
        Nav.ShortDistance();
     }

     public static void println(Object line){
         System.out.println(line);
     }
     static void printPoints(double[][] mat){
        for(int i=0;i<mat.length;i++){
            println("("+mat[i][0]+","+mat[i][1]+")");
        }
     }
 }
 class NavigateDistance{
    double[][] mat;
    public NavigateDistance(double[][] mat){
        this.mat=mat;
    }
    public void ShortDistance(){
        double ShortDistance=Math.sqrt(Math.pow(mat[1][0]-mat[0][0],2)+Math.pow(mat[1][1]-mat[0][1],2));
        int p=0,q=1;
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat.length;j++){
                double dist=Math.sqrt(Math.pow(mat[j][0]-mat[i][0],2)+Math.pow(mat[j][1]-mat[i][1],2));
                // System.out.println(dist);
                if(dist<ShortDistance){
                    ShortDistance=dist;
                    p=i;q=j;
                }
            }
           
        }
        System.out.println("Cloest Point is: ("+mat[p][0]+","+mat[p][1]+")"+"("+mat[q][0]+","+mat[q][1]+")");
    }
 }
