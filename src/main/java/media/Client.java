package media;

import java.nio.file.Path;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java media.Client <source-file> <target-format>");
            return;
        }

        MediaConversionFacade facade = new MediaConversionFacade();
        try {
            String output = facade.convert(Path.of(args[0]), args[1]);
            System.out.println("Converted file saved as " + output);
        } catch (Exception e) {
            System.out.println("Conversion failed: " + e.getMessage());
        }
    }
}
