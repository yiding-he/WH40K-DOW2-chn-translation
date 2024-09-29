package com.hyd.wh40kdow2chnt;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static final Charset DOW_CHARSET = StandardCharsets.UTF_16LE;
    public static final char BOM = '\uFEFF';

    public static final String ORIGINAL = "original/DOW2.ucs";

    public static final String SOURCE_1 = "chinese/dow2/DOW2.ucs";
    public static final String SOURCE_2 = "chinese/dow2_c/DOW2.ucs";
    public static final String SOURCE_3 = "chinese/dow2_r/DOW2.ucs";

    public static final String OUTPUT_FILE = "chinese/DOW2.ucs";

    public static void main(String[] args) {
        // TODO: implement this
    }
}
