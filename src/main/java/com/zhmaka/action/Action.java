package com.zhmaka.action;

import com.zhmaka.service.CarService;


public interface Action {
    public static final CarService CAR_SERVICE = CarService.getInstance();
    void execute();

}
