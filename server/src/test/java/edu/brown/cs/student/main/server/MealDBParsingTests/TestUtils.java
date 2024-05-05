package edu.brown.cs.student.main.server.MealDBParsingTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.brown.cs.student.main.server.ingredientHandlers.Utils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class TestUtils {

  @Test
  void testFormatArr() {

    int rows = 5;
    int cols = 5;
    String[][] array = new String[rows][cols];

    char rowChar = 'a';
    int colNumber = 1;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        array[i][j] = rowChar + "" + colNumber;
        colNumber++;
      }
      rowChar++;
      colNumber = 1;
    }

    String formated2DArr = Utils.toJson2DArray(array);

    String compare =
        "[[\"a1\",\"a2\",\"a3\",\"a4\",\"a5\"],[\"b1\",\"b2\",\"b3\",\"b4\",\"b5\"],[\"c1\",\"c2\",\"c3\",\"c4\",\"c5\"],[\"d1\",\"d2\",\"d3\",\"d4\",\"d5\"],[\"e1\",\"e2\",\"e3\",\"e4\",\"e5\"]]";

    assertTrue(formated2DArr.equals(compare));
  }

  @Test
  void testFormatEmptyArr() {

    int rows = 0;
    int cols = 0;
    String[][] array = new String[rows][cols];

    char rowChar = 'a';
    int colNumber = 1;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        array[i][j] = rowChar + "" + colNumber;
        colNumber++;
      }
      rowChar++;
      colNumber = 1;
    }

    String formated2DArr = Utils.toJson2DArray(array);
    System.out.println(formated2DArr);

    String compare = "[]";

    assertTrue(formated2DArr.equals(compare));
  }

  @Test
  void testFormatFullArr() {

    int rows = 20;
    int cols = 29;
    String[][] array = new String[rows][cols];

    char rowChar = 'a';
    int colNumber = 1;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        array[i][j] = rowChar + "" + colNumber;
        colNumber++;
      }
      rowChar++;
      colNumber = 1;
    }

    String formated2DArr = Utils.toJson2DArray(array);
    System.out.println(formated2DArr);

    String compare =
        "[[\"a1\",\"a2\",\"a3\",\"a4\",\"a5\",\"a6\",\"a7\",\"a8\",\"a9\",\"a10\",\"a11\",\"a12\",\"a13\",\"a14\",\"a15\",\"a16\",\"a17\",\"a18\",\"a19\",\"a20\",\"a21\",\"a22\",\"a23\",\"a24\",\"a25\",\"a26\",\"a27\",\"a28\",\"a29\"],[\"b1\",\"b2\",\"b3\",\"b4\",\"b5\",\"b6\",\"b7\",\"b8\",\"b9\",\"b10\",\"b11\",\"b12\",\"b13\",\"b14\",\"b15\",\"b16\",\"b17\",\"b18\",\"b19\",\"b20\",\"b21\",\"b22\",\"b23\",\"b24\",\"b25\",\"b26\",\"b27\",\"b28\",\"b29\"],[\"c1\",\"c2\",\"c3\",\"c4\",\"c5\",\"c6\",\"c7\",\"c8\",\"c9\",\"c10\",\"c11\",\"c12\",\"c13\",\"c14\",\"c15\",\"c16\",\"c17\",\"c18\",\"c19\",\"c20\",\"c21\",\"c22\",\"c23\",\"c24\",\"c25\",\"c26\",\"c27\",\"c28\",\"c29\"],[\"d1\",\"d2\",\"d3\",\"d4\",\"d5\",\"d6\",\"d7\",\"d8\",\"d9\",\"d10\",\"d11\",\"d12\",\"d13\",\"d14\",\"d15\",\"d16\",\"d17\",\"d18\",\"d19\",\"d20\",\"d21\",\"d22\",\"d23\",\"d24\",\"d25\",\"d26\",\"d27\",\"d28\",\"d29\"],[\"e1\",\"e2\",\"e3\",\"e4\",\"e5\",\"e6\",\"e7\",\"e8\",\"e9\",\"e10\",\"e11\",\"e12\",\"e13\",\"e14\",\"e15\",\"e16\",\"e17\",\"e18\",\"e19\",\"e20\",\"e21\",\"e22\",\"e23\",\"e24\",\"e25\",\"e26\",\"e27\",\"e28\",\"e29\"],[\"f1\",\"f2\",\"f3\",\"f4\",\"f5\",\"f6\",\"f7\",\"f8\",\"f9\",\"f10\",\"f11\",\"f12\",\"f13\",\"f14\",\"f15\",\"f16\",\"f17\",\"f18\",\"f19\",\"f20\",\"f21\",\"f22\",\"f23\",\"f24\",\"f25\",\"f26\",\"f27\",\"f28\",\"f29\"],[\"g1\",\"g2\",\"g3\",\"g4\",\"g5\",\"g6\",\"g7\",\"g8\",\"g9\",\"g10\",\"g11\",\"g12\",\"g13\",\"g14\",\"g15\",\"g16\",\"g17\",\"g18\",\"g19\",\"g20\",\"g21\",\"g22\",\"g23\",\"g24\",\"g25\",\"g26\",\"g27\",\"g28\",\"g29\"],[\"h1\",\"h2\",\"h3\",\"h4\",\"h5\",\"h6\",\"h7\",\"h8\",\"h9\",\"h10\",\"h11\",\"h12\",\"h13\",\"h14\",\"h15\",\"h16\",\"h17\",\"h18\",\"h19\",\"h20\",\"h21\",\"h22\",\"h23\",\"h24\",\"h25\",\"h26\",\"h27\",\"h28\",\"h29\"],[\"i1\",\"i2\",\"i3\",\"i4\",\"i5\",\"i6\",\"i7\",\"i8\",\"i9\",\"i10\",\"i11\",\"i12\",\"i13\",\"i14\",\"i15\",\"i16\",\"i17\",\"i18\",\"i19\",\"i20\",\"i21\",\"i22\",\"i23\",\"i24\",\"i25\",\"i26\",\"i27\",\"i28\",\"i29\"],[\"j1\",\"j2\",\"j3\",\"j4\",\"j5\",\"j6\",\"j7\",\"j8\",\"j9\",\"j10\",\"j11\",\"j12\",\"j13\",\"j14\",\"j15\",\"j16\",\"j17\",\"j18\",\"j19\",\"j20\",\"j21\",\"j22\",\"j23\",\"j24\",\"j25\",\"j26\",\"j27\",\"j28\",\"j29\"],[\"k1\",\"k2\",\"k3\",\"k4\",\"k5\",\"k6\",\"k7\",\"k8\",\"k9\",\"k10\",\"k11\",\"k12\",\"k13\",\"k14\",\"k15\",\"k16\",\"k17\",\"k18\",\"k19\",\"k20\",\"k21\",\"k22\",\"k23\",\"k24\",\"k25\",\"k26\",\"k27\",\"k28\",\"k29\"],[\"l1\",\"l2\",\"l3\",\"l4\",\"l5\",\"l6\",\"l7\",\"l8\",\"l9\",\"l10\",\"l11\",\"l12\",\"l13\",\"l14\",\"l15\",\"l16\",\"l17\",\"l18\",\"l19\",\"l20\",\"l21\",\"l22\",\"l23\",\"l24\",\"l25\",\"l26\",\"l27\",\"l28\",\"l29\"],[\"m1\",\"m2\",\"m3\",\"m4\",\"m5\",\"m6\",\"m7\",\"m8\",\"m9\",\"m10\",\"m11\",\"m12\",\"m13\",\"m14\",\"m15\",\"m16\",\"m17\",\"m18\",\"m19\",\"m20\",\"m21\",\"m22\",\"m23\",\"m24\",\"m25\",\"m26\",\"m27\",\"m28\",\"m29\"],[\"n1\",\"n2\",\"n3\",\"n4\",\"n5\",\"n6\",\"n7\",\"n8\",\"n9\",\"n10\",\"n11\",\"n12\",\"n13\",\"n14\",\"n15\",\"n16\",\"n17\",\"n18\",\"n19\",\"n20\",\"n21\",\"n22\",\"n23\",\"n24\",\"n25\",\"n26\",\"n27\",\"n28\",\"n29\"],[\"o1\",\"o2\",\"o3\",\"o4\",\"o5\",\"o6\",\"o7\",\"o8\",\"o9\",\"o10\",\"o11\",\"o12\",\"o13\",\"o14\",\"o15\",\"o16\",\"o17\",\"o18\",\"o19\",\"o20\",\"o21\",\"o22\",\"o23\",\"o24\",\"o25\",\"o26\",\"o27\",\"o28\",\"o29\"],[\"p1\",\"p2\",\"p3\",\"p4\",\"p5\",\"p6\",\"p7\",\"p8\",\"p9\",\"p10\",\"p11\",\"p12\",\"p13\",\"p14\",\"p15\",\"p16\",\"p17\",\"p18\",\"p19\",\"p20\",\"p21\",\"p22\",\"p23\",\"p24\",\"p25\",\"p26\",\"p27\",\"p28\",\"p29\"],[\"q1\",\"q2\",\"q3\",\"q4\",\"q5\",\"q6\",\"q7\",\"q8\",\"q9\",\"q10\",\"q11\",\"q12\",\"q13\",\"q14\",\"q15\",\"q16\",\"q17\",\"q18\",\"q19\",\"q20\",\"q21\",\"q22\",\"q23\",\"q24\",\"q25\",\"q26\",\"q27\",\"q28\",\"q29\"],[\"r1\",\"r2\",\"r3\",\"r4\",\"r5\",\"r6\",\"r7\",\"r8\",\"r9\",\"r10\",\"r11\",\"r12\",\"r13\",\"r14\",\"r15\",\"r16\",\"r17\",\"r18\",\"r19\",\"r20\",\"r21\",\"r22\",\"r23\",\"r24\",\"r25\",\"r26\",\"r27\",\"r28\",\"r29\"],[\"s1\",\"s2\",\"s3\",\"s4\",\"s5\",\"s6\",\"s7\",\"s8\",\"s9\",\"s10\",\"s11\",\"s12\",\"s13\",\"s14\",\"s15\",\"s16\",\"s17\",\"s18\",\"s19\",\"s20\",\"s21\",\"s22\",\"s23\",\"s24\",\"s25\",\"s26\",\"s27\",\"s28\",\"s29\"],[\"t1\",\"t2\",\"t3\",\"t4\",\"t5\",\"t6\",\"t7\",\"t8\",\"t9\",\"t10\",\"t11\",\"t12\",\"t13\",\"t14\",\"t15\",\"t16\",\"t17\",\"t18\",\"t19\",\"t20\",\"t21\",\"t22\",\"t23\",\"t24\",\"t25\",\"t26\",\"t27\",\"t28\",\"t29\"]]";

    assertTrue(formated2DArr.equals(compare));
  }

  @Test
  void testFullApiResponseString() {
    String callString =
        "https://www.themealdb.com/api/json/v2/9973533/filter.php?i=chicken_breast,garlic";
    String json = null;
    try {
      json = Utils.fullApiResponseString(callString);
    } catch (IOException e) {
      assertTrue(false);
      String compare =
          "{\"meals\":[{\"strMeal\":\"Chicken Fajita Mac and Cheese\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/qrqywr1503066605.jpg\",\"idMeal\":\"52818\"},{\"strMeal\":\"Chicken Ham and Leek Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/xrrtss1511555269.jpg\",\"idMeal\":\"52875\"},{\"strMeal\":\"Chicken Quinoa Greek Salad\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/k29viq1585565980.jpg\",\"idMeal\":\"53011\"},{\"strMeal\":\"Honey Balsamic Chicken with Crispy Broccoli & Potatoes\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/kvbotn1581012881.jpg\",\"idMeal\":\"52993\"},{\"strMeal\":\"Katsu Chicken curry\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/vwrpps1503068729.jpg\",\"idMeal\":\"52820\"}]}";
      assertTrue(json.equals(compare));
    }
  }

  @Test
  void testSingleApiResponseString() {
    String callString = "https://www.themealdb.com/api/json/v2/9973533/filter.php?i=salt";
    String json = null;
    try {
      json = Utils.fullApiResponseString(callString);
    } catch (IOException e) {
      assertTrue(false);
      String compare =
          "{\"meals\":[{\"strMeal\":\"Apam balik\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/adxcbq1619787919.jpg\",\"idMeal\":\"53049\"},{\"strMeal\":\"Baingan Bharta\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/urtpqw1487341253.jpg\",\"idMeal\":\"52807\"},{\"strMeal\":\"BeaverTails\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/ryppsv1511815505.jpg\",\"idMeal\":\"52928\"},{\"strMeal\":\"Beef Brisket Pot Roast\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/ursuup1487348423.jpg\",\"idMeal\":\"52812\"},{\"strMeal\":\"Beef Lo Mein\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529444830.jpg\",\"idMeal\":\"52952\"},{\"strMeal\":\"Bistek\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/4pqimk1683207418.jpg\",\"idMeal\":\"53069\"},{\"strMeal\":\"Bitterballen (Dutch meatballs)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/lhqev81565090111.jpg\",\"idMeal\":\"52979\"},{\"strMeal\":\"Blini Pancakes\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/0206h11699013358.jpg\",\"idMeal\":\"53080\"},{\"strMeal\":\"Bread omelette\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/hqaejl1695738653.jpg\",\"idMeal\":\"53076\"},{\"strMeal\":\"Breakfast Potatoes\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1550441882.jpg\",\"idMeal\":\"52965\"},{\"strMeal\":\"Burek\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/tkxquw1628771028.jpg\",\"idMeal\":\"53060\"},{\"strMeal\":\"Carrot Cake\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/vrspxv1511722107.jpg\",\"idMeal\":\"52897\"},{\"strMeal\":\"Chakchouka \",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/gpz67p1560458984.jpg\",\"idMeal\":\"52969\"},{\"strMeal\":\"Chelsea Buns\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/vqpwrv1511723001.jpg\",\"idMeal\":\"52898\"},{\"strMeal\":\"Chick-Fil-A Sandwich\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/sbx7n71587673021.jpg\",\"idMeal\":\"53016\"},{\"strMeal\":\"Chicken Alfredo Primavera\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/syqypv1486981727.jpg\",\"idMeal\":\"52796\"},{\"strMeal\":\"Chicken Congee\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529446352.jpg\",\"idMeal\":\"52956\"},{\"strMeal\":\"Chicken Fajita Mac and Cheese\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/qrqywr1503066605.jpg\",\"idMeal\":\"52818\"},{\"strMeal\":\"Cream Cheese Tart\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wurrux1468416624.jpg\",\"idMeal\":\"52779\"},{\"strMeal\":\"Crispy Eggplant\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/c7lzrl1683208757.jpg\",\"idMeal\":\"53072\"},{\"strMeal\":\"Crispy Sausages and Greens\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/st1ifa1583267248.jpg\",\"idMeal\":\"52999\"},{\"strMeal\":\"Dal fry\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wuxrtu1483564410.jpg\",\"idMeal\":\"52785\"},{\"strMeal\":\"Egg Drop Soup\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529446137.jpg\",\"idMeal\":\"52955\"},{\"strMeal\":\"Eggplant Adobo\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/y7h0lq1683208991.jpg\",\"idMeal\":\"53073\"},{\"strMeal\":\"Feteer Meshaltet\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/9f4z6v1598734293.jpg\",\"idMeal\":\"53030\"},{\"strMeal\":\"Flamiche\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wssvvs1511785879.jpg\",\"idMeal\":\"52906\"},{\"strMeal\":\"French Lentils With Garlic and Thyme\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/vwwspt1487394060.jpg\",\"idMeal\":\"52815\"},{\"strMeal\":\"Fresh sardines\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/nv5lf31628771380.jpg\",\"idMeal\":\"53061\"},{\"strMeal\":\"General Tso's Chicken\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529444113.jpg\",\"idMeal\":\"52951\"},{\"strMeal\":\"Go\\u0142\\u0105bki (cabbage roll)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/q8sp3j1593349686.jpg\",\"idMeal\":\"53021\"},{\"strMeal\":\"Grilled eggplant with coconut milk\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/bopa2i1683209167.jpg\",\"idMeal\":\"53074\"},{\"strMeal\":\"Hot and Sour Soup\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529445893.jpg\",\"idMeal\":\"52954\"},{\"strMeal\":\"Jamaican Beef Patties\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wsqqsw1515364068.jpg\",\"idMeal\":\"52938\"},{\"strMeal\":\"Kafteji\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1bsv1q1560459826.jpg\",\"idMeal\":\"52971\"},{\"strMeal\":\"Kentucky Fried Chicken\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/xqusqy1487348868.jpg\",\"idMeal\":\"52813\"},{\"strMeal\":\"Koshari\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/4er7mj1598733193.jpg\",\"idMeal\":\"53027\"},{\"strMeal\":\"Krispy Kreme Donut\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/4i5cnx1587672171.jpg\",\"idMeal\":\"53015\"},{\"strMeal\":\"Lasagna Sandwiches\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/xr0n4r1576788363.jpg\",\"idMeal\":\"52987\"},{\"strMeal\":\"Leblebi Soup\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/x2fw9e1560460636.jpg\",\"idMeal\":\"52973\"},{\"strMeal\":\"Ma Po Tofu\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1525874812.jpg\",\"idMeal\":\"52947\"},{\"strMeal\":\"Mbuzi Choma (Roasted Goat)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/cuio7s1555492979.jpg\",\"idMeal\":\"52968\"},{\"strMeal\":\"Mediterranean Pasta Salad\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/wvqpwt1468339226.jpg\",\"idMeal\":\"52777\"},{\"strMeal\":\"Montreal Smoked Meat\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/uttupv1511815050.jpg\",\"idMeal\":\"52927\"},{\"strMeal\":\"Mulukhiyah\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/x372ug1598733932.jpg\",\"idMeal\":\"53029\"},{\"strMeal\":\"Paszteciki (Polish Pasties)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/c9a3l31593261890.jpg\",\"idMeal\":\"53017\"},{\"strMeal\":\"Pate Chinois\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/yyrrxr1511816289.jpg\",\"idMeal\":\"52930\"},{\"strMeal\":\"Pierogi (Polish Dumplings)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/45xxr21593348847.jpg\",\"idMeal\":\"53019\"},{\"strMeal\":\"Pizza Express Margherita\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/x0lk931587671540.jpg\",\"idMeal\":\"53014\"},{\"strMeal\":\"Polskie Nale\\u015bniki (Polish Pancakes)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/58bkyo1593350017.jpg\",\"idMeal\":\"53022\"},{\"strMeal\":\"Potato Salad (Olivier Salad)\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/ebvuir1699013665.jpg\",\"idMeal\":\"53081\"},{\"strMeal\":\"Pumpkin Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/usuqtp1511385394.jpg\",\"idMeal\":\"52857\"},{\"strMeal\":\"Rappie Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/ruwpww1511817242.jpg\",\"idMeal\":\"52933\"},{\"strMeal\":\"Roasted Eggplant With Tahini, Pine Nuts, and Lentils\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/ysqrus1487425681.jpg\",\"idMeal\":\"52816\"},{\"strMeal\":\"Roti john\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/hx335q1619789561.jpg\",\"idMeal\":\"53052\"},{\"strMeal\":\"Seri muka kuih\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/6ut2og1619790195.jpg\",\"idMeal\":\"53054\"},{\"strMeal\":\"Spaghetti alla Carbonara\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/llcbn01574260722.jpg\",\"idMeal\":\"52982\"},{\"strMeal\":\"Spicy North African Potato Salad\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/urtwux1486983078.jpg\",\"idMeal\":\"52797\"},{\"strMeal\":\"Spotted Dick\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/xqvyqr1511638875.jpg\",\"idMeal\":\"52886\"},{\"strMeal\":\"Stamppot\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/hyarod1565090529.jpg\",\"idMeal\":\"52980\"},{\"strMeal\":\"Steak and Kidney Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/qysyss1511558054.jpg\",\"idMeal\":\"52881\"},{\"strMeal\":\"Strawberry Rhubarb Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/178z5o1585514569.jpg\",\"idMeal\":\"53005\"},{\"strMeal\":\"Sugar Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/yrstur1511816601.jpg\",\"idMeal\":\"52931\"},{\"strMeal\":\"Sweet and Sour Pork\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529442316.jpg\",\"idMeal\":\"52949\"},{\"strMeal\":\"Szechuan Beef\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529443236.jpg\",\"idMeal\":\"52950\"},{\"strMeal\":\"Timbits\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/txsupu1511815755.jpg\",\"idMeal\":\"52929\"},{\"strMeal\":\"Tortang Talong\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/va668f1683209318.jpg\",\"idMeal\":\"53075\"},{\"strMeal\":\"Traditional Croatian Goulash\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/n1hcou1628770088.jpg\",\"idMeal\":\"53057\"},{\"strMeal\":\"Walnut Roll Gu\\u017evara\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/u9l7k81628771647.jpg\",\"idMeal\":\"53062\"}]}";
      assertTrue(json.equals(compare));
    }
  }

  @Test
  void testNullApiResponseString() {
    String callString =
        "https://www.themealdb.com/api/json/v2/9973533/filter.php?i=chicken_breast,garlic";
    String json = "{\"meals\":null}";
    try {
      json = Utils.fullApiResponseString(callString);
    } catch (IOException e) {
      assertTrue(false);
      String compare =
          "{\"meals\":[{\"strMeal\":\"Chicken Fajita Mac and Cheese\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/qrqywr1503066605.jpg\",\"idMeal\":\"52818\"},{\"strMeal\":\"Chicken Ham and Leek Pie\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/xrrtss1511555269.jpg\",\"idMeal\":\"52875\"},{\"strMeal\":\"Chicken Quinoa Greek Salad\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/k29viq1585565980.jpg\",\"idMeal\":\"53011\"},{\"strMeal\":\"Honey Balsamic Chicken with Crispy Broccoli & Potatoes\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/kvbotn1581012881.jpg\",\"idMeal\":\"52993\"},{\"strMeal\":\"Katsu Chicken curry\",\"strMealThumb\":\"https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/vwrpps1503068729.jpg\",\"idMeal\":\"52820\"}]}";
      assertTrue(json.equals(compare));
    }
  }
}
