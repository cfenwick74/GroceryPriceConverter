package fenwick.priceconverter;

/**
 * Created by carolynfenwick on 2017-04-14.
 */

public class Converter {

    private final Double CONVERSION_FACTOR = 2.2046;

    public Double convertPoundsToKilos(Double price) {
        return price * CONVERSION_FACTOR;
    }

    public Double convertKilosToPounds (Double price) {
        return price / CONVERSION_FACTOR;
    }

    public Double getConversionFactor() {
        return CONVERSION_FACTOR;
    }
}
