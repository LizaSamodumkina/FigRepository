package by.etc.creator;

import by.etc.creator.exception.FillDataException;
import by.etc.entity.Plane;

import java.util.List;

public interface FillData {
    public List<Plane> fillData() throws FillDataException;
}
