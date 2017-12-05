package de.fuwa.bomberman.game.gui;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends BasicFuwaManPanel {

    @Override
    protected void addComponents() {
        JPanel buttonPanel = new TransparentPanel();
        GridLayout l = new GridLayout(7, 1);
        l.setVgap(25);
        buttonPanel.setLayout(l);
        this.centerPanel.setLayout(new GridLayout(1, 3)); // we only fill the center element later
        this.centerPanel.add(new TransparentPanel());
        this.centerPanel.add(buttonPanel);
        this.centerPanel.add(new TransparentPanel());

        buttonPanel.add(new TransparentPanel()); // empty space

        JButton singleplayer = new JButton("Singleplayer");
        singleplayer.addActionListener(e -> listener.onClickSingleplayer());
        buttonPanel.add(singleplayer);

        JButton multiplayer = new JButton("Multiplayer");
        multiplayer.addActionListener(e -> listener.onClickMultiplayer());
        buttonPanel.add(multiplayer);

        JButton options = new JButton("Settings");
        options.addActionListener(e -> listener.onClickOptions());
        buttonPanel.add(options);

        JButton credits = new JButton("Credits");
        credits.addActionListener(e -> listener.onClickCredits());
        buttonPanel.add(credits);

        JButton close = new JButton("Exit Game");
        close.addActionListener(e -> listener.onClickExit());
        buttonPanel.add(close);
    }

}