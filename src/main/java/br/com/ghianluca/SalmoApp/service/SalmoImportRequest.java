package br.com.ghianluca.SalmoApp.service;

import java.util.List;

public class SalmoImportRequest {

    private List<SalmoRequest> salmos;

    public List<SalmoRequest> getSalmos() {
        return salmos;
    }

    public void setSalmos(List<SalmoRequest> salmos) {
        this.salmos = salmos;
    }

    public static class SalmoRequest {

        private String title;
        private List<VersiculoRequest> versiculos;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<VersiculoRequest> getVersiculos() {
            return versiculos;
        }

        public void setVersiculos(List<VersiculoRequest> versiculos) {
            this.versiculos = versiculos;
        }

        public static class VersiculoRequest {
            private String title;
            private String text;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
}