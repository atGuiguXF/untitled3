package com.heying.spring.xml;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AAA {
private String aaa;

private int bbb;

private Date ccc;

private List<String> ddd;

private Set<Integer> eee;

private Map<String ,Integer> fff;

    @Override
    public String toString() {
        return "AAA{" +
                "aaa='" + aaa + '\'' +
                ", bbb=" + bbb +
                ", ccc=" + ccc +
                ", ddd=" + ddd +
                ", eee=" + eee +
                ", fff=" + fff +
                '}';
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    public Date getCcc() {
        return ccc;
    }

    public void setCcc(Date ccc) {
        this.ccc = ccc;
    }

    public List<String> getDdd() {
        return ddd;
    }

    public void setDdd(List<String> ddd) {
        this.ddd = ddd;
    }

    public Set<Integer> getEee() {
        return eee;
    }

    public void setEee(Set<Integer> eee) {
        this.eee = eee;
    }

    public Map<String, Integer> getFff() {
        return fff;
    }

    public void setFff(Map<String, Integer> fff) {
        this.fff = fff;
    }
}
