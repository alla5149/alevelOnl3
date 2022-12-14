package com.zhmaka.action;

import com.zhmaka.service.CarService;

import java.io.IOException;

public class Action {
    CarService CAR_SERVICE = CarService.getInstance();
    void execute() throws IOException;

}
