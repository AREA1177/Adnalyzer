import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * Adapted by Aidan Ang, Keli Chen, Yuna Chong
 */
public class Picture extends SimplePicture 
{
   ///////////////////// constructors //////////////////////////////////
   
   /**
    * Constructor that takes no arguments 
    */
   public Picture ()
   {
      /* not needed but use it to show students the implicit call to super()
       * child constructors always call a parent constructor 
       */
      super();  
   }
   
   /**
    * Constructor that takes a file name and creates the picture 
    * @param fileName the name of the file to create the picture from
    */
   public Picture(String fileName)
   {
      // let the parent class handle this fileName
      super(fileName);
   }
   
   /**
    * Constructor that takes the width and height
    * @param height the height of the desired picture
    * @param width the width of the desired picture
    */
   public Picture(int height, int width)
   {
      // let the parent class handle this width and height
      super(width,height);
   }
   
   /**
    * Constructor that takes a picture and creates a 
    * copy of that picture
    * @param copyPicture the picture to copy
    */
   public Picture(Picture copyPicture)
   {
      // let the parent class do the copy
      super(copyPicture);
   }
   
   /**
    * Constructor that takes a buffered image
    * @param image the buffered image to use
    */
   public Picture(BufferedImage image)
   {
      super(image);
   }
   
   ////////////////////// methods ///////////////////////////////////////
   
   /**
    * Method to return a string with information about this picture.
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
   public String toString()
   {
      String output = "Picture, filename " + getFileName() + 
         " height " + getHeight() 
         + " width " + getWidth();
      return output;
      
   }
   
   /** Method to set the blue to 0 */
   public void zeroBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            pixelObj.setBlue(0);
         }
      }
   }
   
   public void keepOnlyRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            pixelObj.setGreen(0);
            pixelObj.setBlue(0);
         }
      }
   }
   
   public void keepOnlyGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            pixelObj.setRed(0);
            pixelObj.setBlue(0);
         }
      }
   }
   
   public void keepOnlyBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            pixelObj.setRed(0);
            pixelObj.setGreen(0);
         }
      }
   }
   
   public void negate()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            pixelObj.setRed(255-pixelObj.getRed());
            pixelObj.setGreen(255-pixelObj.getGreen());
            pixelObj.setBlue(255-pixelObj.getBlue());
         }
      }
   }
   
   public void grayscale()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            int average = (int)((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3.0);
            Color grayColor = new Color (average,average,average);
            pixelObj.setColor(grayColor);            
         }
      }
   }
   
   public void fixUnderwater()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel pixelObj : rowArray)
         {
            int currGreen = pixelObj.getGreen();
            pixelObj.setGreen((int)(currGreen/3.5));
            int currBlue = pixelObj.getBlue();
            pixelObj.setBlue((int)(currBlue/3.5));
            
            int currRed = pixelObj.getRed();
            currGreen = pixelObj.getGreen();
            currBlue = pixelObj.getBlue();
            
            pixelObj.setRed((int)Math.min(255,currRed*3));
            pixelObj.setGreen((int)Math.min(255,currGreen*3));
            pixelObj.setBlue((int)Math.min(255,currBlue*3));
         }
      }
   }
   
   /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
   public void mirrorVertical()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for (int row = 0; row < pixels.length; row++)
      {
         for (int col = 0; col < width / 2; col++)
         {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            rightPixel.setColor(leftPixel.getColor());
         }
      } 
   }
   
   public void mirrorVerticalRightToLeft()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int width = pixels[0].length;
      for (int row = 0; row < pixels.length; row++)
      {
         for (int col = 0; col < width / 2; col++)
         {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            leftPixel.setColor(rightPixel.getColor());
         }
      } 
   }
   
   public void mirrorHorizontal()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel botPixel = null;
      int height = pixels.length;
      for (int row = 0; row < height/2; row++)
      {
         for (int col = 0; col < pixels[0].length; col++)
         {
            topPixel = pixels[row][col];
            botPixel = pixels[height - 1 - row][col];
            botPixel.setColor(topPixel.getColor());
         }
      } 
   }
   
   public void mirrorHorizontalBotToTop()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel botPixel = null;
      int height = pixels.length;
      for (int row = 0; row < height/2; row++)
      {
         for (int col = 0; col < pixels[0].length; col++)
         {
            topPixel = pixels[row][col];
            botPixel = pixels[height - 1 - row][col];
            topPixel.setColor(botPixel.getColor());
         }
      } 
   }
   
   public void mirrorDiagonal()
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel currPixel = null;
      Pixel oppoPixel = null;
      int width = pixels[0].length;
      int height = pixels.length;
      int limiter = Math.min(width,height);
      //for (int row = 0; row < limiter; row++)
      for (int row = limiter-1; row >= 0; row--)
      {
         //for (int col = 0; col < limiter; col++)
         for (int col = limiter-1; col >= 0; col--)
         {
            currPixel = pixels[row][col];
            oppoPixel = pixels[col][row];
            oppoPixel.setColor(currPixel.getColor());
         }
      } 
   }
   
   /** Mirror just part of a picture of a temple */
   public void mirrorTemple()
   {
      int mirrorPoint = 276;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      
      // loop through the rows
      for (int row = 27; row < 97; row++)
      {
         // loop from 13 to just before the mirror point
         for (int col = 13; col < mirrorPoint; col++)
         {
            
            leftPixel = pixels[row][col];      
            rightPixel = pixels[row]                       
                              [mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
         }
      }
   }
   
   public void mirrorArms()
   {
      Pixel topPixel = null;
      Pixel botPixel = null;
      Pixel[][] pixels = this.getPixels2D();
           
      int mirrorPoint = 190;
      // loop from row 160 to the mirror point
      for (int row = 160; row <= mirrorPoint; row++)
      {
         // loop from column 106 to 170
         for (int col = 106; col <= 170; col++)
         {
            topPixel = pixels[row][col];      
            botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
            botPixel.setColor(topPixel.getColor());
         }
      }
      
      mirrorPoint = 195;      
      // loop from row 160 to just the mirror point
      for (int row = 160; row <= mirrorPoint; row++)
      {
         // loop from column 239 to 293
         for (int col = 239; col <= 293; col++)
         {       
            topPixel = pixels[row][col];      
            botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
            botPixel.setColor(topPixel.getColor());
         }
      }
   }
   
   public void mirrorGull()
   {
      int mirrorPoint = 344;
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int count = 0;
      Pixel[][] pixels = this.getPixels2D();
      
      // loop through the rows
      for (int row = 234; row < 322; row++)
      {
         // loop from 13 to just before the mirror point
         for (int col = 237; col < mirrorPoint; col++)
         {
            
            leftPixel = pixels[row][col];      
            rightPixel = pixels[row]                       
                              [mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
         }
      }
   }
   
   /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
   public void copy(Picture fromPic, 
                  int startRow, int startCol)
   {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow; 
            fromRow < fromPixels.length &&
            toRow < toPixels.length; 
            fromRow++, toRow++)
      {
         for (int fromCol = 0, toCol = startCol; 
               fromCol < fromPixels[0].length &&
               toCol < toPixels[0].length;  
               fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }   
   }
   
   public void copy(Picture fromPic, int startRow, int startCol, int copyStartRow, int copyEndRow,int copyStartCol, int copyEndCol)
   {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = copyStartRow; fromRow < copyEndRow && 
         toRow < toPixels.length; fromRow++, toRow++)
      {
         for (int fromCol = copyStartRow, toCol = startCol; fromCol < copyEndRow &&
               toCol < toPixels[0].length; fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }   
   }

   /** Method to create a collage of several pictures */
   public void createCollage()
   {
      Picture flower1 = new Picture("flower1.jpg");
      Picture flower2 = new Picture("flower2.jpg");
      this.copy(flower1,0,0);
      this.copy(flower2,100,0);
      this.copy(flower1,200,0);
      Picture flowerNoBlue = new Picture(flower2);
      flowerNoBlue.zeroBlue();
      this.copy(flowerNoBlue,300,0);
      this.copy(flower1,400,0);
      this.copy(flower2,500,0);
      this.mirrorVertical();
      this.write("collage.jpg");
   }
   
   public void myCollage()
   {
      Picture matrixCode = new Picture ("matrix-code-160x120.jpg");
      Picture matrixCodeNeg = new Picture (matrixCode);
      Picture matrixCodeRed = new Picture (matrixCode);
      Picture matrixCodeGreen = new Picture (matrixCode);
      Picture matrixCodeBlue = new Picture (matrixCode);
      matrixCodeNeg.negate();
      matrixCodeRed.keepOnlyRed();
      matrixCodeGreen.keepOnlyGreen();
      matrixCodeBlue.keepOnlyBlue();
      
      this.copy (matrixCodeNeg,120,160);
      this.copy (matrixCodeRed,0,160);
      this.copy (matrixCodeGreen,120,0);
      this.copy (matrixCodeBlue,0,0);
      
      this.mirrorVertical();
      this.mirrorHorizontal();
      this.write("collage.jpg");
   }
   
   /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
   public void edgeDetection(int edgeDist)
   {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      Color rightColor = null;
      for (int row = 0; row < pixels.length; row++)
      {
         for (int col = 0; 
               col < pixels[0].length-1; col++)
         {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            rightColor = rightPixel.getColor();
            if (leftPixel.colorDistance(rightColor) > 
                 edgeDist)
               leftPixel.setColor(Color.BLACK);
            else
               leftPixel.setColor(Color.WHITE);
         }
      }
   }
   
   public void edgeDetection2(int edgeDist)
   {
      Pixel topPixel = null;
      Pixel botPixel = null;
      Pixel[][] pixels = this.getPixels2D();
      Color botColor = null;
      for (int row = 0; row < pixels.length-1; row++)
      {
         for (int col = 0; col < pixels[0].length; col++)
         {
            topPixel = pixels[row][col];
            botPixel = pixels[row+1][col];
            botColor = botPixel.getColor();
            if (topPixel.colorDistance(botColor) > edgeDist)
               topPixel.setColor(Color.BLACK);
            else
               topPixel.setColor(Color.WHITE);
         }
      }
   }
   
   public String mostCommonColor()
   {
      ArrayList<Pixel> arrListP = new ArrayList<Pixel>();
      ArrayList<String> arrListS = new ArrayList<String>();
      Pixel pixel = null;
      Pixel[][] pixels = this.getPixels2D();
      Color color = null;
      for (int row = 0; row < pixels.length; row++)
      {
         for (int col = 0; col < pixels[0].length; col++)
         {
            String currPix = "";
            int pixCol;
            
            pixCol=pixels[row][col].getRed();
            if(pixCol>=100)
               currPix+=pixCol;
            else if (pixCol>=10) {
               currPix+="0";
               currPix+=pixCol;
            }
            else {
               currPix+="00";
               currPix+=pixCol;
            }
            currPix+=" ";
            
            pixCol=pixels[row][col].getGreen();
            if(pixCol>=100)
               currPix+=pixCol;
            else if (pixCol>=10) {
               currPix+="0";
               currPix+=pixCol;
            }
            else {
               currPix+="00";
               currPix+=pixCol;
            }
            currPix+=" ";
                           
            pixCol=pixels[row][col].getBlue();
            if(pixCol>=100)
               currPix+=pixCol;
            else if (pixCol>=10) {
               currPix+="0";
               currPix+=pixCol;
            }
            else {
               currPix+="00";
               currPix+=pixCol;
            }
            
            arrListS.add(currPix);
         }
      }
      Collections.sort(arrListS);
      
      String currPix=arrListS.get(0);
      String commPix1=arrListS.get(0);
      String commPix2=arrListS.get(1);
      int commNum1=1;
      int commNum2=1;
      int currNum=1;
      for (int i=2;i<arrListS.size();i++)
      {
         if(currPix.equals(arrListS.get(i))){
            currNum+=1;
         }
         else {
            currPix=arrListS.get(i);
            if (currNum>commNum1) {
               commNum2=commNum1;
               commNum1=currNum;
               currNum=1;
               commPix2=commPix1;
               commPix1=currPix;
            } else if (currNum>commNum2) {
               commNum2=currNum;
               currNum=1;
               commPix2=currPix;
            }
         }
      }
      if (currNum>commNum1) {
         commNum2=commNum1;
         commNum1=currNum;
         currNum=1;
         commPix2=commPix1;
         commPix1=currPix;
      } else if (currNum>commNum2) {
         commNum2=currNum;
         currNum=1;
         commPix2=currPix;
      }
      return commPix1+" "+commPix2;
   }
   
    public String output (String colour) {
        String first = "";
        String second = "";
        int r1 = Integer.parseInt(colour.substring(0,3));
        int g1 = Integer.parseInt(colour.substring(4,7));
        int b1 = Integer.parseInt(colour.substring(8,11));
        int r2 = Integer.parseInt(colour.substring(12,15));
        int g2 = Integer.parseInt(colour.substring(16,19));
        int b2 = Integer.parseInt(colour.substring(20));
        
        if(r1 == 0 && g1 == 0 && b1 == 0)
            first = "This ad primarily features the colour white("+r1+","+g1+","+b1+"), this will portray balance, neutrality and calmness. ";
        if(r2 == 0 && g2 == 0 && b2 == 0)
            first = "This ads second most featured colour is white("+r2+","+g2+","+b2+"), which portrays balance, neutrality and calmness.";
        
        double h1, min1, max1, d1;
        double h2, min2, max2, d2;
    
        min1 = Math.min(Math.min(r1, g1), b1);
        max1 = Math.max(Math.max(r1, g1), b1);

        d1 = max1 - min1;
         if(r1 == max1)
            h1 = (g1 - b1) / d1;
         else if(g1 == max1)
            h1 = 2 + (b1 - r1) / d1; 
         else
            h1 = 4 + (r1 - g1) / d1;
         h1 *= 60;   
         
        if(h1 < 0)
            h1 += 360;
        
        if(h1 >= 0 && h1 < 30 || h1 >= 330 && h1 < 360)
            first = "This ad primarily features the colour red("+r1+","+g1+","+b1+"), this will portray excitement, youthfulness and boldness. ";
        else if(h1 >= 30 && h1 < 60)
            first = "This ad primarily features the colour orange("+r1+","+g1+","+b1+"), this will portray friendliness, cheerfulness and confidence. ";
        else if(h1 >= 60 && h1 < 90)
            first = "This ad primarily features the colour yellow("+r1+","+g1+","+b1+"), this will portray optimism, clarity and warmth. ";
        else if(h1 >= 90 && h1 < 180)
            first = "This ad primarily features the colour green("+r1+","+g1+","+b1+"), this will portray peacefulness, growth and health. ";
        else if(h1 >= 270 && h1 < 330)
            first = "This ad primarily features the colour purple("+r1+","+g1+","+b1+"), this will portray creativity, imagination and wiseness. ";
        else if(h1 >= 180 && h1 < 270)
            first = "This ad primarily features the colour blue("+r1+","+g1+","+b1+"), this will portray trust, dependability and strength. ";
        
        min2 = Math.min(Math.min(r2, g2), b2);
        max2 = Math.max(Math.max(r2, g2), b2);

        d2 = max2 - min2;
         if(r2 == max2)
            h2 = (g2 - b2) / d2;
         else if(g2 == max2)
            h2 = 2 + (b2 - r2) / d2; 
         else
            h2 = 4 + (r2 - g2) / d2;
         h2 *= 60;   
         
        if(h2 < 0)
            h2 += 360;
        
        if(h2 >= 0 && h2 < 30 || h2 >= 330 && h2 < 360)
            second = "This ad's second most featured colour is red("+r2+","+g2+","+b2+"), which portrays excitement, youthfulness and boldness.";
        else if(h2 >= 30 && h2 < 60)
            second = "This ad's second most featured colour is orange("+r2+","+g2+","+b2+"), which portrays friendliness, cheerfulness and confidence.";
        else if(h2 >= 60 && h2 < 90)
            second = "This ad's second most featured colour is yellow("+r2+","+g2+","+b2+"), which portrays optimism, clarity and warmth.";
        else if(h2 >= 90 && h2 < 180)
            second = "This ad's second most featured colour is green("+r2+","+g2+","+b2+"), which portrays peacefulness, growth and health.";
        else if(h2 >= 270 && h2 < 330)
            second = "This ad's second most featured colour is purple("+r2+","+g2+","+b2+"), which portrays creativity, imagination and wiseness.";
        else if(h2 >= 180 && h2 < 270)
            second = "This ad's second most featured colour is blue("+r2+","+g2+","+b2+"), which portrays trust, dependability and strength.";
        
        return first + "\n" + second;
     }
}
