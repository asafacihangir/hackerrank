package com.cihangir.dictionaries_and_hashmaps._02_sherlock_and_anagrams;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SherlockAndAnagramsApp0Test {


  List<TestDto> testDtos = new ArrayList<>();



  @Before
  public void setUp(){
    testDtos.add( new TestDto(2, "mom"));
    testDtos.add( new TestDto(4, "abba"));
    testDtos.add( new TestDto(0, "abcd"));
    testDtos.add( new TestDto(3, "ifailuhkqq"));
    testDtos.add( new TestDto(10, "kkkk"));
    testDtos.add( new TestDto(5, "cdcd"));
    testDtos.add(new TestDto(447,"dxskilnpkkdxwpeefvgkyohnwxtrrtxtckkdgnawrdjtcpzplywyxmwtemwmtklnclqccklotbpsrkazqolefprenwaozixvlxhu"));
    testDtos.add(new TestDto(428,"zjekimenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenacfivtigvfsadtlytzymuwvpntngkyhw"));
    testDtos.add(new TestDto(11577,"bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba"));
    testDtos.add(new TestDto(11577,"bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba"));
    testDtos.add(new TestDto(166650,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));


  }

  @Test
  public void testSherlockAndAnagrams() {
    for (TestDto testDto : testDtos){
      System.out.println(testDto.getS1());
      Assert.assertEquals(testDto.getExpectedRestult(), SherlockAndAnagramsApp1.sherlockAndAnagrams(testDto.getS1()));
    }
  }
}


class TestDto {

  private int expectedRestult;
  private String s1;

  public TestDto(int expectedRestult, String s1) {
    this.expectedRestult = expectedRestult;
    this.s1 = s1;
  }

  public int getExpectedRestult() {
    return expectedRestult;
  }

  public void setExpectedRestult(int expectedRestult) {
    this.expectedRestult = expectedRestult;
  }

  public String getS1() {
    return s1;
  }

  public void setS1(String s1) {
    this.s1 = s1;
  }
}
