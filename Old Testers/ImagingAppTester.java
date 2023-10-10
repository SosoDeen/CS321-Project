import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.lang.reflect.*;
import java.io.File;

public class ImagingAppTester {


  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("ImagingAppTester");
  }

  public static void checkImagesEqual(String outputFilepath, String targetFilepath){
    Comparator c = new Comparator(outputFilepath, targetFilepath);
    
    String msgFileNotFound = c.getFileNotFoundMsg();
    assertTrue(msgFileNotFound, msgFileNotFound.equals(""));

    String msgFileFormatDiff = c.getFileFormatDiffMsg();
    String msgDimensionDiff = c.getDimensionDiffMsg();
    String msgPixelsDiff = c.getPixelsDiffMsg();
    assertTrue(msgFileFormatDiff, msgFileFormatDiff.equals(""));
    assertTrue(msgDimensionDiff, msgDimensionDiff.equals(""));
    assertTrue(msgPixelsDiff, msgPixelsDiff.equals(""));
  }


  
  public static void checkScale(String inputFilepath, String outputFilepath, String targetFilepath, int factor){
    String[] args = {inputFilepath, outputFilepath, "scale", String.valueOf(factor)};
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    checkImagesEqual(outputFilepath, targetFilepath);
  }
  
/*
  public static void checkScaleUpAndDown(String inputFilepath, String outputFilepath, String targetFilepath, int factor, String tmpFilePath){
    String[] args;
    args = new String[]{inputFilepath, tmpFilePath, "scale", String.valueOf(factor)};
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    args = new String[]{tmpFilePath, outputFilepath, "scale", String.valueOf(-1 * factor)};
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    File myFile = new File(tmpFilePath);
    myFile.delete();
    
    checkImagesEqual(outputFilepath, targetFilepath);
  }
  // PGM
  @Test(timeout=1000) public void checkScale_00(){checkScale(
    "images/scale_test/gmu.pgm",
    "images/scale_test/gmu_scale_up_2.pgm",
    "images/scale_test/gmu_scale_up_2_target.pgm",
    2
  );}
  @Test(timeout=1000) public void checkScale_01(){checkScale(
    "images/scale_test/gmu.pgm",
    "images/scale_test/gmu_scale_up_4.pgm",
    "images/scale_test/gmu_scale_up_4_target.pgm",
    4
  );}
  @Test(timeout=1000) public void checkScale_02(){checkScale(
    "images/scale_test/gmu.pgm",
    "images/scale_test/gmu_scale_down_2.pgm",
    "images/scale_test/gmu_scale_down_2_target.pgm",
    -2
  );}
  @Test(timeout=1000) public void checkScale_03(){checkScale(
    "images/scale_test/gmu.pgm",
    "images/scale_test/gmu_scale_down_4.pgm",
    "images/scale_test/gmu_scale_down_4_target.pgm",
    -4
  );}
  @Test(timeout=1000) public void checkScale_04(){checkScaleUpAndDown(
    "images/scale_test/gmu.pgm",
    "images/scale_test/gmu_scale_up_down_2.pgm",
    "images/scale_test/gmu_scale_up_down_2_target.pgm",
    2,
    "images/scale_test/gmu_tmp.pgm"
  );}
  // PPM
  @Test(timeout=1000) public void checkScale_05(){checkScale(
    "images/scale_test/giraffe.ppm",
    "images/scale_test/giraffe_scale_up_2.ppm",
    "images/scale_test/giraffe_scale_up_2_target.ppm",
    2
  );}
  @Test(timeout=1000) public void checkScale_06(){checkScale(
    "images/scale_test/giraffe.ppm",
    "images/scale_test/giraffe_scale_up_4.ppm",
    "images/scale_test/giraffe_scale_up_4_target.ppm",
    4
  );}
  @Test(timeout=1000) public void checkScale_07(){checkScale(
    "images/scale_test/giraffe.ppm",
    "images/scale_test/giraffe_scale_down_2.ppm",
    "images/scale_test/giraffe_scale_down_2_target.ppm",
    -2
  );}
  @Test(timeout=1000) public void checkScale_08(){checkScale(
    "images/scale_test/giraffe.ppm",
    "images/scale_test/giraffe_scale_down_4.ppm",
    "images/scale_test/giraffe_scale_down_4_target.ppm",
    -4
  );}
  @Test(timeout=1000) public void checkScale_09(){checkScaleUpAndDown(
    "images/scale_test/giraffe.ppm",
    "images/scale_test/giraffe_scale_up_down_2.ppm",
    "images/scale_test/giraffe_scale_up_down_2_target.ppm",
    2,
    "images/scale_test/giraffe_tmp.ppm"
  );}
  */
  
  public static void checkCrop(String inputFilepath, String outputFilepath, String targetFilepath, int topY, int topX, int height, int width){
    String[] args = {
      inputFilepath, 
      outputFilepath, 
      "crop", 
      String.valueOf(topY),
      String.valueOf(topX),
      String.valueOf(height),
      String.valueOf(width),
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    checkImagesEqual(outputFilepath, targetFilepath);
  }
  // PGM
  @Test(timeout=1000) public void checkCrop_00(){checkCrop(
    "images/crop_test/gmu.pgm",
    "images/crop_test/gmu_crop_1.pgm",
    "images/crop_test/gmu_crop_1_target.pgm",
    20,
    36,
    16,
    32
  );}
  @Test(timeout=1000) public void checkCrop_01(){checkCrop(
    "images/crop_test/gmu.pgm",
    "images/crop_test/gmu_crop_2.pgm",
    "images/crop_test/gmu_crop_2_target.pgm",
    32,
    32,
    24,
    16
  );}
  // PPM
  @Test(timeout=1000) public void checkCrop_02(){checkCrop(
    "images/crop_test/giraffe.ppm",
    "images/crop_test/giraffe_crop_1.ppm",
    "images/crop_test/giraffe_crop_1_target.ppm",
    16,
    20,
    16,
    12
  );}
  @Test(timeout=1000) public void checkCrop_03(){checkCrop(
    "images/crop_test/giraffe.ppm",
    "images/crop_test/giraffe_crop_2.ppm",
    "images/crop_test/giraffe_crop_2_target.ppm",
    56,
    32,
    16,
    28
  );}
  @Test(timeout=1000) public void checkCrop_04(){checkCrop(
    "images/crop_test/gmu.pgm",
    "images/crop_test/gmu_crop_3.pgm",
    "images/crop_test/gmu.pgm",
    0,
    0,
    64,
    100
  );}
  @Test(timeout=1000) public void checkCrop_05(){checkCrop(
    "images/crop_test/giraffe.ppm",
    "images/crop_test/giraffe_crop_3.ppm",
    "images/crop_test/giraffe.ppm",
    0,
    0,
    100,
    76
  );}

  /*
  public static void checkFlip(String inputFilepath, String outputFilepath, String targetFilepath, String direction){
    String[] args = {
      inputFilepath, 
      outputFilepath, 
      "flip", 
      direction
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    checkImagesEqual(outputFilepath, targetFilepath);
  }

  public static void checkFlipAllDirections(String inputFilepath, String outputFilepath, String targetFilepath, String tmpFilePath){
    String[] args = {
      inputFilepath, 
      tmpFilePath, 
      "flip", 
      "vertical"
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    args = new String[]{
      tmpFilePath, 
      outputFilepath, 
      "flip", 
      "horizontal"
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }

    File myFile = new File(tmpFilePath);
    myFile.delete();

    checkImagesEqual(outputFilepath, targetFilepath);
  }

  // PGM
  @Test(timeout=1000) public void checkFlip_00(){checkFlip(
    "images/flip_test/gmu.pgm",
    "images/flip_test/gmu_flip_vertical.pgm",
    "images/flip_test/gmu_flip_vertical_target.pgm",
    "vertical"
  );}
  @Test(timeout=1000) public void checkFlip_01(){checkFlip(
    "images/flip_test/gmu.pgm",
    "images/flip_test/gmu_flip_horizontal.pgm",
    "images/flip_test/gmu_flip_horizontal_target.pgm",
    "horizontal"
  );}
  @Test(timeout=1000) public void checkFlip_02(){checkFlipAllDirections(
    "images/flip_test/gmu.pgm",
    "images/flip_test/gmu_flip_vertical_horizontal.pgm",
    "images/flip_test/gmu_flip_vertical_horizontal_target.pgm",
    "images/flip_test/gmu_tmp.pgm"
  );}
  // PPM
  @Test(timeout=1000) public void checkFlip_03(){checkFlip(
    "images/flip_test/giraffe.ppm",
    "images/flip_test/giraffe_flip_vertical.ppm",
    "images/flip_test/giraffe_flip_vertical_target.ppm",
    "vertical"
  );}
  @Test(timeout=1000) public void checkFlip_04(){checkFlip(
    "images/flip_test/giraffe.ppm",
    "images/flip_test/giraffe_flip_horizontal.ppm",
    "images/flip_test/giraffe_flip_horizontal_target.ppm",
    "horizontal"
  );}
  @Test(timeout=1000) public void checkFlip_05(){checkFlipAllDirections(
    "images/flip_test/giraffe.ppm",
    "images/flip_test/giraffe_flip_vertical_horizontal.ppm",
    "images/flip_test/giraffe_flip_vertical_horizontal_target.ppm",
    "images/flip_test/giraffe_tmp.ppm"
  );}
*/

/* 
  public static void checkRotate(String inputFilepath, String outputFilepath, String targetFilepath, String direction){
    String[] args = {
      inputFilepath, 
      outputFilepath, 
      "rotate", 
      direction
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    checkImagesEqual(outputFilepath, targetFilepath);
  }

  public static void checkRotateAllDirections(String inputFilepath, String outputFilepath, String targetFilepath, String tmpFilePath){
    String[] args = {
      inputFilepath, 
      tmpFilePath, 
      "rotate", 
      "clockwise"
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    args = new String[]{
      tmpFilePath, 
      outputFilepath, 
      "rotate", 
      "clockwise"
    };
    try{
      ImagingApp.main(args);
    } catch (Exception e) { }
    
    File myFile = new File(tmpFilePath);
    myFile.delete();

    checkImagesEqual(outputFilepath, targetFilepath);
  }

  // PGM
  @Test(timeout=1000) public void checkRotate_00(){checkRotate(
    "images/rotate_test/gmu.pgm",
    "images/rotate_test/gmu_rotate_1.pgm",
    "images/rotate_test/gmu_rotate_1_target.pgm",
    "clockwise"
  );}
  @Test(timeout=1000) public void checkRotate_01(){checkRotate(
    "images/rotate_test/gmu.pgm",
    "images/rotate_test/gmu_rotate_2.pgm",
    "images/rotate_test/gmu_rotate_2_target.pgm",
    "counterclockwise"
  );}
  @Test(timeout=1000) public void checkRotate_02(){checkRotateAllDirections(
    "images/rotate_test/gmu.pgm",
    "images/rotate_test/gmu_rotate_3.pgm",
    "images/rotate_test/gmu_rotate_3_target.pgm",
    "images/rotate_test/gmu_tmp.pgm"
  );}
  // PPM
  @Test(timeout=1000) public void checkRotate_03(){checkRotate(
    "images/rotate_test/giraffe.ppm",
    "images/rotate_test/giraffe_rotate_1.ppm",
    "images/rotate_test/giraffe_rotate_1_target.ppm",
    "clockwise"
  );}
  @Test(timeout=1000) public void checkRotate_04(){checkRotate(
    "images/rotate_test/giraffe.ppm",
    "images/rotate_test/giraffe_rotate_2.ppm",
    "images/rotate_test/giraffe_rotate_2_target.ppm",
    "counterclockwise"
  );}
  @Test(timeout=1000) public void checkRotate_05(){checkRotateAllDirections(
    "images/rotate_test/giraffe.ppm",
    "images/rotate_test/giraffe_rotate_3.ppm",
    "images/rotate_test/giraffe_rotate_3_target.ppm",
    "images/rotate_test/giraffe_tmp.ppm"
  );}


  // compress tests
  private void testCompress(boolean tileCompression, boolean pixelCompression, String tileC, String pixelC)
  {
    String inputFilepath = "images/compress_test/uncompressed.pgm";
    String outputFilepath = "images/compress_test/compressed.pgm";
    int[][] coord = new int[][]{
      {1, 1, 2, 4,  9,  9, 10},
      {0, 0, 1, 3,  0,  0,  1},
      {2, 3, 3, 5, 10, 11, 11},
      {3, 3, 1, 1,  3,  3,  1}
    };
    Image img = new Image(inputFilepath);
    CompressedImage cImg = img.compress(tileCompression, pixelCompression);

    if (pixelCompression)
    {
      for (int i=0; i<coord[0].length; i++)
      {
        String msg = String.format("Pixels (%d,%d) and (%d,%d) in the uncompressed image must not be aliases but independent objects",coord[0][i],coord[1][i],coord[2][i],coord[3][i]);
        assertNotEquals(msg, img.getPixel(coord[0][i],coord[1][i]).hashCode(), img.getPixel(coord[2][i],coord[3][i]).hashCode());

        msg = String.format("Pixels (%d,%d) and (%d,%d) in the compressed image must be aliases",coord[0][i],coord[1][i],coord[2][i],coord[3][i]);
        assertEquals(msg, cImg.getPixel(coord[0][i],coord[1][i]).hashCode(), cImg.getPixel(coord[2][i],coord[3][i]).hashCode());
      }

      assertNotEquals("Pixels (3,3) and (4,3) in the compressed image must not be aliases", cImg.getPixel(3,3).hashCode(), cImg.getPixel(4,3).hashCode());
    }

    if (tileCompression)
      try
      {
        Field f = cImg.getClass().getDeclaredField("tileArray");
        f.setAccessible(true);
        Tile[] actualValue = (Tile[])f.get(cImg);
        assertEquals("Tiles 0 and 2 are not aliases", actualValue[0].hashCode(), actualValue[2].hashCode());
        assertNotEquals("Tiles 0 and 1 are not aliases", actualValue[0].hashCode(), actualValue[1].hashCode());
        assertNotEquals("Tiles 1 and 2 are not aliases", actualValue[1].hashCode(), actualValue[2].hashCode());
      }
      catch (Exception e)
      {
        fail("The field tileArray is either missing from class CompressedImage or incorrectly named");
      }
  
    String[] args = { inputFilepath, outputFilepath, "compress", tileC, pixelC };
    try
    {
      ImagingApp.main(args);
    }
    catch (Exception e) { }
    
    checkImagesEqual(outputFilepath, inputFilepath);
  }

  @Test(timeout=1000) public void checkCompress_0()
  {
    testCompress(false, false, "no", "no");
  }  

  @Test(timeout=1000) public void checkCompress_1()
  {
    testCompress(false, true, "no", "yes");
  }  

  @Test(timeout=1000) public void checkCompress_2()
  {
    testCompress(true, false, "yes", "no");
  }  

  @Test(timeout=1000) public void checkCompress_3()
  {
    testCompress(true, true, "yes", "yes");
  }  */
}
