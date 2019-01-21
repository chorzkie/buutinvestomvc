package com.buutcamp.emitents;

import javax.persistence.*;

@Entity
@Table(name="good_emitent")
public class GoodEmitents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "GOODEMITNAME")
    private String emitentName;

    @Column(name = "GOODEMITFULLNAME")
    private String emitentFullName;

    public GoodEmitents(){}

    public GoodEmitents(String emitentName, String emitentFullName){
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
