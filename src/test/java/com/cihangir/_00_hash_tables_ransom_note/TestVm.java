package com.cihangir._00_hash_tables_ransom_note;

public class TestVm {

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
