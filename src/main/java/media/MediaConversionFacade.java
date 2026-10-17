package media;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MediaConversionFacade {
    private final MetadataReader metadataReader = new MetadataReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final AudioMixer audioMixer = new AudioMixer();

    public String convert(Path source, String targetFormat) throws IOException {
        AudioTrack track = metadataReader.read(source);
        AudioCodec sourceCodec = codecFactory.getCodec(track.getFormat());
        AudioCodec targetCodec = codecFactory.getCodec(targetFormat);

        byte[] converted = bitrateReader.convert(track, sourceCodec, targetCodec);
        byte[] normalized = audioMixer.normalize(converted);

        Path output = source.resolveSibling(outputName(source, targetFormat));
        Files.write(output, normalized);
        return output.toString();
    }

    private String outputName(Path source, String targetFormat) {
        String name = source.getFileName().toString();
        int dot = name.lastIndexOf('.');
        String baseName = dot > 0 ? name.substring(0, dot) : name;
        return baseName + "." + targetFormat.toLowerCase();
    }
}
