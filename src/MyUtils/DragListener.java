package MyUtils;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author giahu
 */
public class DragListener extends MouseInputAdapter {

    Point location;
    MouseEvent pressed;
    Component component;

    public DragListener(Component component) {
        this.component = component;
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        pressed = evt;
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + evt.getX();
        int y = location.y - pressed.getY() + evt.getY();
        component.setLocation(x, y);
    }
}
