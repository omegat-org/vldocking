/*
    VLDocking Framework 3.0
    Copyright Lilian Chamontin, 2004-2013

    www.vldocking.com
    vldocking@googlegroups.com
------------------------------------------------------------------------
This software is distributed under the LGPL license

The fact that you are presently reading this and using this class means that you have had
knowledge of the LGPL license and that you accept its terms.

You can read the complete license here :

    http://www.gnu.org/licenses/lgpl.html

*/

package com.vlsolutions.swing.docking;

/**
 * Contract for a shape painter (during drag and drop operation)
 *
 * @author Lilian Chamontin, VLSolutions
 * @since 3.0
 */
interface ShapePainterStrategy {

    /** show the drag cursor */
    void showDragCursor();

    /** show the stop-drag cursor (drag not enabled) */
    void showStopDragCursor();

    /** show the stop-drag cursor (drag not enabled) */
    void showSwapDragCursor();

    /** show the float (detached) cursor */
    void showFloatCursor();

    void repaint();

    void startDrag(DockableDragSource source);

    void endDrag();
}
