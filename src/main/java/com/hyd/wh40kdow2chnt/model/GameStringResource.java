package com.hyd.wh40kdow2chnt.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameStringResource {

    public static final String BOM = "\uFEFF";

    public static GameStringResource load(String filename, Charset charset) throws IOException {
        Path path = Path.of(filename);
        if (!path.toFile().exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        var resource = new GameStringResource();
        Files.readAllLines(path, charset).forEach(line -> {
            line = line.replace(BOM, "");
            var stringLine = StringLine.parse(line, "\t");
            if (stringLine != StringLine.EMPTY) {
                resource.putLine(stringLine);
            }
        });

        return resource;
    }

    ///////////////////////

    private final Map<Integer, StringLine> data = new HashMap<>();

    public StringLine getLine(int key) {
        return data.get(key);
    }

    public boolean containsKey(int key) {
        return data.containsKey(key);
    }

    public Set<Integer> getKeySet() {
        return data.keySet();
    }

    public void putLine(StringLine line) {
        data.put(line.getKey(), line);
    }

    public void remove(int key) {
        data.remove(key);
    }

    public void writeToFile(String filename, Charset charset, boolean withBom, String newline) throws IOException {
        var content = data.values().stream().map(StringLine::toString).collect(Collectors.joining(newline));
        if (withBom) {
            content = BOM + content;
        }
        Files.writeString(Path.of(filename), content, charset);
    }
}
