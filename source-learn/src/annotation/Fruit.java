package annotation;

import java.io.Serializable;

@FruitAnnotation
public abstract class Fruit implements Serializable {

    private static final long serialVersionUID = 8231816172599358926L;

    private String color;

    private String shape;

    private Integer maturity;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Integer getMaturity() {
        return maturity;
    }

    public void setMaturity(Integer maturity) {
        this.maturity = maturity;
    }

    public abstract String cookie();
}
