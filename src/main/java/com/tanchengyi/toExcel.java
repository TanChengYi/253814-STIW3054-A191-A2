package com.tanchengyi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class toExcel extends Thread{
    follower[] followers;
    String[] header={"No.","login id","Number of repositories","Number of followers","Number of following","Number of gists"};
    toExcel(follower[] followers){
        this.followers=followers;
    }

    @Override
    public void run() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Followers");
        //write to first sheet
        int rowCount = 0;
        int column = 0;
        Row row1 = sheet.createRow(++rowCount);
        for (int i=0;i<header.length;i++) {

            Cell cell = row1.createCell(column++);
            cell.setCellValue((String) header[i]);
            sheet.autoSizeColumn(i);

        }
        for (int i=0;i<followers.length;i++){
            Row row = sheet.createRow(++rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(followers[i].getNo());
            sheet.autoSizeColumn(0);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(followers[i].getLoginId());
            sheet.autoSizeColumn(1);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(followers[i].getRepo());
            sheet.autoSizeColumn(2);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(followers[i].getFollower());
            sheet.autoSizeColumn(3);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue(followers[i].getFollowing());
            sheet.autoSizeColumn(4);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue(followers[i].getGist());
            sheet.autoSizeColumn(5);
        }

        try (FileOutputStream outputStream = new FileOutputStream("RTAssignment2.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
