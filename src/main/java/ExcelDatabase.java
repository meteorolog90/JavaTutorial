import java.io.File;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDatabase {
   public static void main(String[] args) throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection( 
         "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , 
         "root" , 
         "root"
      );
      
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from emp_tbl");
      XSSFWorkbook workbook = new XSSFWorkbook(); 
      XSSFSheet spreadsheet = workbook.createSheet("employe db");
      
      XSSFRow row = spreadsheet.createRow(1);
      XSSFCell cell;
      cell = row.createCell(1);
      cell.setCellValue("emp_id");
      cell = row.createCell(2);
      cell.setCellValue("emp_name");
      cell = row.createCell(3);
      cell.setCellValue("deg");
      cell = row.createCell(4);
      cell.setCellValue("salary");
      cell = row.createCell(5);
      cell.setCellValue("dept");
      int i = 2;

      while(resultSet.next()) {
         row = spreadsheet.createRow(i);
         cell = row.createCell(1);
         cell.setCellValue(resultSet.getInt("emp_id"));
         cell = row.createCell(2);
         cell.setCellValue(resultSet.getString("emp_name"));
         cell = row.createCell(3);
         cell.setCellValue(resultSet.getString("deg"));
         cell = row.createCell(4);
         cell.setCellValue(resultSet.getString("salary"));
         cell = row.createCell(5);
         cell.setCellValue(resultSet.getString("dept"));
         i++;
      }

      FileOutputStream out = new FileOutputStream(new File("exceldatabase.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("exceldatabase.xlsx written successfully");
   }
}