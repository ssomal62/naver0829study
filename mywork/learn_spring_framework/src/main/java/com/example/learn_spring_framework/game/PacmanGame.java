package com.example.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{

    @Override
    public void up() {
        System.out.println("PMGame up!");
    }

    @Override
    public void down() {
        System.out.println("PMGame down!");
    }

    @Override
    public void left() {
        System.out.println("PMGame left!");
    }

    @Override
    public void right() {
        System.out.println("PMGame right!");
    }
}
