package ico.dependency_injection.Qualifier;


import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "It's rock";
    }
}
