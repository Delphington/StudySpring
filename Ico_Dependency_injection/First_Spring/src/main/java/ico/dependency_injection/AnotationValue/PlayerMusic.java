package ico.dependency_injection.AnotationValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("singleton")
@Component
public class PlayerMusic {

    @Value("${playerMusic.time}")
    private int time;

    @Autowired
    @Qualifier("rockMusic")
    private Music music;

    public int getTime() {
        return time;
    }

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

    @PostConstruct
    public void doMyInit(){
        System.out.println("Init");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Destroy");
    }
}

