package com.example;

import java.util.Random;

public class Node implements Vertex {
    private static final Random random = new Random();
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mutate() {
        x += (random.nextInt(-20, 20));
        y += (random.nextInt(-20, 20));
    }
}
