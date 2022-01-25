package pl.put.poznan.transformer.models;

public enum ParamValues {
    AREA(1, 60),
    CUBE( 1, 180),
    HEATING(0, 100),
    LIGHT(0, 100);

    private float minValue;
    private float maxValue;

    ParamValues(float minValue, float maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    public float getMinValue() {
        return minValue;
    }
    public float getMaxValue() {
        return maxValue;
    }
}
