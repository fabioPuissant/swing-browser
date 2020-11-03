package student.uhasselt.be;

import student.uhasselt.be.view.BrowserGui;

import javax.swing.*;

public class BrowserApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BrowserGui::new);
    }

}
