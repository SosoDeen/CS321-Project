/** Example of using unit tests for this assignment.  To run them on the command line, make
* sure that the junit-cs211.jar is in the same directory.
* junit-cs211.jar is a version of JUnit 4
*
* On windows replace colons with semicolons: (: with ;)
*  javac -cp .;junit-cs211.jar *.java   # compile everything
*  java -cp .;junit-cs211.jar E2Tester  # run tests
*/
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.lang.reflect.*;

public class E2Tester {
  // starting test values, be sure to add more
  public static final Object[][][] TEST_VALUES = {
    // shape manager test value
    // passing tests:
    //0 SM
    { {MeasuringUnit.METERS, 1},
      {MeasuringUnit.METERS, 1, 1},
      {MeasuringUnit.METERS, 2},
      {MeasuringUnit.METERS, 2, 3},
      {MeasuringUnit.METERS, 3, 3 } }, // 1 + 1 + 4 + 6 + 9
    //1 SM
    { {MeasuringUnit.FEET, 100},
      {MeasuringUnit.METERS, 2, 3},
      {MeasuringUnit.METERS, 2} },  //3048 + 6 + 4
    //2 SM
    { {MeasuringUnit.FEET, 100},
      {MeasuringUnit.METERS, 254, 12},
      {MeasuringUnit.METERS, 127, 24} }, // 10000 + (converted)10000 + (converted)10000, 3048 + 3048 + 3048
    //3 SQ
    { {MeasuringUnit.FEET, 3}}, // 9
    //4 RC
    { {MeasuringUnit.METERS, 24, 15}}, // 360
    //5 RC
    { {MeasuringUnit.FEET, 100, 100}}, // 10000, 3048, 10000

    // failing tests:
    //6
    null,
    //7
    {null},
    //8
    {{0}},
    //9
    { {null, 10},
      {MeasuringUnit.METERS, 3, 16},
      {MeasuringUnit.METERS, 5} },
    //10
    { {MeasuringUnit.FEET, -1},
      {MeasuringUnit.METERS, 3, 16},
      {MeasuringUnit.METERS, 5} },
    //11
    {
      {MeasuringUnit.METERS, 4, 6},
      {MeasuringUnit.FEET, null},
      {MeasuringUnit.METERS, 68,28}
    },
    //12
    { {MeasuringUnit.FEET, 9},
      {MeasuringUnit.METERS, 2, 3},
      {MeasuringUnit.METERS, 2} },
    //13
    { {MeasuringUnit.FEET, 15, 50}},
    //14
    { {MeasuringUnit.FEET, Integer.MAX_VALUE, 100}},
    //15
    { {MeasuringUnit.METERS, Integer.MAX_VALUE}},
    //16
    { {MeasuringUnit.FEET, -3}},
    //17
    { {MeasuringUnit.FEET, 6}},
    //18
    { {null, 6}},
    //19
    { {null, 24, 15}},
    //20
    { {MeasuringUnit.METERS, -3, 15}},


  };
  // same goes for the expected results
  public static final Object[][] EXPECTED_RESULTS ={
    //0
    { 21l,
      "[Square: {_side: 1, side: 1}, Rectangle: {otherSide: 1, side: 1}, Square: {_side: 2, side: 2}, Rectangle: {otherSide: 3, side: 2}, Rectangle: {otherSide: 3, side: 3}]" },
    //1
    { 3058l, "[Square: {_side: 100, side: 100}, Rectangle: {otherSide: 3, side: 2}, Square: {_side: 2, side: 2}]"},
    //2
    { 30000L, 9144L, "[Square: {_side: 100, side: 100}, Rectangle: {otherSide: 12, side: 254}, Rectangle: {otherSide: 24, side: 127}]"},
    //3
    { 9, 5, MeasuringUnit.FEET, "Square: {_side: 5, side: 3}"},
    //4
    { 360l, "Rectangle: {otherSide: 15, side: 24}"},
    //5
    { 10000l, MeasuringUnit.METERS, "Rectangle: {otherSide: 100, side: 100}"},
    //6 exceptions
    { 0l, null},
    //7
    { 36, -16, MeasuringUnit.FEET, "Square: {_side: 5, side: 3}"}
  };
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E2Tester");
  }




  // TESTS


  

  // TESTS BASIC SHAPE MANGER METHODS
  public static void testShapeManager(Object[][] values, long totalArea, String shapeState) throws CheckedRuntimeException{
    ShapeManager sm = new ShapeManager(values);
    AreaCalculator ac  = sm;
    long currentResult = ac.getTotalArea();

    //System.out.println("\nSHAPE MANAGER TEST");
    assertTrue("Incorrect total. area: "+currentResult+", expected: "+ totalArea,  currentResult== totalArea);
    String currentShapeState = Arrays.deepToString(sm.getShapes());
    assertTrue("Incorrect shapes state: \n"+currentShapeState+" \nexpected: \n"+ shapeState,  currentShapeState.equals(shapeState));
  }

  // TESTS SHAPE MANAGER TOTAL AREA WITH CONVERSIONS
  public static void testShapeManager_ConvertedTotalArea(Object[][] values, long totalArea, long convArea, String shapeState, MeasuringUnit unit, MeasuringUnit unit2) throws CheckedRuntimeException{
    ShapeManager sm = new ShapeManager(values);
    AreaCalculator ac  = sm;
    long currentResult = ac.getTotalArea(unit);
    long convertedResult = ac.getTotalArea(unit2);

    //System.out.println("\nSHAPE MANAGER CONVERSION TEST");
    assertTrue("Incorrect total. area: "+currentResult+", expected: "+ totalArea,  currentResult == totalArea);
    assertTrue("Incorrect total. area: "+convertedResult+", expected: "+ convArea,  convertedResult == convArea);
    String currentShapeState = Arrays.deepToString(sm.getShapes());
    assertTrue("Incorrect shapes. state: \n"+currentShapeState+" \nexpected: \n"+ shapeState,  currentShapeState.equals(shapeState));
  }

  // TESTS SQUARE METHODS + SHAPE METHODS
  public static void testSquare(Object[][] values, int totalArea, Integer setSide, String squareState) throws CheckedRuntimeException{
    ShapeManager sm = new ShapeManager(values);
    Square sq = (Square)sm.shapes[0];
    MeasuringUnit unit = (MeasuringUnit)values[0][0];
    int side = (int)values[0][1];

    // Shape method
    MeasuringUnit currentUnit = sq.getMeasuringUnit();

    // Square methods
    int currentTotal = sq.getArea();
    sq.setSide(setSide); // tests that side can be changed
    int currentSide = sq.getSide();
    String currentSquareState = sq.toString();

    //System.out.println("\nSQUARE TEST");
    assertTrue("Incorrect total. area: "+currentTotal+", expected: "+ totalArea,  currentTotal == totalArea);
    assertTrue("Incorrect total. area: "+currentSide+", expected: "+ side,  currentSide == side);
    assertTrue("Incorrect unit. unit: "+currentUnit+", expected: "+ unit,  currentUnit == unit);
    assertTrue("Incorrect square. state: "+currentSquareState+", expected: "+ squareState,  currentSquareState.equals(squareState));
  }

  // TESTS RECTANGLE METHODS + SHAPE METHODS
  public static void testRect(Object[][] values, long totalArea, String rectState) throws CheckedRuntimeException{
    ShapeManager sm = new ShapeManager(values);
    Rectangle rect = (Rectangle)sm.shapes[0];
    MeasuringUnit unit = (MeasuringUnit)values[0][0];
    int side = (int)values[0][1];

    // Shape method
    MeasuringUnit currentUnit = rect.getMeasuringUnit();

    // Rectangle methods
    int currentTotal = rect.getArea();
    long currentSide = rect.getSide();
    long currentArea = rect.getTotalArea();
    String currentRectState = rect.toString();

    //System.out.println("\nRECTANGLE TEST");
    assertTrue("Incorrect total. area: "+currentTotal+", expected: "+ totalArea,  currentTotal == totalArea);
    assertTrue("Incorrect total. area: "+currentArea+", expected: "+ totalArea,  currentArea == totalArea);
    assertTrue("Incorrect total. side: "+currentSide+", expected: "+ side,  currentSide == side);
    assertTrue("Incorrect unit. unit: "+currentUnit+", expected: "+ unit,  currentUnit == unit);
    assertTrue("Incorrect rectangle. state: "+currentRectState+", expected: "+ rectState,  currentRectState.equals(rectState));
  }

  // TESTS RECTANGLE CONVERSION METHODS + SHAPE METHODS
  public static void testRect_ConvertedArea(Object[][] values, long totalArea, MeasuringUnit unit, String rectState) throws CheckedRuntimeException{
    ShapeManager sm = new ShapeManager(values);
    Rectangle rect = (Rectangle)sm.shapes[0];
    MeasuringUnit baseUnit = (MeasuringUnit)values[0][0];
    int side = (int)values[0][1];

    // Shape method
    MeasuringUnit currentUnit = rect.getMeasuringUnit();

    // Rectangle methods
    int currentTotal = rect.getArea();
    long currentSide = rect.getSide();
    long convertedArea = rect.getTotalArea(unit); // converts area to other unit
    long currentArea = rect.convertArea(convertedArea, baseUnit); // should return original area
    String currentRectState = rect.toString();

    //System.out.println("\nSHAPE MANAGER TEST");
    assertTrue("Incorrect total. area: "+currentTotal+", expected: "+ totalArea,  currentTotal == totalArea);
    assertTrue("Incorrect total. converted "+unit+" area: "+currentTotal+", expected: "+ totalArea,  currentTotal == totalArea);
    assertTrue("Incorrect total. converted "+unit+" area: "+currentArea+", expected: "+ totalArea,  currentArea == totalArea);
    assertTrue("Incorrect total. side: "+currentSide+", expected: "+ side,  currentSide == side);
    assertTrue("Incorrect unit. unit: "+currentUnit+", expected: "+ baseUnit,  currentUnit == baseUnit);
    assertTrue("Incorrect rectangle. state: "+currentRectState+", expected: "+ rectState,  currentRectState.equals(rectState));
  }



  //TESTING



  // passes
  @Test(timeout=1000) public void shapeManagerGetTotalArea_00() {
    try{
      //System.out.println("\nSHAPE MANAGER00 TEST");
      testShapeManager(
      E2Tester.TEST_VALUES[0],
      (long) E2Tester.EXPECTED_RESULTS[0][0],
      (String) E2Tester.EXPECTED_RESULTS[0][1]
      );
    }catch(CheckedRuntimeException e){
      System.out.println("no work lol haha yur error do: " + e.getMessage());
    }finally{
      // YOLO
    }
  }

  // passes: tests shapes with different units (converts to default)
  @Test(timeout=1000) public void shapeManagerGetTotalArea_01() {
    try{
      //System.out.println("\nSHAPE MANAGER01 TEST");
      testShapeManager(
      E2Tester.TEST_VALUES[1],
      (long) E2Tester.EXPECTED_RESULTS[1][0],
      (String) E2Tester.EXPECTED_RESULTS[1][1]
      );
    }catch(CheckedRuntimeException e){
      System.out.println(e.getMessage());
    }finally{
    }
  }

  // passes: tests converting area both ways
  @Test(timeout=1000) public void shapeManagerGetConvertedTotalArea_00() {
    try{
      //System.out.println("\nSHAPE MANAGER CONVERSION TEST");
      testShapeManager_ConvertedTotalArea(
      E2Tester.TEST_VALUES[2],
      (long) E2Tester.EXPECTED_RESULTS[2][0],
      (long) E2Tester.EXPECTED_RESULTS[2][1],
      (String) E2Tester.EXPECTED_RESULTS[2][2],
      MeasuringUnit.FEET,
      MeasuringUnit.METERS
      );
    }catch(CheckedRuntimeException e){
      System.out.println(e.getMessage());
    }finally{
    }
  }

  // passes: tests square methods and shape methods
  @Test(timeout=1000) public void squareTest_00() {
    try{
      //System.out.println("\nSQUARE TEST");
      testSquare(
      E2Tester.TEST_VALUES[3],
      (int) E2Tester.EXPECTED_RESULTS[3][0],
      (int) E2Tester.EXPECTED_RESULTS[3][1],
      (String) E2Tester.EXPECTED_RESULTS[3][3]
      );
    }catch(CheckedRuntimeException e){
      System.out.println(e.getMessage());
    }finally{
    }
  }

  // passes: tests rect methods and shape methods
  @Test(timeout=1000) public void RectTest_00() {
    try{
      //System.out.println("\nRECT TEST");
      testRect(
      E2Tester.TEST_VALUES[4],
      (long) E2Tester.EXPECTED_RESULTS[4][0],
      (String) E2Tester.EXPECTED_RESULTS[4][1]
      );
    }catch(CheckedRuntimeException e){
      System.out.println(e.getMessage());
    }finally{
    }
  }

  // passes: test rectangle area conversion both ways
  @Test(timeout=1000) public void RectTestConverted_00() {
    try{
      //System.out.println("\nRECT CONVERSION TEST");
      testRect_ConvertedArea(
      E2Tester.TEST_VALUES[5],
      (long) E2Tester.EXPECTED_RESULTS[5][0],
      (MeasuringUnit) E2Tester.EXPECTED_RESULTS[5][1],
      (String) E2Tester.EXPECTED_RESULTS[5][2]
      );
    }catch(CheckedRuntimeException e){
      System.out.println(e.getMessage());
    }finally{
    }
  }

  // fails: tests null testValues[]
  @Test(expected=ShapeException.class) public void failShapeManager_00() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[6],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests null testvalues[] shape
  @Test(expected=ShapeException.class) public void failShapeManager_01() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[7],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests incomplete testvalues[] shape values
  @Test(expected=ShapeException.class) public void failShapeManager_02() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[8],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests invalid unit
  @Test(expected=MeasuringUnitException.class) public void failShapeManager_03() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[9],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests invalid testValues[] length
  @Test(expected=ShapeException.class) public void failShapeManager_04() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[10],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests null testValues[] shape value with correct unit
  @Test(expected=ShapeException.class) public void failShapeManager_05() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[11],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests area calulator overflow
  @Test(expected=AreaCalculatorException.class) public void failShapeManager_06() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[12],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests area calulator overflow
  @Test(expected=AreaCalculatorException.class) public void failShapeManager_07() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testShapeManager(
      E2Tester.TEST_VALUES[14],
      (long) E2Tester.EXPECTED_RESULTS[6][0],
      (String) E2Tester.EXPECTED_RESULTS[6][1]
    );
  }

  // fails: tests rect area calulator overflow from max value
  @Test(expected=AreaCalculatorException.class) public void failRect_00() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testRect_ConvertedArea(
      E2Tester.TEST_VALUES[13],
      (long) E2Tester.EXPECTED_RESULTS[5][0],
      (MeasuringUnit) E2Tester.EXPECTED_RESULTS[5][1],
      (String) E2Tester.EXPECTED_RESULTS[5][2]
    );
  }

  // fails: tests rect invalid unit
  @Test(expected=MeasuringUnitException.class) public void failRect_01() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testRect_ConvertedArea(
      E2Tester.TEST_VALUES[19],
      (long) E2Tester.EXPECTED_RESULTS[5][0],
      (MeasuringUnit) E2Tester.EXPECTED_RESULTS[5][1],
      (String) E2Tester.EXPECTED_RESULTS[5][2]
    );
  }

  // fails: tests rect invalid input
  @Test(expected=ShapeException.class) public void failRect_03() throws CheckedRuntimeException{
    //System.out.println("\nFAIL TEST");
    testRect_ConvertedArea(
      E2Tester.TEST_VALUES[20],
      (long) E2Tester.EXPECTED_RESULTS[5][0],
      (MeasuringUnit) E2Tester.EXPECTED_RESULTS[5][1],
      (String) E2Tester.EXPECTED_RESULTS[5][2]
    );
  }

    // fails: tests square overflow
  @Test(expected=AreaCalculatorException.class) public void failSquare_00() throws CheckedRuntimeException{
    testSquare(
      E2Tester.TEST_VALUES[15],
      (int) E2Tester.EXPECTED_RESULTS[3][0],
      (int) E2Tester.EXPECTED_RESULTS[3][1],
      (String) E2Tester.EXPECTED_RESULTS[3][3]
    );
  }

  // fails: tests square invalid input
  @Test(expected=ShapeException.class) public void failSquare_01() throws CheckedRuntimeException{
    testSquare(
      E2Tester.TEST_VALUES[16],
      (int) E2Tester.EXPECTED_RESULTS[3][0],
      (int) E2Tester.EXPECTED_RESULTS[3][1],
      (String) E2Tester.EXPECTED_RESULTS[3][3]
    );
  }

    // fails: tests square set side
    @Test(expected=ShapeException.class) public void failSquare_02() throws CheckedRuntimeException{
      testSquare(
        E2Tester.TEST_VALUES[17],
        (int) E2Tester.EXPECTED_RESULTS[7][0],
        (int) E2Tester.EXPECTED_RESULTS[7][1],
        (String) E2Tester.EXPECTED_RESULTS[7][3]
      );
    }

    // fails: tests square invalid unit
    @Test(expected=MeasuringUnitException.class) public void failSquare_03() throws CheckedRuntimeException{
      testSquare(
        E2Tester.TEST_VALUES[18],
        (int) E2Tester.EXPECTED_RESULTS[7][0],
        (int) E2Tester.EXPECTED_RESULTS[7][1],
        (String) E2Tester.EXPECTED_RESULTS[7][3]
      );
    }

  //System.out.println("am i here?");

}