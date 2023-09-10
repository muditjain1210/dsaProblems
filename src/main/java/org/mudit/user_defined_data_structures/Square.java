package org.mudit.user_defined_data_structures;

public class Square {

    int x;
    int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Square [x=" + x + ", y=" + y + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Square other = (Square) obj;
        if (x != other.x)
            return false;
        return y == other.y;
    }

}
