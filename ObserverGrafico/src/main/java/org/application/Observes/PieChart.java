package org.application.Observes;

import org.application.Observes.Observer;
import org.application.Subjects.Dataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PieChart implements Observer {
    DefaultPieDataset<String> graphset=new DefaultPieDataset<String>();
    Dataset dataset; //subject
    public PieChart(Dataset dataset) {
        dataset.attach(this);
        this.dataset = dataset;
        for(String key:dataset.getData().keySet()){
            graphset.setValue(key,dataset.getData().get(key));
        }
    }
    @Override
    public void update() {
        for(String key:dataset.getData().keySet()){
            graphset.setValue(key,dataset.getData().get(key));
        }

    }
    public JFrame getChart() {

        JFreeChart piechart= ChartFactory.createPieChart("", graphset, true, true, true);
        ChartPanel chartPanel=new ChartPanel(piechart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        chartPanel.setPreferredSize(new Dimension(500, 400));

        JFrame frame=new JFrame("grafico a Torta");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setAlwaysOnTop(true);


        return frame;
    }
}
