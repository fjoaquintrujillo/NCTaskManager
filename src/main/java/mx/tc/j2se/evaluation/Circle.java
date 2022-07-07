package mx.tc.j2se.evaluation;

public class Circle {
    int radius;
    public Circle(){
        radius = 1;
    };
    public Circle(int radius) throws Exception {
            if (radius > 0) {
                this.radius = radius;
            } else {
                throw new Exception("The radius have to be bigger than zero!");
            }
    }

    protected void setRadius(int radius) throws Exception{
            if (radius > 0) {
                this.radius = radius;
            } else {
                throw new Exception("The radius have to be bigger than zero!");
            }
    }

    protected int getRadius(){
        return radius;
    }

    protected double getArea(){
        return Math.PI*radius*radius;
    }



    private class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }
}
