package com.example.utils.domain;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class ValueConversion {

    private String Ref;
    private String Type;

    public String getRef () {
        return Ref;
    }

    public void setRef (String Ref) {
        this.Ref = Ref;
    }

    public String getType () {
        return Type;
    }

    public void setType (String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "ValueConversion [Ref = " + Ref + ", Type = " + Type + "]";
    }
}
