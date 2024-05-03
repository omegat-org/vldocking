package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockingDesktop;

import javax.swing.*;

public abstract class DockedApplication extends JFrame {
    DockingDesktop desk = new DockingDesktop();
    MyTextEditor editorPanel = new MyTextEditor();
    MyTree treePanel = new MyTree();
    MyGridOfButtons buttonGrid = new MyGridOfButtons();
    MyJTable tablePanel = new MyJTable();
}
