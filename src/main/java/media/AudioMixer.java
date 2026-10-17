package media;

public class AudioMixer {
    public byte[] normalize(byte[] data) {
        int peak = 0;
        for (byte sample : data) {
            peak = Math.max(peak, Math.abs((int) sample));
        }
        if (peak == 0) {
            return data.clone();
        }

        byte[] normalized = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            normalized[i] = (byte) (data[i] * 127 / peak);
        }
        return normalized;
    }
}
