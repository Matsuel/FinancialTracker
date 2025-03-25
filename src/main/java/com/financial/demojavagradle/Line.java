package com.financial.demojavagradle;

public class Line {

    private String period;
    private Float total;
    private Float logement;
    private Float nourriture;
    private Float sorties;
    private Float transports;
    private Float voyages;
    private Float impots;
    private Float autres;

    public Line() {
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getLogement() {
        return logement;
    }

    public void setLogement(Float logement) {
        this.logement = logement;
    }

    public Float getNourriture() {
        return nourriture;
    }

    public void setNourriture(Float nourriture) {
        this.nourriture = nourriture;
    }

    public Float getSorties() {
        return sorties;
    }

    public void setSorties(Float sorties) {
        this.sorties = sorties;
    }

    public Float getTransports() {
        return transports;
    }

    public void setTransports(Float transports) {
        this.transports = transports;
    }

    public Float getVoyages() {
        return voyages;
    }

    public void setVoyages(Float voyages) {
        this.voyages = voyages;
    }

    public Float getImpots() {
        return impots;
    }

    public void setImpots(Float impots) {
        this.impots = impots;
    }

    public Float getAutres() {
        return autres;
    }

    public void setAutres(Float autres) {
        this.autres = autres;
    }
}
