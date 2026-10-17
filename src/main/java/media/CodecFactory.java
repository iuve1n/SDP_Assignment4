package media;

import java.util.Set;

public class CodecFactory {
    private static final Set<String> FORMATS = Set.of("wav", "mp3", "flac");

    public AudioCodec getCodec(String format) {
        String normalized = format.toLowerCase();
        if (!FORMATS.contains(normalized)) {
            throw new IllegalArgumentException("Unsupported audio format: " + format);
        }
        return new SimpleAudioCodec(normalized);
    }

    private static class SimpleAudioCodec implements AudioCodec {
        private final String format;

        private SimpleAudioCodec(String format) {
            this.format = format;
        }

        @Override
        public byte[] decode(byte[] data) {
            byte[] decoded = new byte[data.length];
            for (int i = 0; i < data.length; i++) {
                decoded[i] = (byte) (data[i] ^ format.hashCode());
            }
            return decoded;
        }

        @Override
        public byte[] encode(byte[] data) {
            byte[] encoded = new byte[data.length];
            for (int i = 0; i < data.length; i++) {
                encoded[i] = (byte) (data[i] ^ format.hashCode());
            }
            return encoded;
        }
    }
}
