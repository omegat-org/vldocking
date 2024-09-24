package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import com.vlsolutions.swing.sample.MySplitDockApp;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class DockingDesktopTest extends TestBase {
    @Override
    protected void onSetUp() {
        application = createDockedApplication(MySplitDockApp.class);
        window = new FrameFixture(robot(), application);
        window.show();
    }

    @Test
    public void testFloating() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            application.setVisible(true);
            application.getDesktop().setFloating(application.getTreePanel(), true);
        });
        assertTrue(application.getDesktop().getDockableState(application.getTreePanel()).isFloating());
    }

    @Test
    public void testFloatingPoint() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            application.setVisible(true);
            Point p = application.getDesktop().getBounds().getLocation();
            application.getDesktop().setFloating(application.getTreePanel(), true, p);
        });
        assertEquals(DockableState.Location.FLOATING, application.getTreePanel().getDockKey().getLocation());
        assertTrue(application.getDesktop().getDockableState(application.getTreePanel()).isFloating());
    }

    @Test
    public void testMaximize() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            application.setVisible(true);
            application.getDesktop().maximize(application.getTreePanel());
        });
        assertTrue(application.getDesktop().getDockableState(application.getTreePanel()).isMaximized());
    }

}
