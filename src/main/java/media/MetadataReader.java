package media;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MetadataReader {
    public AudioTrack read(Path file) throws IOException {
        if (!Files.isRegularFile(file)) {
            throw new IOException("Source file does not exist: " + file);
        }

        String name = file.getFileName().toString();
        int dot = name.lastIndexOf('.');
        if (dot < 1 || dot == name.length() - 1) {
            throw new IllegalArgumentException("Source file must have a format extension");
        }

        String format = name.substring(dot + 1).toLowerCase();
        byte[] data = Files.readAllBytes(file);
        int durationSeconds = Math.max(1, data.length / 16_000);
        return new AudioTrack(name, format, durationSeconds, data);
    }
}
