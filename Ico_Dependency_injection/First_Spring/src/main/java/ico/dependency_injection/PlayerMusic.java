package ico.dependency_injection;

public class PlayerMusic {
    Music music;

    PlayerMusic(Music music) {
        this.music = music;
    }
    PlayerMusic(){}

    public String getMusic() {
        return music.getSong();
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
