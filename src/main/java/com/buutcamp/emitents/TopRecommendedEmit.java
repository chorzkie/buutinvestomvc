package com.buutcamp.emitents;

import javax.persistence.*;

@Entity
@Table(name="top_emitent")
public class TopRecommendedEmit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "TOPEMITNAME")
    private String emitentName;

    @Column(name = "TOPEMITFULLNAME")
    private String emitentFullName;

    public TopRecommendedEmit(){}

    public TopRecommendedEmit(String emitentName, String emitentFullName){
        this.emitentName = emitentName;
        this.emitentFullName = emitentFullName;
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

    public String getEmitentFullName() {
        return emitentFullName;
    }

    public void setEmitentFullName(String emitentFullName) {
        this.emitentFullName = emitentFullName;
    }

    @Override
    public String toString() {
        return "TopRecommendedEmit{" +
                "Id=" + Id +
                ", emitentName='" + emitentName + '\'' +
                ", emitentFullName='" + emitentFullName + '\'' +
                '}';
    }
}
