package Util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Properties;

public class Util {
    private static Util util;
    private Properties properties;
    private XSSFSheet sheet;
    private XSSFSheet sheet2;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
    private XSSFWorkbook workbook;
    private OutputStream outputStream;
    private DataFormatter dataFormatter;
    private Util()
    {
        try
        {
            InputStream inputStream1=new FileInputStream("Book1.xlsx");
            workbook  =new XSSFWorkbook(inputStream1);
            sheet=  workbook.getSheetAt(0);
            sheet2= workbook.getSheetAt(1);
            InputStream inputStream=new FileInputStream("Config.properties");
            properties=new Properties();
            properties.load(inputStream);
            this.dataFormatter=new DataFormatter();
        }
        catch (IOException e)
        {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
    public static Util getInstance()
    {
        if (util==null)
        {
            util=new Util();
            return util;
        }
        else
        {
            return util;
        }
    }

    public String getPlatform_name() {
        return properties.getProperty("PLATFORM_NAME");
    }

    public String getPlatform_version() {
        return properties.getProperty("PLATFORM_VERSION");
    }

    public String getDevice_name() {
        return properties.getProperty("DEVICE_NAME");
    }

    public String getAutomation_name() {
        return properties.getProperty("AUTOMATION_NAME");
    }

    public String getApp_location() {
        return properties.getProperty("APP");
    }

    public String getApp_package() {
        return properties.getProperty("AppPackage");
    }

    public String getApp_activity() {
        return properties.getProperty("AppActivity");
    }

    public String getHost_url() {
        return properties.getProperty("Host_URL");
    }
    public void setUserDetails(String mobileNumber,String username,String email,String password)
    {
      this.username=username;
      this.email=email;
      this.mobileNumber=mobileNumber;
      this.password=password;
    }
    public void insertData()
    {
        String [] customerDetails={this.mobileNumber,this.username,this.email,this.password};
      int lastrownum= this.sheet.getLastRowNum();
      int lastcell=this.sheet.getRow(0).getLastCellNum();
      XSSFRow newRow= this.sheet.createRow(lastrownum+1);
      for(int i=0;i<lastcell;i++)
      {
          newRow.createCell(i).setCellValue(customerDetails[i]);
      }
        try
        {
            FileOutputStream outputStream =new FileOutputStream("Book1.xlsx");
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    private String newMobileNumber="";
    public String getNewMobileNumber()
    {
        int lastRowNum=this.sheet2.getLastRowNum()+1;
        for (int i=1;i<lastRowNum;i++)
        {
            if(sheet2.getRow(i).getCell(1)!=null)
            {
                continue;
            }
            else {
                this.newMobileNumber=dataFormatter.formatCellValue(sheet2.getRow(i).getCell(0));
                try
                {
                    this.sheet2.getRow(i).createCell(1).setCellValue("used");
                    FileOutputStream outputStream =new FileOutputStream("Book1.xlsx");
                    workbook.write(outputStream);
                    outputStream.flush();
                    outputStream.close();
                    break;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
        if (!this.newMobileNumber.isEmpty())
        {
            return this.newMobileNumber;
        }
        else
        {
            System.out.println("couldnt able to fetch mobile number from excel");
            return "";
        }
    }
    }
