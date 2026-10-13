package cargo;

public class FragileItem extends BaseCargo {
    //(требует ли специального обращения)
    private boolean requiresSpecialHandling;

    public FragileItem(String id, String name, double weight) {
        super(id, name, weight);
        this.requiresSpecialHandling = requiresSpecialHandling;
    }

    public boolean isRequiresSpecialHandling() {
        return requiresSpecialHandling;
    }

    @Override
    public String getType(){
        return "Хрупкий груз (" + (requiresSpecialHandling ? "требует спец. ухода" : "обычный уход") + ")";
    }
}
