package student.uhasselt.be.view;

import student.uhasselt.be.controller.Controller;
import student.uhasselt.be.utils.ControllerModelFactory;

import javax.swing.*;
import java.awt.*;


public class BrowserGui {

    private JFrame frame;


    public BrowserGui() {
        try {
            initComponents();
            frame.setTitle("Swing Browser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() throws Exception {
        Controller c = ControllerModelFactory.buildReadyToUseController();

        PanelBar panelBar = new PanelBar();
        panelBar.setController(c);

        BrowserBody body = new BrowserBody();
        body.setController(c);

        frame = new JFrame();
        JScrollPane scroll = new JScrollPane(body.getBody(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(BorderLayout.NORTH, panelBar.getTopPanel());
        frame.add(BorderLayout.CENTER, scroll);
    }
}
