/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jp.tihtih.homework;

/**
 *
 * @author user
 */
public class Contact {

    private String company;
    private String katagaki;
    private String name;
    private String Email;

    public void Contact(String company, String katagaki, String name, String Email) {
        this.company = company;
        this.katagaki = katagaki;
        this.name = name;
        this.Email = Email;
    }

    public String toString() {
        return "" + company + ";" + katagaki + ";" + name + ";" + Email + "";

    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the katagaki
     */
    public String getKatagaki() {
        return katagaki;
    }

    /**
     * @param katagaki the katagaki to set
     */
    public void setKatagaki(String katagaki) {
        this.katagaki = katagaki;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

}
