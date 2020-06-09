
package minekaya_1a_b161210086;

import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.abs;

import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



/**
 *
 * @author Mine KAYA b161210086
 */
public class MineKaya_1a_b161210086 {

  
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException, IOException, BiffException {
        double degree;
        double caprice;
        double topic;
        double lmt;
        double lpss;
        double proBlogger ;
        
        double mape=0;
        
        
            FileInputStream file = new FileInputStream(new File("dataset.xls"));
            Workbook w;
        
        try
        {
            w= Workbook.getWorkbook(file);
            // first sheet
            Sheet sheet =w.getSheet(0);
            
            //satir ve sutunları dolas
                for(int i=0; i< sheet.getRows();i++) 
                   {  
                            int k=0;
                           
                            Cell cell=sheet.getCell(k,i);
                            degree =Integer.parseInt(cell.getContents());
                            System.out.print("Degree : "+degree + "\n");
                           
                            k++;
                            cell=sheet.getCell(k,i);
                            caprice =Integer.parseInt(cell.getContents()) ;
                            System.out.print("Caprice : "+caprice + "\n");
                            k++;
                            cell=sheet.getCell(k,i);
                            topic=Integer.parseInt(cell.getContents());
                            System.out.print("Topic : "+topic + "\n");
                            k++;
                            cell=sheet.getCell(k,i);
                            lmt=Integer.parseInt(cell.getContents());
                            System.out.print("Lmt : "+lmt + "\n");
                            k++;
                            cell=sheet.getCell(k,i);
                            lpss =Integer.parseInt(cell.getContents());
                            System.out.print("Lpss : "+lpss + "\n");
                            k++;
                            cell=sheet.getCell(k,i);
                            proBlogger = (double)Integer.parseInt(cell.getContents());
                            System.out.print(" real ProBlogger value : "+proBlogger + "\n");
                            
                            //blogger nesnesine verileri gonderiyoruz
                            blogger b = new blogger(degree,caprice,topic,lmt,lpss);
                            System.out.println(b);
                            
                            //if(k==5&& i==0)JFuzzyChart.get().chart(b.getMethod());
                            
                            double y=b.val();
                            mape += Hata(proBlogger,y);
                            
                           
                    }
            
        }catch(BiffException e){}
            
            
       //hata oranini bastiriyoruz
       System.out.print("MAPE hata orani = "+mape+"\n");
        
        
        
    }
    
    //MAPE hesaplama
    public static double Hata(double hedef, double bulunan){
        //(1/n)*100 islemi yok cunku 100 adet veri var
        double val= abs((hedef-bulunan)/hedef);
        return val;
    }
    
}
