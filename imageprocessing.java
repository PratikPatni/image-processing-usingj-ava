
import edu.duke.*;
import java.io.*;
public class imageprocessing
{
    public ImageResource greyscale(ImageResource inImage)
    {
     ImageResource outImage =  new ImageResource(inImage.getWidth(),inImage.getHeight()) ;  
    for(Pixel pixel:outImage.pixels())
    {
        Pixel p= inImage.getPixel(pixel.getX(),pixel.getY());
        int avg = (p.getRed()+p.getGreen()+p.getBlue())/3;
        pixel.setRed(avg);
        pixel.setBlue(avg);
        pixel.setGreen(avg);
    }
    return(outImage);
    }
    public ImageResource inverted(ImageResource inImage)
    {
     ImageResource outImage =  new ImageResource(inImage.getWidth(),inImage.getHeight()) ;  
    for(Pixel pixel:outImage.pixels())
    {
        Pixel p= inImage.getPixel(pixel.getX(),pixel.getY());
        pixel.setRed(255-p.getRed());
        pixel.setGreen(255-p.getGreen());
        pixel.setBlue(255-p.getBlue());
    }
   return outImage; 
}
    public void greyscaleConverter()
    {
    DirectoryResource dr = new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
    ImageResource inImage =  new ImageResource(f);
    ImageResource grey = greyscale(inImage);
    String fname = inImage.getFileName();
    String greyImage = "greyscale-"+fname;
    grey.setFileName(greyImage);
    grey.save();
    grey.draw();
    }
    }
    public void imageInverter()
    {
    DirectoryResource dr = new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
    ImageResource inImage =  new ImageResource(f);
    ImageResource inv = inverted(inImage);
    String fname = inImage.getFileName();
    String invImage = "inverted-"+fname;
    inv.setFileName(invImage);
    inv.save();
    inv.draw();
    }
}
}
