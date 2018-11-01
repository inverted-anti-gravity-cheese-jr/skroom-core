package org.skroom.controller;

import java.util.Arrays;
import java.util.List;

import ro.pippo.controller.Controller;
import ro.pippo.controller.GET;
import ro.pippo.controller.Path;
import ro.pippo.controller.Produces;
import ro.pippo.controller.extractor.Param;

/**
 * AccountsController
 */
@Path(ControllerPaths.ACCOUNTS)
public class AccountsController extends Controller {

    public static List<Integer> ACCOUNTS = Arrays.asList(7, 8, 1, 4, 5, 7, 1, 2);

    @GET
    @Produces(Produces.JSON)
    public List<Integer> getAccounts() {
        return ACCOUNTS;
    }

    @GET("/{id}")
    @Produces(Produces.JSON)
    public Integer getAccount(@Param("id") int id) {
        return ACCOUNTS.get(id);
    }
}