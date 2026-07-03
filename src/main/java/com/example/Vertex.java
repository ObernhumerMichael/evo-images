package com.example;

public interface Vertex extends Gene {
    /**
     * Returns the x-coordinate of the vertex.
     * 
     * @return the x-coordinate of the vertex
     */
    int getX();

    /**
     * Returns the y-coordinate of the vertex.
     * 
     * @return the y-coordinate of the vertex
     */
    int getY();

    /**
     * Sets the x-coordinate of the vertex to the specified value.
     * 
     * @param x
     */
    void setX(int x);

    /**
     * Sets the y-coordinate of the vertex to the specified value.
     * 
     * @param y
     */
    void setY(int y);

    /**
     * Calculates the squared distance between this vertex and another vertex.
     * 
     * @param other the other vertex to calculate the distance to
     * @return the squared distance between this vertex and the other vertex
     */
    default int distanceTo(Vertex other) {
        int dx = this.getX() - other.getX();
        int dy = this.getY() - other.getY();
        return dx * dx + dy * dy;
    }

}
