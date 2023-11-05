package org.beatflow.util;

import javax.swing.*;
import java.awt.*;

public class MessagemPersonalizadaDeInformacao {
    private static MessagemPersonalizadaDeInformacao instance;

    public static MessagemPersonalizadaDeInformacao getInstance() {
        if (instance == null) {
            instance = new MessagemPersonalizadaDeInformacao();
        }
        return instance;
    }

    public void showErrorDialog(Component frame, String messagem) {
        JOptionPane.showMessageDialog(frame, messagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
