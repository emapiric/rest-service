package com.restservice.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProductDTO implements Serializable {
    private String _id;
    private Derived derived;
    private Ids ids;
    private Figures figures;

    public String getIssuerName() {
        return this.derived.getIssuer().getName();
    }

    public String getUnderlyingStockName() {
        return this.derived.getUnderlying().getName();
    }

    public String getIsin() {
        return this.ids.getIsin();
    }

    public Double getYield() {
       return this.figures.getSideYieldPa();
    }

    @Getter
    private static class Derived {
        private Company issuer;
        private Company underlying;

        @Getter
        private static class Company {
            private String name;
        }
    }

    @Getter
    private static class Ids {
        private String isin;
        private String wkn;
        private String vwd;

    }

    @Getter
    private static class Figures{
        private double sideYield;
        private double sideYieldPa;
    }
}


