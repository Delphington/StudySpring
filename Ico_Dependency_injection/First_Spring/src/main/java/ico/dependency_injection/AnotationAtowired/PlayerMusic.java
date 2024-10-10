package ico.dependency_injection.AnotationAtowired;

public class PlayerMusic {
    Music music;
    int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

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
