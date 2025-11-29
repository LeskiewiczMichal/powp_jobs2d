package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private FigureType figureType;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureType figureType) {
		if (figureType == null) {
			throw new IllegalArgumentException("FigureType cannot be null");
		}
		this.driverManager = driverManager;
		this.figureType = figureType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (figureType.equals(FigureType.FIGURE_JOE_1)) {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		if (figureType.equals(FigureType.FIGURE_JOE_2)) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
	}

	public enum FigureType {
		FIGURE_JOE_1,
		FIGURE_JOE_2
	}
}
