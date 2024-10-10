package ico.dependency_injection.AnotationValue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class ClassicMusic implements Music {
    @Override
    public String getSong() {
        return "ClassicMusic";
    }
}
