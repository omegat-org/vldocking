package com.vlsolutions.swing.sample;

import javax.swing.*;

public class DockableScrollPaneApp extends DockedApplication {

    public DockableScrollPaneApp() {
        desk.addDockable(scrollPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().add(desk);
    }

    public static void main(String[] args) {
        DockableScrollPaneApp frame = new DockableScrollPaneApp();
        frame.setName("parent");
        frame.setSize(800, 600);
        frame.validate();
        // in the event dispatch thread
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}