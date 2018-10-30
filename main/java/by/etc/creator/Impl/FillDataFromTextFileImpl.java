package by.etc.creator.Impl;

import by.etc.creator.FillDataFromTextFile;
import by.etc.creator.exception.FillDataException;
import by.etc.entity.Plane;
import by.etc.parser.PlaneParser;
import by.etc.parser.exception.CircleParserException;
import by.etc.parser.impl.PlaneParseImpl;
import by.etc.reader.PlaneReader;
import by.etc.reader.exception.ReadingFileException;
import by.etc.reader.impl.PlaneReaderImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FillDataFromTextFileImpl implements FillDataFromTextFile {
    private final static Logger log = LogManager.getLogger(FillDataFromTextFileImpl.class);

    @Override
    public List<Plane> fillData() throws FillDataException{
        PlaneReader reader = new PlaneReaderImpl();
        List<String> list = new ArrayList<>();

        PlaneParser parser = new PlaneParseImpl();
        List<Plane> planes = new ArrayList<>();
        try {
            list = reader.readOnlyValid();

            planes =  parser.parseAsListOfPlane(list);
        }
        catch (ReadingFileException e){
            log.error("error message: "+ e.getCause());
            throw new FillDataException("cannot fill data because problems with reading file", e);
        }
        catch(CircleParserException e){
            log.error("error message: "+ e.getCause());
            throw new FillDataException("cannot fill data because problems with parsing data from file", e);
        }

        return planes;
    }
}
