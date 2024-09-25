package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockingDesktop;

import javax.swing.*;

public abstract class DockedApplication extends JFrame {
    DockingDesktop desk = new DockingDesktop();
    MyTextEditor editorPanel = new MyTextEditor();
    MyTree treePanel = new MyTree();
    MyGridOfButtons buttonGrid = new MyGridOfButtons();
    MyJTable tablePanel = new MyJTable();
    DockableScrollPane scrollPane = new DockableScrollPane(new JTextArea());

    public DockingDesktop getDesktop() {
        return desk;
    }

    public MyTree getTreePanel() {
        return treePanel;
    }

    public void notification() {
        scrollPane.notification();
    }
}
