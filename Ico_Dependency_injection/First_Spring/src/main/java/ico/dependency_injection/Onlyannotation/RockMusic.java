package ico.dependency_injection.Onlyannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "It's rock";
    }
}
