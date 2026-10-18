# Media conversion facade

This Java project demonstrates the Facade pattern with a small media conversion example. `MediaConversionFacade` coordinates metadata reading, codec selection, byte processing, and audio normalization. The conversion is simulated; it does not read or write real encoded audio formats.

## Run

Use JDK 17 or later. From the project folder, compile the source files:

```sh
mkdir -p out
javac -d out src/main/java/media/*.java
```

Run the client with an existing file whose extension is `wav`, `mp3`, or `flac`, followed by the target format:

```sh
java -cp out media.Client input.wav mp3
```

The client writes the converted byte data next to the source file. The codec classes simulate format-specific processing, so the output is for demonstrating the pattern and is not a playable audio conversion.
