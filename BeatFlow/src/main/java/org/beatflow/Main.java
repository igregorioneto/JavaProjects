package org.beatflow;

import org.beatflow.ui.MainPlayerGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainPlayerGUI mainPlayerGUI = new MainPlayerGUI();
            mainPlayerGUI.setVisible(true);
        });
    }
}