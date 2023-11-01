package ch.hslu.oop.sw03;

public final class Element {
    private String name;
    private float meltingPoint;
    private float boilingPoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(float meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public float getBoilingPoint() {
        return boilingPoint;
    }

    public void setBoilingPoint(float boilingPoint) {
        this.boilingPoint = boilingPoint;
    }
}
