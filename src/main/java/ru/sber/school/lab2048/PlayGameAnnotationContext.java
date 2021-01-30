package ru.sber.school.lab2048;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sber.school.spring.config.AnnotationContextConfig;

import javax.swing.*;

public class PlayGameAnnotationContext {

    public static final Logger LOGGER = LoggerFactory.getLogger(PlayGameAnnotationContext.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationContextConfig.class);
        JFrame game = context.getBean(JFrame.class);
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(340, 360);
        game.setResizable(false);

        JPanel gamePanel = context.getBean(Game2048Panel.class);

        game.add(gamePanel);

        game.setLocationRelativeTo(null);
        game.setVisible(true);
        LOGGER.info("Application run!");
    }

}
