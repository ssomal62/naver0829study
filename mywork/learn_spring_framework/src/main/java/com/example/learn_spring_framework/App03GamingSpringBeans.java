package com.example.learn_spring_framework;
import com.example.learn_spring_framework.game.GameRunner;
import com.example.learn_spring_framework.game.GamingConsole;
import com.example.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class App03GamingSpringBeans {


    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }

    }
}
