package com.example.parcial.logica;

public class Pregunta {
        public String pregunta="";
        public int id;
        public Pregunta() {
        }

        public Pregunta(String pregunta, int id) {
            this.pregunta = pregunta;
            this.id = id;
        }

        public String getPregunta() {
            return pregunta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

}
