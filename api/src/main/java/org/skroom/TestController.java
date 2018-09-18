package org.skroom;

import ro.pippo.controller.Controller;
import ro.pippo.controller.GET;

/**
 * TestController
 */
//@Path
public class TestController extends Controller {

    @GET
    public String elo() {
        return "tzd elo";
    }
    
}