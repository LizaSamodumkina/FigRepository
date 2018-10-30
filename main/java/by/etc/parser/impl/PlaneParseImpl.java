package by.etc.parser.impl;

import by.etc.entity.Plane;
import by.etc.parser.PlaneParser;
import by.etc.parser.exception.CircleParserException;

import java.util.ArrayList;
import java.util.List;

import java.lang.NumberFormatException;

public class PlaneParseImpl implements PlaneParser {

    private final static String SPACE = "\\s+";

    @Override
    public List<Plane> parseAsListOfPlane(List<String> data) throws CircleParserException{
        List<String[]> splitList = new ArrayList<>();
        for(String str: data){
            splitList.add(str.split(SPACE));
        }
        try {
            return parseStringToPlane(splitList);
        }
        catch(CircleParserException e){
            throw new CircleParserException("cannot parse String[] to Plane because of incorrect number format in parseAsArray()", e);
        }
    }

    private List<Plane> parseStringToPlane(List<String[]> splitList) throws CircleParserException{
        List<Plane> planeList = new ArrayList<>();
        int id = 1;
        final String name = "figure";
        try {
            for(String []buf: splitList) {

                Plane plane = new Plane();
                plane = new Plane(Double.parseDouble(buf[0]), Double.parseDouble(buf[1]), Double.parseDouble(buf[2]),
                        Double.parseDouble(buf[3]), Double.parseDouble(buf[4]), Double.parseDouble(buf[5]),
                        Double.parseDouble(buf[6]), Double.parseDouble(buf[7]),
                        Double.parseDouble(buf[8]), id, name+id);
                planeList.add(plane);
                id++;
            }
        }
        catch(NumberFormatException e){
            throw new CircleParserException("cannot parse String[] to Plane because of incorrect number format in parseStringToPlane()", e);
        }
        return planeList;
    }
}
