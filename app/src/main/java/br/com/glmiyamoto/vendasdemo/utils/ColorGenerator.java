package br.com.glmiyamoto.vendasdemo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Gustavo on 2016/03/15.
 */
public class ColorGenerator {
    public static ColorGenerator DEFAULT;
    public static ColorGenerator MATERIAL;
    public static ColorGenerator SALES;

    static {
        DEFAULT = create(Arrays.asList(
                0xfff16364,
                0xfff58559,
                0xfff9a43e,
                0xffe4c62e,
                0xff67bf74,
                0xff59a2be,
                0xff2093cd,
                0xffad62a7,
                0xff805781
        ));
        MATERIAL = create(Arrays.asList(
                0xffe57373,
                0xfff06292,
                0xffba68c8,
                0xff9575cd,
                0xff7986cb,
                0xff64b5f6,
                0xff4fc3f7,
                0xff4dd0e1,
                0xff4db6ac,
                0xff81c784,
                0xffaed581,
                0xffff8a65,
                0xffd4e157,
                0xffffd54f,
                0xffffb74d,
                0xffa1887f,
                0xff90a4ae
        ));
        SALES = create(Arrays.asList(
                0xffe7ad45,
                0xffd04f2a,
                0xff5f498c,
                0xffa3c74b,
                0xffce4251,
                0xff4982c5,
                0xff919191,
                0xff709a8e,
                0xff352a2e
        ));
    }

    private final List<Integer> mColors;
    private final Random mRandom;

    public static ColorGenerator create(List<Integer> colorList) {
        return new ColorGenerator(colorList);
    }

    private ColorGenerator(List<Integer> colorList) {
        mColors = colorList;
        mRandom = new Random(System.currentTimeMillis());
    }

    /**
     * Return color randomly
     * @return
     */
    public int getRandomColor() {
        return mColors.get(mRandom.nextInt(mColors.size()));
    }

    /**
     * Return color by key
     * @param key
     * @return
     */
    public int getColor(Object key) {
        return mColors.get(Math.abs(key.hashCode()) % mColors.size());
    }
}
