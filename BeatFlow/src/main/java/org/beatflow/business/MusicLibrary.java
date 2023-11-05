package org.beatflow.business;

import org.beatflow.model.Music;
import org.beatflow.util.MessagemPersonalizadaDeInformacao;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MusicLibrary {
    private List<Music> musicList;
    private static MusicLibrary instance;
    private MessagemPersonalizadaDeInformacao messagemPersonalizadaDeInformacao;

    public MusicLibrary() {
        musicList = new ArrayList<>();
        messagemPersonalizadaDeInformacao = MessagemPersonalizadaDeInformacao.getInstance();
    }

    public static MusicLibrary getInstance() {
        if (instance == null) {
            instance = new MusicLibrary();
        }
        return instance;
    }

    // Adicionar música
    public void addMusic(Music music) {
        this.musicList.add(music);
    }

    // Remover música
    public void removeMusic(Music music) {
        this.musicList.remove(music);
    }

    // Listar músicas
    public List<Music> getAllMusic() {
        return musicList;
    }

    // Importando música
    public Music importMusic(Component frame,String filePath) {
        Music importedMusic = createMusicFromFilePath(frame, filePath);
        return importedMusic;
    }

    private Music createMusicFromFilePath(Component frame, String filePath) {
        /*Implementar lógica de criar instância da música
         Ler os metadados da música
         Retornar a instância da música
        */
        try {
            File audioFile = new File(filePath);
            AudioFileFormat format = AudioSystem.getAudioFileFormat(audioFile);
            Map<String, Object> properties = format.properties();

            System.out.println("Title " + properties.get("title"));
            String title = (String) properties.get("title");
            String author = (String) properties.get("author");
            if (title == null || title.isEmpty()) {
                title = "Música sem Título";
            }

            if (author == null || author.isEmpty()) {
                author = "Música sem Autor";
            }

            int duration = 0;

            Music m = new Music(
                    title,
                    author,
                    filePath,
                    duration
            );
            addMusic(m);
            return m;
        } catch (UnsupportedAudioFileException e) {
            messagemPersonalizadaDeInformacao.showErrorDialog(frame, "Formato de arquivo não suportado.");
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
