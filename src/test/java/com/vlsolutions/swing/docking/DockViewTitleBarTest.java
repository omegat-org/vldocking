package com.vlsolutions.swing.docking;

import com.vlsolutions.swing.TestBase;
import com.vlsolutions.swing.sample.DockableScrollPaneApp;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class DockViewTitleBarTest extends TestBase {
    @Override
    protected void onSetUp() {
        application = createDockedApplication(DockableScrollPaneApp.class);
        window = new FrameFixture(robot(), application);
        window.show();
    }

    @Test
    public void testTitleBarNotify() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            application.setVisible(true);
            application.notification();
        });
    }
}
