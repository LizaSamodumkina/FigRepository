package by.etc.reader.impl;

import by.etc.reader.PlaneReader;
import by.etc.reader.exception.ReadingFileException;
import by.etc.validator.PlaneDataValidator;
import by.etc.validator.impl.PlaneDataValidatorImpl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaneReaderImpl implements PlaneReader {

    private String fileName;

    public PlaneReaderImpl(){
        fileName = "data.txt";
    }

    @Override
    public List<String> read() throws ReadingFileException{
        List<String> lines = new ArrayList<>();
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        }
        catch(IOException e){
            throw new ReadingFileException("cannot reading file "+ fileName + " in method read()", e);
        }
        return lines;
    }

    @Override
    public List<String> readOnlyValid() throws ReadingFileException{
        List<String> temp = new ArrayList<>();
        try {
            temp = read();

            PlaneDataValidator validator = new PlaneDataValidatorImpl();
            Iterator<String> iter = temp.iterator();

            while(iter.hasNext()){
                String check = iter.next();
                if (validator.isValid(check) == false){
                    iter.remove();
                }
            }
        }
        catch (ReadingFileException e){
            throw new ReadingFileException("cannot reading file "+ fileName + " in method readOnlyValid()", e);
        }

        return temp;
    }
}
