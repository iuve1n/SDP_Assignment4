package media;

public interface AudioCodec {
    byte[] decode(byte[] data);

    byte[] encode(byte[] data);
}
