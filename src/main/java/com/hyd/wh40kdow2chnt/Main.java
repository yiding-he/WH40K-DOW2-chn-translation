package com.hyd.wh40kdow2chnt;

import com.hyd.wh40kdow2chnt.model.GameStringResource;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final Charset DOW_CHARSET = StandardCharsets.UTF_16LE;

    public static final String ORIGINAL = "src/main/resources/original/DOW2.ucs";
    public static final String SOURCE_1 = "src/main/resources/chinese/dow2/DOW2.ucs";
    public static final String SOURCE_2 = "src/main/resources/chinese/dow2_c/DOW2.ucs";
    public static final String SOURCE_3 = "src/main/resources/chinese/dow2_r/DOW2.ucs";

    public static final String OUTPUT_FILE = "chinese/DOW2.ucs";

    public static void main(String[] args) throws Exception {

        var resOriginal = GameStringResource.load(ORIGINAL, DOW_CHARSET);
        var resSource1 = GameStringResource.load(SOURCE_1, DOW_CHARSET);
        var resSource2 = GameStringResource.load(SOURCE_2, DOW_CHARSET);
        var resSource3 = GameStringResource.load(SOURCE_3, DOW_CHARSET);

        System.out.println("Merging " + SOURCE_2 + "...");
        mergeFrom(resSource1, resSource2);
        System.out.println("Merging " + SOURCE_3 + "...");
        mergeFrom(resSource1, resSource3);
        System.out.println("Merging " + ORIGINAL + "...");
        mergeFrom(resSource1, resOriginal);

        System.out.println("Removing extra keys...");
        removeExtra(resSource1, resOriginal.getKeySet());

        System.out.println("Writing to " + OUTPUT_FILE + "...");
        resSource1.writeToFile(OUTPUT_FILE, DOW_CHARSET, true, "\r\n");
        System.out.println("Done.");
    }

    private static void mergeFrom(GameStringResource target, GameStringResource src) {
        for (var key : src.getKeySet()) {
            if (!target.containsKey(key)) {
                target.putLine(src.getLine(key));
            }
        }
    }

    private static void removeExtra(GameStringResource res, Set<Integer> validKeys) {
        var resKeys = new HashSet<>(res.getKeySet());
        resKeys.removeAll(validKeys);
        for (var key : resKeys) {
            res.remove(key);
        }
    }
}
