package ico.dependency_injection.AnotationAtowired;

public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "It's rock";
    }
}
