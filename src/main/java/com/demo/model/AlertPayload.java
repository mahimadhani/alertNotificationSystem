package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertPayload {
    
    private String phone_number;
    
    public static AlertPayloadBuilder builder() {
        return new AlertPayloadBuilder();
    }
    
    public static class AlertPayloadBuilder {
        private String phone_number;
        
        AlertPayloadBuilder() {
        }
        
        public AlertPayloadBuilder phoneNumber(String phoneNumber) {
            this.phone_number = phoneNumber;
            return this;
        }
        
        public AlertPayload build() {
            return new AlertPayload(phone_number);
        }
        
        public String toString() {
            return "AlertPayload.AlertPayloadBuilder(phoneNumber=" + this.phone_number + ")";
        }
    }
}
