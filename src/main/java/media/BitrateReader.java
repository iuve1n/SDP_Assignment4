package media;

public class BitrateReader {
    public byte[] convert(AudioTrack track, AudioCodec sourceCodec, AudioCodec targetCodec) {
        byte[] decoded = sourceCodec.decode(track.getData());
        byte[] adjusted = new byte[decoded.length];

        for (int i = 0; i < decoded.length; i++) {
            adjusted[i] = (byte) (decoded[i] * 0.8);
        }

        return targetCodec.encode(adjusted);
    }
}
