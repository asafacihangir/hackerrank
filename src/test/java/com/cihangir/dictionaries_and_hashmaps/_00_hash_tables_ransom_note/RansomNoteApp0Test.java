package com.cihangir.dictionaries_and_hashmaps._00_hash_tables_ransom_note;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RansomNoteApp0Test {

    List<TestVm> testVms = new ArrayList<>();


    @Before
    public void setUp(){
        testVms.add( new TestVm("Yes", "give me one grand today night","give one grand today"));
        testVms.add( new TestVm("No", "two times three is not four","two times two is four"));
        testVms.add( new TestVm("No", "ive got a lovely bunch of coconuts","ive got some coconuts"));
        testVms.add( new TestVm("No", "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg",
                "elo elo elo elo elo lxkvg bg mwz clm w"));

    }


    @Test
    public void testCheckMagazineApp0() {
        for (TestVm vm : testVms){
            String[] magazine = vm.getMagazineString().split(" ");
            String[] note = vm.getNoteString().split(" ");
            System.out.println(vm.getMagazineString());
            Assert.assertEquals(vm.getExpectedResult(), RansomNoteApp0.checkMagazine(magazine, note));
        }
    }

    @Test
    public void testCheckMagazineApp1() {
        for (TestVm vm : testVms){
            String[] magazine = vm.getMagazineString().split(" ");
            String[] note = vm.getNoteString().split(" ");
            System.out.println(vm.getMagazineString());
            Assert.assertEquals(vm.getExpectedResult(), RansomNoteApp1.checkMagazine(magazine, note));
        }
    }
}


class TestVm {

    private String expectedResult;
    private String magazineString;
    private String noteString;

    public TestVm(String expectedResult, String magazineString, String noteString) {
        this.expectedResult = expectedResult;
        this.magazineString = magazineString;
        this.noteString = noteString;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getMagazineString() {
        return magazineString;
    }

    public void setMagazineString(String magazineString) {
        this.magazineString = magazineString;
    }

    public String getNoteString() {
        return noteString;
    }

    public void setNoteString(String noteString) {
        this.noteString = noteString;
    }
}
