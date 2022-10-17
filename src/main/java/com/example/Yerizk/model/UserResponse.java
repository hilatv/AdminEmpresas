package com.example.Yerizk.model;

public class UserResponse {

        private String mensaje;
        private Object object;

        public UserResponse(String mensaje, Object object) {
            this.mensaje = mensaje;
            this.object = object;
        }

        public UserResponse() {
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

}
