package Staging.pakages;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private static List<String> stringList;

    public DataList() {
        this.stringList = new ArrayList<>();
    }

    public static List<String> getStringList() {
        return stringList;
    }

    public void addString(String str) {
        stringList.add(str);
    }
}
