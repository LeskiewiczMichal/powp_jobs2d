package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class SpecialLineDrawerAdapter implements Job2dDriver{
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;
    private final LineType lineType;

    public SpecialLineDrawerAdapter(LineType lineType) {
      drawPanelController = DrawerFeature.getDrawerController();

      if (lineType == null)
        this.lineType = LineType.BASIC;
      else
        this.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
      this.startX = x;
      this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
      ILine line;
      if (lineType == LineType.DOTTED)
        line = LineFactory.getDottedLine();
      else if (lineType == LineType.SPECIAL)
        line = LineFactory.getSpecialLine();
      else if (lineType == LineType.BASIC)
         line = LineFactory.getBasicLine();
      else
        throw new IllegalArgumentException("Unsupported line type");

      line.setStartCoordinates(this.startX, this.startY);
      line.setEndCoordinates(x, y);
      startX = x;
      startY = y;

      drawPanelController.drawLine(line);
    }

    @Override
    public String toString() {
      if (lineType == LineType.DOTTED)
        return "Dotted line type";
      else if (lineType == LineType.SPECIAL)
        return "Special line type";
      else if (lineType == LineType.BASIC)
        return "Basic line type";
      else
        return "Unknown line type";


    }

    public enum LineType {
      BASIC,
      DOTTED,
      SPECIAL
    }
}
