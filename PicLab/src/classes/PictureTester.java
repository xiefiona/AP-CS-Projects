package classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("src/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue(){
    Picture beach = new Picture("src/images/beach.jpg");
    beach.onlyBlue();
    beach.explore();
  }

  public static void testNegate(){
    Picture beach = new Picture("src/images/beach.jpg");
    beach.negate();
    beach.explore();
  }

  public static void testGrayscale(){
    Picture beach = new Picture("src/images/beach.jpg");
    beach.grayScale();
    beach.explore();
  }

  public static void testFixUnderwater(){
    Picture water = new Picture("src/images/water.jpg");
    water.explore();
    water.underwater();
    water.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("src/images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorHorizontal(){
    Picture caterpillar = new Picture("src/images/caterpillar.jpg");
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }

  public static void testMirrorBotToTop(){
    Picture caterpillar = new Picture("src/images/caterpillar.jpg");
    caterpillar.mirrorBotToTop();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("src/images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms(){
    Picture snow = new Picture("src/images/snowman.jpg");
    snow.mirrorArms();
    snow.explore();
  }

  public static void testMirrorGull(){
    Picture gull = new Picture("src/images/seagull.jpg");
    gull.mirrorGull();
    gull.explore();
  }

  public static void testMirrorDiagonal(){
    Picture gull = new Picture("src/images/seagull.jpg");
    gull.mirrorDiagonal();
    gull.explore();
  }

  public static void testCopy(){
    Picture pug = new Picture("src/images/Baby_pug.jpg");
    pug.explore();
    pug.copy(new Picture("src/images/caterpillar.jpg"),0,50,0,100);
    pug.explore();
  }


  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("src/images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src/images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testEdgeDetection2(){
    Picture swan = new Picture("src/images/swan.jpg");
    swan.edgeDetection2(10);
    swan.explore();
  }

  /** Main method for testing.  Every class can have a main
   * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorHorizontal();
    testMirrorBotToTop();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testMirrorDiagonal();
    testCollage();
    testCopy();
    testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}