package ico.dependency_injection.AnotationAtowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMusic {
    Music music;

    @Autowired
    PlayerMusic(Music music) {
        this.music = music;
    }


    public String getMusic() {
        return music.getSong();
    }

}
