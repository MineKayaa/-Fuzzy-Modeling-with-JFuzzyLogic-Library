/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minekaya_1a_b161210086;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author MINE KAYA
 */
public class blogger {
    private final FIS fis;
    private final double degree;
    private final double caprice;
    private final double topic;
    private final double lmt;
    private final double lpss;
    
     public blogger(double degree, double caprice, double topic, double lmt, double lpss) throws URISyntaxException{
      this.degree = degree;
      this.caprice = caprice;
      this.topic = topic;
      this.lmt = lmt;
      this.lpss = lpss;
      
      
      File dosya = new File(getClass().getResource("model.fcl").toURI());
      fis = FIS.load(dosya.getPath());
      fis.setVariable("degree", degree);
      fis.setVariable("caprice", caprice);
      fis.setVariable("topic", topic);
      fis.setVariable("lmt", lmt);
      fis.setVariable("lpss", lpss);
      fis.evaluate();
    }
     public FIS getMethod()
    { return fis; }
   
    @Override
    public String toString(){
     //String cikti="degree(1-3): "+degree+"\ncaprice(1-3): " +caprice+"\ntopic(1-5): " +topic+"\nlmt(1-2): " +lmt+"\nlpss(1-2): " +lpss;
     String cikti="fuzzy logic value is =";
     double val=1.66;
    
     //COGa gore 1.66 olan ortalmanin alti nonpro ustu pro olarak kabul edildi
     
     if(fis.getVariable("pro_blogger").getValue()>val)
     //cikti += "\nProBlogger"+fis.getVariable("pro_blogger").getValue()+"";
     {   
         cikti += "pro blogger  "+fis.getVariable("pro_blogger").getValue();
     }
     else
     {
       cikti +="nonpro blogger   "+fis.getVariable("pro_blogger").getValue();
     }
     return cikti;
    }
  
    //hata hesaplamasinda kullan
    public int val(){
       
        return (int)fis.getVariable("pro_blogger").getValue();
        
    }
    
}
