package com.example.shape;

public class Vertex {
    private final int x;
    private final int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Calculates the squared distance between this vertex and another vertex.
     * 
     * @param other the other vertex to calculate the distance to
     * @return the squared distance between this vertex and the other vertex
     */
    public int distanceTo(Vertex other) {
        int dx = this.getX() - other.getX();
        int dy = this.getY() - other.getY();
        return dx * dx + dy * dy;
    }
}
