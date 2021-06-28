package com.example.taresmobileapp.domains;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int iduser;
    private int idLieu;
    private String mail;
    private String mdp;
    private String firstname;

    private String lastName;
    private String numbertelephone;
    private Date birthday ;
    private float solde;
    private String adress;
    private int step;

    public User(int iduser, int idLieu, String mail, String mdp, String firstname, String lastName, String numbertelephone, Date birthday, float solde, String adress, int step) {
        this.iduser = iduser;
        this.idLieu = idLieu;
        this.mail = mail;
        this.mdp = mdp;
        this.firstname = firstname;
        this.lastName = lastName;
        this.numbertelephone = numbertelephone;
        this.birthday = birthday;
        this.solde = solde;
        this.adress = adress;
        this.step = step;
    }

    public User() {
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumbertelephone() {
        return numbertelephone;
    }

    public void setNumbertelephone(String numbertelephone) {
        this.numbertelephone = numbertelephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
