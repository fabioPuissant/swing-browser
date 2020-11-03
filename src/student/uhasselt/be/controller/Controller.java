package student.uhasselt.be.controller;

import student.uhasselt.be.view.View;

import java.util.Observable;

public interface Controller {
    void setModel(Observable model) throws Exception;

    Observable getModel();

}
