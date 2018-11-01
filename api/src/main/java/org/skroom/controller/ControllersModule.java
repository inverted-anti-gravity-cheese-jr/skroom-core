package org.skroom.controller;

import com.google.inject.AbstractModule;

/**
 * ControllersModule
 */
public class ControllersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AccountsController.class);
        
    }
    
}