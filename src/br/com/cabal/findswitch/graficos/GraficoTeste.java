package br.com.cabal.findswitch.graficos;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.ui.Component;

public class GraficoTeste {

	public GraficoTeste() {

	}

	public Chart gerar(){
		Chart chart = new Chart(ChartType.PIE);
		
		
		Configuration conf = chart.getConfiguration();
		PlotOptionsPie options = new PlotOptionsPie();
		options.setInnerSize(0); // Non-0 results in a donut
		options.setSize("75%"); // Default
		options.setCenter("50%", "50%"); // Default
		conf.setPlotOptions(options);

		DataSeries series = new DataSeries();
		series.add(new DataSeriesItem("Mercury", 4900));
		series.add(new DataSeriesItem("Venus", 12100));
		
		conf.addSeries(series);
		
		DataSeriesItem earth = new DataSeriesItem("Earth", 12800);
		earth.setSliced(true);
		series.add(earth);
		return chart;
	}
}