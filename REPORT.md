# Media conversion facade

## Introduction

This project uses the Facade pattern for a simulated media conversion process. A client would otherwise need to read file metadata, choose codecs, process the bytes, normalize the result, and save an output file. `MediaConversionFacade` provides one `convert` method to coordinate those steps.

The project supports `wav`, `mp3`, and `flac` as format labels. It uses byte-level operations to demonstrate the flow. It does not implement real audio codecs, so the output should not be treated as a playable audio file.

## UML class diagram

![alt text](UML.svg)

The arrows from the Facade show which subsystem classes it coordinates. Those classes do not refer back to the Facade, so an advanced caller can use them directly.

## Clean Code principles

### 1. Names describe the work

Names such as `MetadataReader`, `AudioMixer`, and `convert` give the caller a useful idea of each operation.

```java
public String convert(Path source, String targetFormat) throws IOException
```

### 2. Each class has a focused responsibility

`AudioMixer` normalizes the byte values. It does not read files or choose codecs.

```java
public byte[] normalize(byte[] data)
```

### 3. The Facade coordinates the steps

The public API accepts a source path and target format. The caller does not need to pass codec or metadata objects.

```java
facade.convert(Path.of(args[0]), args[1]);
```

### 4. Subsystem details stay behind the Facade

The Client creates and calls only the Facade. The Facade owns the subsystem objects it needs for conversion.

```java
private final MetadataReader metadataReader = new MetadataReader();
private final CodecFactory codecFactory = new CodecFactory();
```

### 5. Invalid input produces an error

`MetadataReader` reports a missing source file with an `IOException` and a missing extension with an `IllegalArgumentException`. The Client prints the failure message.

```java
if (!Files.isRegularFile(file)) {
    throw new IOException("Source file does not exist: " + file);
}
```

## Conclusion

The Facade hides the order of metadata reading, codec selection, byte adjustment, normalization, and file writing. The subsystem classes remain separate and can be called directly when a client needs lower-level control. This example demonstrates the coordination pattern with simulated byte processing rather than real media encoding.

GitHub repository: add the repository URL after a remote is configured.
