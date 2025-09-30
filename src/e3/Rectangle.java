package e3;

import java.util.Objects;

public class Rectangle {

    private int base;
    private int height;


    public Rectangle ( int base , int height ) {
        if(base < 0 || height < 0){
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }
        this.base = base;
        this.height = height;
    }

    // Copy constructor
    public Rectangle ( Rectangle r ) {
        this.base = r.base;
        this.height = r.height;
    }

    // Getters
    public int getBase () {
        return this.base;
    }

    public int getHeight () {
        return this.height;
    }

    // Setters . Throw IllegalArgumentException if the parameters are negative .
    public void setBase ( int base ) {
        if(base < 0){
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }
        this.base = base;

    }
    public void setHeight ( int height ) {
        if(height < 0){
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }
        this.height = height;

    }
    // Return true if the rectangle is a square
    public boolean isSquare () {
        if (this.base == this.height ) {
            return true;
        }
        return false;
    }
    // Calculate the area of the rectangle .
    public int area () {
        return (this.base * this.height);
    }
    // Calculate the perimeter of the rectangle .
    public int perimeter () {
        return ((2 * this.base) + (2 * this.height));

    }
    // Calculate the length of the diagonal
    public double diagonal () {
        return (Math.sqrt((this.base * this.base) + (this.height* this.height)));

    }
    // Turn this rectangle 90 degrees ( changing base by height ).
    public void turn () {
        int tmp = this.base;
        this.base = this.height;
        this.height = tmp;

    }
    // Ensure that this rectangle is oriented horizontally ( the base is greater
// or equal than the height ).
    public void putHorizontal () {
        if(this.base < this.height) {
            int tmp = this.base;
            this.base = this.height;
            this.height = tmp;
        }
    }

    // Ensure that this rectangle is oriented vertically ( the height is greater
// or equal than the base ).
    public void putVertical () {
        if (this.base > this.height) {
            int tmp = this.base;
            this.base = this.height;
            this.height = tmp;
        }

    }
    // Two rectangles are equal if the base and the height are the same .
// It does not take into account if the rectangle is rotated .
    public boolean equals ( Object obj ) {

        Rectangle rectangulo = (Rectangle) obj;

        return ((this.base == rectangulo.getBase() && this.height == rectangulo.getHeight())
                || ((this.base == rectangulo.getHeight())&& (this.height == rectangulo.getBase())));
    }

    // It complies with the hashCode contract and is consistent with the equals .
    public int hashCode () {
        return Objects.hash(this.base, this.height);
    }
}
