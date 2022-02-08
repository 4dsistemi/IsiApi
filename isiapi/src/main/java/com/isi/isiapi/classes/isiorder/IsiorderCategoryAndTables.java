package com.isi.isiapi.classes.isiorder;

import java.util.List;

public class IsiorderCategoryAndTables {

    public IsiorderTableCategory isiorderTableCategory;

    public List<IsiorderTableElement> isiorderTableElements;

    @Override
    public String toString() {
        return isiorderTableCategory.name;
    }
}
