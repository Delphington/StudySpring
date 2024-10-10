package ico.dependency_injection.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PlayerMusic {

    @Autowired
    @Qualifier("rockMusic")
    Music music;

    public String getMusic() {
        return music.getSong();
    }


    PlayerMusic(Music music) {
        this.music = music;
    }

    PlayerMusic() {
        System.out.println();
    }


    public void setMusic(Music music) {
        this.music = music;
    }
}
