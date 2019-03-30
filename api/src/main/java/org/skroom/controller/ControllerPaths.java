package org.skroom.controller;

public interface ControllerPaths {

    String ROOT = "/api";
    
    String API_VERSION_1 = "/v1";
    
    String ROOT_V1 = ROOT + API_VERSION_1;

    String AUTHENTICATION = ROOT_V1 + "/auth";
    
    String ACCOUNTS = ROOT_V1 + "/accounts";
    
}