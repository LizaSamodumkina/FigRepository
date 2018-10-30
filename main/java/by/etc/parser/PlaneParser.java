package by.etc.parser;

import by.etc.entity.Plane;
import by.etc.parser.exception.CircleParserException;

import java.util.List;

public interface PlaneParser {
    List<Plane> parseAsListOfPlane(List<String> data) throws CircleParserException;
}
