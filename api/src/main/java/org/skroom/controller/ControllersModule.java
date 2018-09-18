package org.skroom.controller;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * ControllersModule
 */
public class ControllersModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AccountsController.class);

        install(new FactoryModuleBuilder()
            .implement(AccountController.class, AccountController.class)
            .build(AssistedFactory.class));
    
    }

    public interface AssistedFactory {

        AccountController getAccountController(Integer id);

    }

    
}