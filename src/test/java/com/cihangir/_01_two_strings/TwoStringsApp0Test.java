package com.cihangir._01_two_strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TwoStringsApp0Test {

    List<TestDto> testDtos = new ArrayList<>();


    @Before
    public void setUp(){
        testDtos.add( new TestDto("YES", "hello","world"));
        testDtos.add( new TestDto("NO", "hi","world"));

        testDtos.add( new TestDto("NO", "wouldyoulikefries","abcabcabcabcabcabc"));
        testDtos.add( new TestDto("YES", "hackerrankcommunity", "cdecdecdecde"));
        testDtos.add( new TestDto("YES", "jackandjill", "wentupthehill"));
        testDtos.add( new TestDto("NO", "writetoyourparents", "fghmqzldbc"));

        testDtos.add( new TestDto("YES", "aardvark", "apple"));
        testDtos.add( new TestDto("NO", "beetroot", "sandals"));
    }

    @Test
    public void testCheckMagazineApp0() {
        for (TestDto testDto : testDtos){
            System.out.println(testDto.getS1());
            Assert.assertEquals(testDto.getExpectedRestult(), TwoStringsApp0.twoStrings(testDto.getS1(), testDto.getS2()));
        }
    }



}

class TestDto {

    private String expectedRestult;
    private String s1;
    private String s2;

    public TestDto(String expectedRestult, String s1, String s2) {
        this.expectedRestult = expectedRestult;
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getExpectedRestult() {
        return expectedRestult;
    }

    public void setExpectedRestult(String expectedRestult) {
        this.expectedRestult = expectedRestult;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }
}
