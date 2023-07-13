package com.saanacode.fileuploaddownload.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {
    //to compress image while storing into the database
    //and decompress while retrieving from the database

public static byte[] compressImage(byte[] data) {
    Deflater deflater = new Deflater();
    deflater.setLevel(Deflater.BEST_COMPRESSION);
    deflater.setInput(data);
    deflater.finish();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] tmp = new byte[4 * 1024];

    while (!deflater.finished()) {
        int size = deflater.deflate(tmp);
        outputStream.write(tmp, 0, size);
    }
    try {
        outputStream.close();
    } catch (Exception ignored) {
    }
    System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

    return outputStream.toByteArray();
}

    public static byte[] decompressImage(byte[] data) {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] tmp = new byte[4 * 1024];
    try {
        while (!inflater.finished()) {
            int size = inflater.inflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        outputStream.close();
    } catch (IOException | DataFormatException ignored) {
    }
        return outputStream.toByteArray();
    }





}





