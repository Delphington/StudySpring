package ico.dependency_injection;

public class PlayerMusic {
    Music music;

    PlayerMusic(Music music) {
        this.music = music;
    }

    public String getMusic() {
        return music.getSong();
    }
}
