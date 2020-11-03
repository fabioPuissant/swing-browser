package student.uhasselt.be.utils;

import student.uhasselt.be.controller.BrowserController;
import student.uhasselt.be.controller.Controller;
import student.uhasselt.be.model.BrowserModel;

public class ControllerModelFactory {
    public static Controller buildReadyToUseController() throws Exception {
        BrowserModel model = new BrowserModel();
        Controller controller = new BrowserController();
        controller.setModel(model);

        return controller;
    }
}
