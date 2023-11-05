package org.beatflow.ui;

import org.beatflow.business.MusicLibrary;
import org.beatflow.util.MessagemPersonalizadaDeInformacao;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainPlayerGUI extends JFrame {
    private MusicLibrary musicLibrary;
    private MessagemPersonalizadaDeInformacao messagemPersonalizadaDeInformacao;
    private JTextField campoMostrarURLDoArquivo;

    private Clip audioCLip;
    private String filePath;
    private Timer scrollTimer;
    private String textToScroll = "";

    private JButton importButton;
    private JButton playerButton;
    private JButton stopButton;

    public MainPlayerGUI() throws HeadlessException {
        musicLibrary = MusicLibrary.getInstance();
        messagemPersonalizadaDeInformacao = MessagemPersonalizadaDeInformacao.getInstance();
        GUIComponents();

        ActionListener timerAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textToScroll.length() > 0) {
                    textToScroll = textToScroll.substring(1) + textToScroll.charAt(0);
                    campoMostrarURLDoArquivo.setText(textToScroll);
                }
            }
        };

        scrollTimer = new Timer(200, timerAction);

        playerButton = createPlayButton();
        importButton = createImportButton();
        stopButton = createStopButton();
        campoMostrarURLDoArquivo = new JTextField(20);
        campoMostrarURLDoArquivo.setEditable(false);

        ADDGUIComponents(playerButton, importButton, campoMostrarURLDoArquivo, stopButton);
    }


    private void ADDGUIComponents(
            JButton playerButton,
            JButton importButton,
            JTextField campoMostrarURLDoArquivo,
            JButton stopButton
    ) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(importButton);
        buttonPanel.add(playerButton);
        buttonPanel.add(stopButton);

        playerButton.setEnabled(false);
        stopButton.setEnabled(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(campoMostrarURLDoArquivo);
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void GUIComponents() {
        setTitle("Beat Flow - O Novo Player de Música");
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStopButton() {
        JButton stopButton = new JButton("STOP");
        stopButton.addActionListener(e -> {
            if (audioCLip != null) {
                audioCLip.stop();
            }
        });
        return stopButton;
    }

    private JButton createPlayButton() {
        JButton playerButton = new JButton("PLAY");
        playerButton.addActionListener(e -> {
            try {
                if (audioCLip != null) {
                    audioCLip.stop();
                }

                if (filePath != null && !filePath.isEmpty()) {
                    File audioFile = new File(filePath);

                    if (audioFile.exists()) {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                        audioCLip = AudioSystem.getClip();
                        audioCLip.open(audioInputStream);
                        audioCLip.start();
                        stopButton.setEnabled(true);
                    } else {
                        messagemPersonalizadaDeInformacao.showErrorDialog(
                                MainPlayerGUI.this,
                                "Arquivo de áudio não encontrado.");
                    }
                }
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException | NullPointerException err) {
                messagemPersonalizadaDeInformacao.showErrorDialog(MainPlayerGUI.this, "Erro ao reproduzir o áudio: " + campoMostrarURLDoArquivo.getText());
                System.out.println("Erro ao reproduzir a música: " + err.getMessage());
            }
        });
        return playerButton;
    }

    private JButton createImportButton() {
        JButton importButton = new JButton("IMPORT");
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(MainPlayerGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();
                    String nameFile = selectedFile.getName();
                    campoMostrarURLDoArquivo.setText(nameFile);

                    playerButton.setEnabled(true);

                    textToScroll = nameFile + "         ";
                    scrollTimer.start();
                }
            }
        });

        return importButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainPlayerGUI mainPlayerGUI = new MainPlayerGUI();
            mainPlayerGUI.setVisible(true);
        });
    }
}