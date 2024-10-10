package ico.dependency_injection.Onlyannotation;

import org.springframework.stereotype.Component;


@Component
public class ClassicMusic implements Music {
    @Override
    public String getSong() {
        return "ClassicMusic";
    }
}
