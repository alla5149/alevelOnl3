package com.zhmaka.action;

import com.zhmaka.service.CarService;

import java.io.IOException;


public interface Action {
    public static final CarService CAR_SERVICE = CarService.getInstance();
    void execute() throws IOException;

}
