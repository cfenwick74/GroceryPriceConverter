package fenwick.priceconverter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by carolynfenwick on 2017-04-14.
 */

public class PriceConverterTest {
    Double cFactor;
    Converter converter;

    @Before
    public void setup () {
        this.converter = new Converter();
        cFactor = converter.getConversionFactor();
    }

    @Test
    public void canConvertPoundsToKilos () throws Exception {
        final Double price = 10.0;
        final Double expected = 22.046;
        assertEquals("converted should be 22.046", expected, this.converter.convertPoundsToKilos(price), 0.01);
    }

    @Test
    public void canConvertKilosToPounds () throws Exception {
        final Double price = 10.0;
        final Double expected = 4.53;
        assertEquals("converted should be 4.53", expected, this.converter.convertKilosToPounds(price), 0.01);
    }
}
