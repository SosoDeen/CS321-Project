import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import java.io.File;
import java.util.Iterator;

/** Example of using unit tests for this assignment.  To run them on the command line, make
* sure that the junit-cs211.jar is in the same directory.
* junit-cs211.jar is a version of JUnit 4
*
* On windows replace colons with semicolons: (: with ;)
*  javac -cp .;junit-cs211.jar *.java   # compile everything
*  java -cp .;junit-cs211.jar Tester  # run tests
*/

public class E3Tester {
  private String errorMessage1 = "iterator returns incorrect element";
  private String errorMessage2 = "Iterator crashed. Maybe because of a file I/O error or an incorrect number of iterations";
  
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("Tester");
  }

  // double for-loop that doesn't skip anything
  @Test(timeout=1000)
  public void test_1()
  {
    String[] expected = {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "veritas", "w6", "w7", "w8", "w9", "moribus", "w11", "inmaturitas", "w13", "w14", "w15", "malignus", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "veritas", "w2", "w3", "w4", "w5", "moribus", "w7", "inmaturitas", "malignus", "w10", "w11", "w12", "w13", "w14"};
    try
    {
      File fp = new File("test1.dat");
      ReviewList list = new ReviewList(fp);
      int index = 0;
      for (Review r : list)
          for (String s : r)
              assertEquals(errorMessage1, expected[index++], s);
    }
    catch(Exception e)
    {
      fail(errorMessage2);
    }
  }

  // double while-loop that doesn't skip anything
  @Test(timeout=1000)
  public void test_2()
  {
    String[] expected = {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "veritas", "w6", "w7", "w8", "w9", "moribus", "w11", "inmaturitas", "w13", "w14", "w15", "malignus", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "veritas", "w2", "w3", "w4", "w5", "moribus", "w7", "inmaturitas", "malignus", "w10", "w11", "w12", "w13", "w14"};
    try
    {
      File fp = new File("test1.dat");
      ReviewList list = new ReviewList(fp);
      int index = 0;
      Iterator<Review> it1 = list.iterator();
      while(it1.hasNext())
      {
          Review r = it1.next();
          Iterator<String> it2 = r.iterator(false);
          while(it2.hasNext())
              assertEquals(errorMessage1, expected[index++], it2.next());
      }
    }
    catch(Exception e)
    {
      fail(errorMessage2);
    }
  }

  // double loop that iterates over all reviews and skips the suspicious words in them
  @Test(timeout=1000)
  public void test_3()
  {
    String[] expected = {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "w6", "w7", "w8", "w9", "w11", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w2", "w3", "w4", "w5", "w7", "w10", "w11", "w12", "w13", "w14"};
    try
    {
      File fp = new File("test1.dat");
      ReviewList list = new ReviewList(fp);
      int index = 0;
      for (Review r : list)
      {
          Iterator<String> it2 = r.iterator(true);
          while(it2.hasNext())
              assertEquals(errorMessage1, expected[index++], it2.next());
      }
    }
    catch(Exception e)
    {
      fail(errorMessage2);
    }
  }

  // double loop that skips the suspicious reviews and iterates over all the words in the non-suspicious reviews
  @Test(timeout=1000)
  public void test_4()
  {
    String[] expected = {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "veritas", "w6", "w7", "w8", "w9", "moribus", "w11", "inmaturitas", "w13", "w14", "w15", "malignus", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11"};
    try
    {
      File fp = new File("test1.dat");
      ReviewList list = new ReviewList(fp);
      int index = 0;
      Iterator<Review> it1 = list.iterator(true);
      while(it1.hasNext())
      {
          Review r = it1.next();
          for (String s : r)
              assertEquals(errorMessage1, expected[index++], s);
      }
    }
    catch(Exception e)
    {
      fail(errorMessage2);
    }
  }

  // double loop that skips the suspicious reviews and the suspicious words in the non-suspicious reviews
  @Test(timeout=1000)
  public void test_5()
  {
    String[] expected = {"w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11", "w12", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "w6", "w7", "w8", "w9", "w11", "w13", "w14", "w15", "w1", "w2", "w3", "w4", "w5", "w6", "w7", "w8", "w9", "w10", "w11"};
    try
    {
      File fp = new File("test1.dat");
      ReviewList list = new ReviewList(fp);
      int index = 0;
      Iterator<Review> it1 = list.iterator(true);
      while(it1.hasNext())
      {
          Review r = it1.next();
          Iterator<String> it2 = r.iterator(true);
          while(it2.hasNext())
              assertEquals(errorMessage1, expected[index++], it2.next());
      }
    }
    catch(Exception e)
    {
      fail(errorMessage2);
    }
  }

}
