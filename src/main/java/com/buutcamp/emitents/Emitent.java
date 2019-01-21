package com.buutcamp.emitents;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="emitent_")
@Proxy(lazy=false)
public class Emitent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "EMITNAME")
    private String emitentName;

    @Column(name = "EMITURL")
    private String emitentURL;

    @Column(name = "EMITFULLNAME")
    private String emitentFullName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fundamental_id")
    private Fundamental fundamental;

    public Emitent(){}

    public Emitent(String emitentName, String emitentURL){
        this.emitentName = emitentName;
        this.emitentURL = emitentURL;
    }

    public Emitent(String emitentName, String emitentURL, String emitentFullName){
        this.emitentName = emitentName;
        this.emitentURL = emitentURL;
        this.emitentFullName = emitentFullName;
    }

    public Emitent(String emitentName, String emitentURL, String emitentFullName, Fundamental fundamental){
        this.emitentName = emitentName;
        this.emitentURL = emitentURL;
        this.emitentFullName = emitentFullName;
        this.fundamental = fundamental;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmitentName() {
        return emitentName;
    }

    public void setEmitentName(String emitentName) {
        this.emitentName = emitentName;
    }

    public String getEmitentURL() {
        return emitentURL;
    }

    public void setEmitentURL(String emitentURL) {
        this.emitentURL = emitentURL;
    }

    public String getEmitentFullName() {
        return emitentFullName;
    }

    public void setEmitentFullName(String emitentFullName) {
        this.emitentFullName = emitentFullName;
    }

    public Fundamental getFundamental() {
        return fundamental;
    }

    public void setFundamental(Fundamental fundamental) {
        this.fundamental = fundamental;
    }

    @Override
    public String toString() {
        return "Emitent{" +
                "Id=" + Id +
                ", emitentName='" + emitentName + '\'' +
                ", emitentURL='" + emitentURL + '\'' +
                ", emitentFullName='" + emitentFullName + '\'' +
                //", fundamental=" + fundamental +
                '}';
    }
}
