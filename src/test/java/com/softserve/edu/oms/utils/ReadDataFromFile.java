package com.softserve.edu.oms.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//For XLS file: HSSFWorkbook & HSSFSheet
//For XLSX file: XSSFSheet & XSSFSheet

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

import com.sun.jna.platform.win32.Netapi32Util.User;

import com.softserve.edu.oms.database.ProductEntity;
import com.softserve.edu.oms.database.UserEntity;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;

//import org.apache.poi.xssf.usermodel.XSSFRow;

public class ReadDataFromFile {

    private static HSSFSheet tableSheet;
    private static HSSFWorkbook tableBook;
    private static HSSFCell sheetCell;
    // private static XSSFRow SheetRow;

    private static String dataFileName = "TestData.xls";
    private static String dataFilePath;

    // open the table
    private static void openDataFile(String SheetName) throws Exception {
        FileInputStream TableFile = new FileInputStream(getTestDataFilePath());
        tableBook = new HSSFWorkbook(TableFile);
        tableSheet = tableBook.getSheet(SheetName);
    }

    // ---read the test data from the cell--\\

    public static String getSpecifficCellData(int Row, int Column) throws Exception {// todo
                                                                                     // catch
                                                                                     // exetionss
        sheetCell = tableSheet.getRow(Row).getCell(Column);
        String CellData = sheetCell.getStringCellValue();
        return CellData;
    }

    private static String getTestDataFilePath() {
        dataFilePath = ReadDataFromFile.class.getResource("/" + dataFileName).getPath();
        return dataFilePath;
    }

    private static List<Object[]> readAllTestDataFromSheet(String sheetName) {
        Cell cell;
        List<Object[]> testDataList = new ArrayList<Object[]>();

        try {
            openDataFile(sheetName);
            Iterator<Row> rowIterator = tableSheet.iterator();
            List<String> cellsInRowData;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // get row
                Iterator<Cell> cellIterator = row.cellIterator();
                cellsInRowData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    // get cell format
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            cellsInRowData.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case Cell.CELL_TYPE_STRING:
                            cellsInRowData.add(cell.getStringCellValue());
                            break;
                    }
                }
                testDataList.add(cellsInRowData.toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testDataList;
    }

    private static List<UserEntity> readUesrsData(String sheetName) {
        List<Object[]> users = readAllTestDataFromSheet(sheetName);
        List<UserEntity> listOfUsers = new ArrayList<UserEntity>();
        // TODO DELITE COMMENTS
        // user has next fields: firstName, lastName, password, login, email,
        // region, role
        /*
         * for (int field = 0; field <= 7; field ++){ }
         */
        for (Object[] userField : users) {
            UserEntity user = new UserEntity.Builder().setFirstName(userField[0].toString())
                    .setLastName(userField[1].toString()).setPassword(userField[2].toString())
                    .setLogin(userField[3].toString()).setEmail(userField[4].toString())
                    .setRegion(Region.getRegion(userField[5].toString())).setRole(Role.getRole(userField[6].toString()))
                    .build();
            listOfUsers.add(user);
        }
        
        
        // bug is somewhere here
        return listOfUsers;
    }

    private static List<ProductEntity> readProductsData(String sheetName) {
        List<Object[]> products = readAllTestDataFromSheet(sheetName);
        List<ProductEntity> listOfProducts = new ArrayList<ProductEntity>();
        for (Object[] productField : products) {
            ProductEntity product = new ProductEntity.Builder().setName(productField[0].toString())
                    .setDescription(productField[1].toString()).setPrice(productField[2].toString()).build();
            listOfProducts.add(product);
        }

        return listOfProducts;
    }

    @DataProvider(name = "getUsersDataProvider")
    public static Iterator<UserEntity> editUsersDataProvider() {
        return readUesrsData("EditUsersData").iterator();
    }

    @DataProvider(name = "detProductsDataProvider")
    public static Iterator<ProductEntity> excelEditUsers() {
        return readProductsData("sheetWithTCNAme").iterator();
    }

    
    //this method was created to test current class 
    public static void main(String[] args) {
       Iterator<UserEntity> users = editUsersDataProvider();
       while (users.hasNext()){
           UserEntity user = users.next();
           System.out.println(user.getEmail());
           
       }

    }

}