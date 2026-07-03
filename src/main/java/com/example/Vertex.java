package com.example;

public interface Vertex {
    /**
     * Returns the x-coordinate of the vertex.
     * 
     * @return the x-coordinate of the vertex
     */
    double getX();

    /**
     * Returns the y-coordinate of the vertex.
     * 
     * @return the y-coordinate of the vertex
     */
    double getY();

    /**
     * Calculates the squared distance between this vertex and another vertex.
     * 
     * @param other the other vertex to calculate the distance to
     * @return the squared distance between this vertex and the other vertex
     */
    default double distanceTo(Vertex other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        return dx * dx + dy * dy;
    }

}
