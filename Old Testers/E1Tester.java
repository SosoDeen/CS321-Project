
/** Example of using unit tests for this assignment.  To run them on the command line, make
 * sure that the junit-cs211.jar is in the same directory.
 *
 * On Mac/Linux:
 *  javac -cp .:junit-cs211.jar *.java         # compile everything
 *  java -cp .:junit-cs211.jar E1Tester        # run tests
 *
 * On windows replace colons with semicolons: (: with ;)
 *  demo$ javac -cp .;junit-cs211.jar *.java   # compile everything
 *  demo$ java -cp .;junit-cs211.jar E1Tester  # run tests
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.lang.reflect.*;

public class E1Tester {
  public static void main(String args[]){
    org.junit.runner.JUnitCore.main("E1Tester");
  }

  public static void checkField(String cName, String fieldName, String fieldTypeName){
    Class<?> fieldType = null;
    try{
      fieldType = Class.forName(fieldTypeName);
    } catch(ClassNotFoundException cnfe){ }
    assertTrue("Class "+fieldName+" not found", fieldType != null);
    checkField(cName, fieldName, fieldType);
  }

  public static void checkField(String cName, String fieldName, Class<?> fieldType){
    Class<?> c = null;
    Field f = null;
    try{
      c = Class.forName(cName);
      f = c.getDeclaredField(fieldName);
    } catch(ClassNotFoundException cnfe){ } catch(NoSuchFieldException nsfe){ }
    assertTrue("field "+fieldName+" does not exist in class "+c, f!=null);
    assertTrue("field "+fieldName+" is not public in class "+c,Modifier.isPublic(f.getModifiers()));
    assertTrue("field "+fieldName+" does not have the correct type (expected: "+fieldType+", found:"+f.getType()+") in class "+c, fieldType.equals(f.getType()));
  }

  @Test(timeout=1000) public void monsterFields_00() { checkField("Monster", "type","java.lang.String"); }
  @Test(timeout=1000) public void monsterFields_01() { checkField("Monster", "hitPoints",int.class); }
  @Test(timeout=1000) public void monsterFields_02() { checkField("Monster", "attackRating",int.class); }
  @Test(timeout=1000) public void monsterFields_03() { checkField("Monster", "xpValue",int.class); }
  @Test(timeout=1000) public void monsterFields_04() { checkField("Monster", "goldValue",int.class); }

  public static void checkCtorSetField(Object instance, String fieldName, Object correctVal) throws NoSuchFieldException, IllegalAccessException{
    Object val = instance.getClass().getDeclaredField(fieldName).get(instance);
    assertEquals("Constructor did not set \""+fieldName+"\" field correctly", correctVal, val);
  }

  @Test(timeout=1000) public void monsterCtors(){
    Constructor<?> ctor = null, ctorDefault = null;
    Class<?> cMonster = null;
    try{
      cMonster = Class.forName("Monster");
      ctor = cMonster.getDeclaredConstructor(String.class, int.class, int.class, int.class, int.class);
      ctorDefault = cMonster.getDeclaredConstructor();
    } catch(NoSuchMethodException nsme){ } catch(ClassNotFoundException cnfe){ }
    assertTrue("Monster class not found", cMonster != null);
    assertTrue("Monster constructor with correct parameters not found", ctor != null);
    assertTrue("Monster default constructor not found", ctorDefault != null);
    Object mInstance = null;
    try{
      mInstance = ctor.newInstance("test", 1, 2, 3, 4);
      checkCtorSetField(mInstance,"type", "test");
      checkCtorSetField(mInstance,"hitPoints", 1);
      checkCtorSetField(mInstance,"attackRating", 2);
      checkCtorSetField(mInstance,"xpValue",3);
      checkCtorSetField(mInstance,"goldValue",4);
    } catch(InstantiationException ie){ } 
    catch(IllegalAccessException iae){ } 
    catch(NoSuchFieldException nsfe){ }
    catch(InvocationTargetException ite){ }
    assertTrue("Error calling constructor with parameters for Monster class", mInstance != null);
    mInstance = null;
    try{
      mInstance = ctorDefault.newInstance();
      checkCtorSetField(mInstance,"type", "goblin");
      checkCtorSetField(mInstance,"hitPoints", 10);
      checkCtorSetField(mInstance,"attackRating", 1);
      checkCtorSetField(mInstance,"xpValue", 1);
      checkCtorSetField(mInstance,"goldValue", 1);
    } catch(InstantiationException ie){ } catch(IllegalAccessException iae){ }
    catch(NoSuchFieldException nsfe){ } catch(InvocationTargetException ite){ }
    assertTrue("Error calling default constructor for Monster class", mInstance != null);
  }

  @Test(timeout=1000) public void monsterDefeat(){
    Monster m = new Monster();
    assertFalse("isDefeated() for newly created default monster should not be true", m.isDefeated());
    m.hitPoints = 0;
    assertTrue("isDefeated() should return true if hitPoints are zero or less", m.isDefeated());
  }

  public static void checkMonRcvAtk(int atkVal, Monster m){
    int hpBefore = m.hitPoints;
    m.receiveAttack(atkVal);
    assertEquals("receiveAttack in Monster class incorrect",hpBefore-atkVal,m.hitPoints);
  }

  @Test(timeout=1000) public void monsterRecAtk_00(){checkMonRcvAtk(5, new Monster());}
  @Test(timeout=1000) public void monsterRecAtk_01(){checkMonRcvAtk(15, new Monster());}

  @Test(timeout=1000) public void heroFields_00(){checkField("Hero", "name","java.lang.String"); }
  @Test(timeout=1000) public void heroFields_01(){checkField("Hero", "hitPointsRemaining",int.class);}
  @Test(timeout=1000) public void heroFields_02(){checkField("Hero", "hitPointsMax",int.class);}
  @Test(timeout=1000) public void heroFields_03(){checkField("Hero", "attackRating",int.class);}
  @Test(timeout=1000) public void heroFields_04(){checkField("Hero", "defenseRating",int.class);}
  @Test(timeout=1000) public void heroFields_05(){checkField("Hero", "currentXP",int.class);}
  @Test(timeout=1000) public void heroFields_06(){checkField("Hero", "currentLevel",int.class);}
  @Test(timeout=1000) public void heroFields_07(){checkField("Hero", "healingPotions",int.class);}

  @Test(timeout=1000) public void heroCtor(){
    Constructor<?> ctor = null;
    Class<?> cHero = null;
    try{
      cHero = Class.forName("Hero");
      ctor = cHero.getDeclaredConstructor(String.class, int.class, int.class, int.class, int.class);
    } catch(NoSuchMethodException nsme){ } catch(ClassNotFoundException cnfe){ }
    assertTrue("Hero class not found", cHero != null);
    assertTrue("Hero constructor with correct parameters not found", ctor != null);
    Object hInstance = null;
    try{
      hInstance = ctor.newInstance("herotest", 5, 6, 7, 8);
      checkCtorSetField(hInstance,"name", "herotest");
      checkCtorSetField(hInstance,"hitPointsRemaining", 5);
      checkCtorSetField(hInstance,"hitPointsMax", 5);
      checkCtorSetField(hInstance,"attackRating",6);
      checkCtorSetField(hInstance,"defenseRating",7);
      checkCtorSetField(hInstance,"currentXP", 0);
      checkCtorSetField(hInstance,"currentLevel",1);
      checkCtorSetField(hInstance,"healingPotions",8);
    } catch(InstantiationException ie){ } 
    catch(IllegalAccessException iae){ } 
    catch(NoSuchFieldException nsfe){ }
    catch(InvocationTargetException ite){ }
    assertTrue("Error calling constructor with parameters for Hero class", hInstance != null);
  }

  @Test(timeout=1000) public void heroDefeat(){
    Hero h = new Hero("testhero", 9, 10, 11, 12);
    assertTrue("Newly created Hero instance should have HP remaining", h.hasHPRemaining());
    h.hitPointsRemaining = 0;
    assertFalse("hasHPRemaining() should be false when hitPointsRemaining is 0 or less", h.hasHPRemaining());
  }

  public static void checkHeroRcvAtk(int atkVal, Hero h){
    int hpBefore = h.hitPointsRemaining;
    h.receiveAttack(atkVal);
    assertEquals("receiveAttack in Hero class incorrect",hpBefore-Math.max(0,atkVal-h.defenseRating),h.hitPointsRemaining);
  }

  @Test(timeout=1000) public void heroRecvAtk_00(){checkHeroRcvAtk(10,new Hero("testherotest", 13,14,15,16));}
  @Test(timeout=1000) public void heroRecvAtk_01(){checkHeroRcvAtk(20,new Hero("testherotest", 13,14,15,16));}
  @Test(timeout=1000) public void heroRecvAtk_02(){checkHeroRcvAtk(100,new Hero("testherotest", 13,14,15,16));}

  public static void checkHeroRcvXP(int xpVal, Hero h){
    int hpBefore = h.hitPointsRemaining;
    int xpBefore = h.currentXP;
    int lvlBefore = h.currentLevel;
    int expectedAfterXP = xpBefore + xpVal;
    int expectedAfterLVL = 1+expectedAfterXP/10;
    int expectedHPMaxAfter = h.hitPointsMax+(expectedAfterLVL-lvlBefore)*5;
    boolean shouldLevel = expectedAfterLVL > lvlBefore;
    h.receiveXP(xpVal);
    assertEquals("receiveXP incorrect",expectedAfterXP,h.currentXP);
    assertEquals("currentLevel not updated correctly",expectedAfterLVL, h.currentLevel);
    assertEquals("hitPointsMax not updated correctly",expectedHPMaxAfter, h.hitPointsMax);
    if(shouldLevel){
      assertEquals("hit points should be reset to max after leveling",expectedHPMaxAfter, h.hitPointsRemaining);
    } else {
      assertEquals("hit points should not be changed if no level up", hpBefore, h.hitPointsRemaining);
    }
  }

  @Test(timeout=1000) public void heroRecvXP_00(){checkHeroRcvXP(1,new Hero("herotesthero",17,18,19,20));}
  @Test(timeout=1000) public void heroRecvXP_01(){checkHeroRcvXP(5,new Hero("herotesthero",17,18,19,20));}
  @Test(timeout=1000) public void heroRecvXP_02(){checkHeroRcvXP(10,new Hero("herotesthero",17,18,19,20));}
  @Test(timeout=1000) public void heroRecvXP_03(){checkHeroRcvXP(100,new Hero("herotesthero",17,18,19,20));}

  public static void checkHealPotion(Hero h, int setHPTo, int setPotionsTo){
    int expectedHPAfter = h.hitPointsMax;
    int expectedPotionsAfter = setPotionsTo-1;
    h.healingPotions = setPotionsTo;
    h.hitPointsRemaining = setHPTo;
    if(setPotionsTo <= 0){
      expectedHPAfter = setHPTo;
      expectedPotionsAfter = setPotionsTo;
    }
    h.useHealingPotion();
    assertEquals("useHealingPotion setting hitPointsRemaining incorrectly",expectedHPAfter,h.hitPointsRemaining);
    assertEquals("useHealingPotion setting healingPotions incorrectly", expectedPotionsAfter,h.healingPotions);
  }

  @Test(timeout=1000) public void healPtn_00(){ checkHealPotion(new Hero("hhhero",21,22,23,24),10,5);}
  @Test(timeout=1000) public void healPtn_01(){ checkHealPotion(new Hero("hhhero",21,22,23,24),30,5);}
  @Test(timeout=1000) public void healPtn_02(){ checkHealPotion(new Hero("hhhero",21,22,23,24),-10,5);}
  @Test(timeout=1000) public void healPtn_03(){ checkHealPotion(new Hero("hhhero",21,22,23,24),10,0);}
  @Test(timeout=1000) public void healPtn_04(){ checkHealPotion(new Hero("hhhero",21,22,23,24),-10,0);}
  @Test(timeout=1000) public void healPtn_05(){ checkHealPotion(new Hero("hhhero",21,22,23,24),30,0);}

  public static void checkHeroFields(Hero h, int hpr, int hpm, int cXP, int clvl, int hp){
    assertEquals("Hero hitPointsRemaining incorrect after fight",hpr,h.hitPointsRemaining);
    assertEquals("Hero hitPointsMax incorrect after fight",hpm,h.hitPointsMax);
    assertEquals("Hero currentXP incorrect after fight", cXP, h.currentXP);
    assertEquals("Hero currentLevel incorrect after fight", clvl,h.currentLevel);
    assertEquals("Hero healingPotions incorrect after fight", hp, h.healingPotions);
  }

  @Test(timeout=1000) public void checkFight(){
    Monster m = new Monster();
    Hero h = new Hero("Fred", 100, 10, 10, 10);
    String rv = Battle.fight(h,m);
    assertEquals("Result string incorrect after fight:","Fred has defeated the goblin earning 1 gold and 1 XP leveling up 0 times.",rv);
    checkHeroFields(h,100,100,1,1,10);
    
    m = new Monster("big goblin", 50, 15, 29, 1);
    rv = Battle.fight(h,m);
    assertEquals("Result string incorrect after fight:","Fred has defeated the big goblin earning 1 gold and 29 XP leveling up 3 times.",rv);
    checkHeroFields(h,115,115,30,4,10);
    
    m = new Monster("orc", 100, 30, 1, 1);
    rv = Battle.fight(h,m);
    assertEquals("Result string incorrect after fight:","Fred has defeated the orc earning 1 gold and 1 XP leveling up 0 times.",rv);
    checkHeroFields(h,35,115,31,4,9);
    
    m = new Monster("dragon", 1000, 100, 1, 1);
    rv = Battle.fight(h,m);
    assertEquals("Result string incorrect after fight:","The dragon has defeated Fred. Game over.",rv);
  }
}
