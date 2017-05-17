package com.example.utils.domain;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class ScalarValueType {

    private String name;
    private String step;
    private String minValue;
    private String numBits;
    private String units;
    private String scalarId;
    private ValueConversion valueConversion;
    private String maxValue;

    public ScalarValueType(String name, String step, String minValue, String numBits, String units, String scalarId, ValueConversion valueConversion, String maxValue) {
        this.name = name;
        this.step = step;
        this.minValue = minValue;
        this.numBits = numBits;
        this.units = units;
        this.scalarId = scalarId;
        this.valueConversion = valueConversion;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String Step) {
        this.step = Step;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String MinValue) {
        this.minValue = MinValue;
    }

    public String getNumBits() {
        return numBits;
    }

    public void setNumBits(String NumBits) {
        this.numBits = NumBits;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String Units) {
        this.units = Units;
    }

    public String getScalarId() {
        return scalarId;
    }

    public void setScalarId(String id) {
        this.scalarId = id;
    }

    public ValueConversion getValueConversion() {
        return valueConversion;
    }

    public void setValueConversion(ValueConversion ValueConversion) {
        this.valueConversion = ValueConversion;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String MaxValue) {
        this.maxValue = MaxValue;
    }

    @Override
    public String toString()
    {
        return "ScalarValueType [name = " + name + ", step = " + step
                + ", minValue = " + minValue + ", numBits = " + numBits
                + ", units = " + units + ", id = " + scalarId
                + ", valueConversion = " + valueConversion + ", maxValue = " + maxValue + "]";
    }
}
