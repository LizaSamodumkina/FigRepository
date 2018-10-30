package by.etc.reader;

import by.etc.reader.exception.ReadingFileException;

import java.util.List;

public interface PlaneReader {
    public List<String> read() throws ReadingFileException;
    public List<String> readOnlyValid() throws ReadingFileException;
}
