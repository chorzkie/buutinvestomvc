package com.buutcamp.emitents;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="emitent_fund")
@Proxy(lazy=false)
public class Fundamental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "ROE")
    private float roe;

    @Column(name = "PBV")
    private float pbv;

    @Column(name = "PER")
    private float per;

    @Column(name = "SALES5")
    private float sales5;

    @Column(name = "EPS5")
    private float eps5;

    public Fundamental(){}

    public Fundamental(float roe, float pbv, float per) {
        this.roe = roe;
        this.pbv = pbv;
        this.per = per;
    }

    public Fundamental(float roe, float pbv, float per, float sales5) {
        this.roe = roe;
        this.pbv = pbv;
        this.per = per;
        this.sales5 = sales5;
    }

    public Fundamental(float roe, float pbv, float per, float sales5, float eps5) {
        this.roe = roe;
        this.pbv = pbv;
        this.per = per;
        this.sales5 = sales5;
        this.eps5 = eps5;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getRoe() {
        return roe;
    }

    public void setRoe(float roe) {
        this.roe = roe;
    }

    public float getPbv() {
        return pbv;
    }

    public void setPbv(float pbv) {
        this.pbv = pbv;
    }

    public float getPer() {
        return per;
    }

    public void setPer(float per) {
        this.per = per;
    }

    public float getSales5() {
        return sales5;
    }

    public void setSales5(float sales5) {
        this.sales5 = sales5;
    }

    public float getEps5() {
        return eps5;
    }

    public void setEps5(float eps5) {
        this.eps5 = eps5;
    }

    @Override
    public String toString() {
        return "Fundamental{" +
                "Id=" + Id +
                ", roe=" + roe +
                ", pbv=" + pbv +
                ", per=" + per +
                ", sales5=" + sales5 +
                ", eps5=" + eps5 +
                '}';
    }
}
