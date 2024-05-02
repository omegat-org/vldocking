package com.vlsolutions.swing.sample;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MyTree extends JPanel implements Dockable {
    JTree tree = new JTree();
    DockKey key = new DockKey("tree");

    public MyTree() {
        setName("myTreePanel");
        setLayout(new BorderLayout());
        tree.setName("myTreeTree");
        JScrollPane jsp = new JScrollPane(tree);
        jsp.setName("myTreeScrollPane");
        jsp.setPreferredSize(new Dimension(200, 200));
        add(jsp, BorderLayout.CENTER);
        key.setName("Tree");
        key.setTooltip("This is the tree area tooltip");
        key.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("toolbox16.png"))));
        // turn off autohide and close features
        key.setCloseEnabled(false);
        key.setAutoHideEnabled(false);
    }

    @Override
    public DockKey getDockKey() {
        return key;
    }

    @Override
    public Component getComponent() {
        return this;
    }
}