package media;

public class AudioTrack {
    private final String fileName;
    private final String format;
    private final int durationSeconds;
    private final byte[] data;

    public AudioTrack(String fileName, String format, int durationSeconds, byte[] data) {
        this.fileName = fileName;
        this.format = format;
        this.durationSeconds = durationSeconds;
        this.data = data.clone();
    }

    public String getFileName() {
        return fileName;
    }

    public String getFormat() {
        return format;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public byte[] getData() {
        return data.clone();
    }
}
