package ico.dependency_injection.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music {
    @Override
    public String getSong() {
        return "ClassicMusic";
    }
}
