package com.example.api.utils;

import com.codeborne.xlstest.XLS;
import com.example.models.User;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class XlsHelper {

    public final static XlsHelper helper = new XlsHelper();

    private final List<User> users;

    public List<User> getUsers() {
        return users;
    }

    private final XLS spreadsheet;

    private XlsHelper() {
        this.spreadsheet = new XLS(getClass().getClassLoader().getResource("dbMock.xls"));
        this.users = loadData();
    }

    private List<User> loadData() {
        List<User> users = new ArrayList<>();
        Iterator<Row> rowIterator = spreadsheet.excel.getSheetAt(0).rowIterator();
        if (rowIterator.hasNext()) {
            rowIterator.next(); // skipping first row as a head of columns
        }

        while (rowIterator.hasNext()) {
            Row next = rowIterator.next();
            users.add(assignUser(next));
        }
        return users;
    }


    private User assignUser(Row row) {
        return new User.Builder()
                .withId((long) row.getCell(0).getNumericCellValue())
                .withName(row.getCell(1).getStringCellValue())
                .withEmail(row.getCell(2).getStringCellValue())
                .withAge((int) row.getCell(3).getNumericCellValue())
                .withPassport(row.getCell(4).getStringCellValue()).build();
    }


}
