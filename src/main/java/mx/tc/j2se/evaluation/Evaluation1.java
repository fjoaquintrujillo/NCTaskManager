package mx.tc.j2se.evaluation;


public class Evaluation1 {
    public static int biggestCircle(Circle circles[]){
        double biggest=1;
        int bindex=0;
        for(int x=0; x< circles.length;x++){
            if(circles[x].getArea()>biggest){
                biggest=circles[x].getArea();
                bindex=x;
            };
        }
        return bindex;


    }

    public static void main(String[] args) {
        // Invalid circle
        Circle ca = new Circle(-5);
        //Array of three valid Circles
        Circle c0 = new Circle(4);
        Circle c1 = new Circle(9);
        Circle c2 = new Circle(5);

        Circle circles[] = new Circle[3];
        circles[0]=c0;
        circles[1]=c1;
        circles[2]=c2;

        int indexC = biggestCircle(circles);
        System.out.println("The biggest circle index is: "+indexC+ " and its radius is: "+circles[indexC].getRadius() );

    }
}
