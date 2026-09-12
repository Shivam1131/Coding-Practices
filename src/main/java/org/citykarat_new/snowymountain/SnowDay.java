package org.citykarat_new.snowymountain;

import java.util.Arrays;

public class SnowDay {

    private final int[] snowfall;

    public SnowDay(int[] snowfall) {
        this.snowfall = Arrays.copyOf(snowfall, snowfall.length);
    }

    public int[] getSnowfall() {
        return Arrays.copyOf(snowfall, snowfall.length);
    }
}
