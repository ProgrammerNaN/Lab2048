package ru.sber.school.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sber.school.lab2048.Board;
import ru.sber.school.lab2048.Key;
import ru.sber.school.lab2048.SquareBoard;

import javax.swing.*;

@Configuration
@ComponentScan(basePackages = "ru.sber.school.lab2048")
public class AnnotationContextConfig {

    @Bean
    public Board<Key, Integer> board() {
        return new SquareBoard<>(4);
    }

    @Bean
    public JFrame game() {
        return new JFrame();
    }

}
