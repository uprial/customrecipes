package com.gmail.uprial.customrecipes.config;

class InternalConfigurationError extends RuntimeException {
    InternalConfigurationError(String message) {
        super(message);
    }
}