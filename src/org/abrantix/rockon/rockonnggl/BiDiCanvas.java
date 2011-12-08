package org.abrantix.rockon.rockonnggl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;

public class BiDiCanvas extends Canvas {
    
    /**
     * Draw the text, with origin at (x,y), using the specified paint,
     * trimmed so that it fits within the specified width.
     * The origin is interpreted based on the Align setting in the paint.
     * If the text is RTL or mixed, and the alignment is set to LEFT,
     * the text is drawn aligned to the right. "paint" will not be changed.
     * 
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param width The maximal width to draw and the origin for right aligned text
     * @param paint The paint used for the text (e.g. color, size, style) 
     */
    public void drawBiDiText(String text, float x, float y, float width, Paint paint) {
        drawBiDiText(text, x, y, width, paint, null);
    }
    
    /**
     * Draw the text, with origin at (x,y), using the specified paint,
     * trimmed so that it fits within the specified width.
     * The origin is interpreted based on the Align setting in the paint.
     * If the text is RTL or mixed, and the alignment is set to LEFT,
     * the text is drawn aligned to the right. "paint" will not be changed.
     * 
     * @param text  The text to be drawn
     * @param x     The x-coordinate of the origin of the text being drawn
     * @param y     The y-coordinate of the origin of the text being drawn
     * @param width The maximal width to draw and the origin for right aligned text
     * @param paint The paint used for the text (e.g. color, size, style)
     * @param wrap  A optional token used to indicate that the text has been trimmed
     */
    public void drawBiDiText(String text, float x, float y, float width, Paint paint, String wrap) {
        Align align = paint.getTextAlign();
        boolean rtl[] = {false};
        text = BiDiReorder.reorder(text, width, paint, wrap, rtl);
        if (rtl[0]) {
            if (align == Align.LEFT) {
                x = width - x;
                paint.setTextAlign(Align.RIGHT);
            }
        }
        drawText(text, x, y, paint);
        paint.setTextAlign(align); // restore if changed
    }
}
