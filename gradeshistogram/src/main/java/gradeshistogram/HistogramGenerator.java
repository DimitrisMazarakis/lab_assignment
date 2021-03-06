package gradeshistogram;

import java.io.*;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {

    public void generateChart(int[] dataValues) {
        /*
         * The XYSeriesCollection object is a set XYSeries series (dataset) that
         * can be visualized in the same chart
         */
        XYSeriesCollection dataset = new XYSeriesCollection();
        /*
         * The XYSeries that are loaded in the dataset. There might be many
         * series in one dataset.
         */
        XYSeries data = new XYSeries("random values");

        /*
         * Populating the XYSeries data object from the input Integer array
         * values.
         */
        for (int i = 0; i < dataValues.length; i++) {
            data.add(i, dataValues[i]);
            //}
        }

        // add the series to the dataset
        dataset.addSeries(data);

        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        // Declare and initialize a createXYLineChart JFreeChart
        JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "Grade", "Frequency", dataset,
            PlotOrientation.VERTICAL, legend, tooltips, urls);

        /*
         * Initialize a frame for visualizing the chart and attach the
         * previously created chart.
         */
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        // makes the previously created frame visible
        frame.setVisible(true);
    }

    public static int[] findFreq(int[] grades) {
        int visited = -1;
        int[] frequency = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            int count = 1;
            for (int j = i + 1; j < grades.length; j++) {
                if (grades[i] == grades[j]) {
                    count++;  
                    frequency[j] = visited;
                }
            }
            if (frequency[i] != visited)
                frequency[i] = count;
        }
        int[] all_grades = new int[11];
        for (int k = 0; k < frequency.length; k++) {
            if (frequency[k] != visited) {
                all_grades[grades[k]] = frequency[k]; //for every grade adds his frequency
            }
        }
        return all_grades;
    }

    public static int[] fetchData(String[] args) {
        int c = 0;
        Scanner fl = null;
        try {
            fl = new Scanner(new File(args[0]));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        while (fl.hasNextLine()) {
            fl.nextLine();
            c++;

        }
        fl.close();
        try {
            fl = new Scanner(new File(args[0]));
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        int[] data = new int[c];

        for (int i = 0; i < c; i++) {
            data[i] = Integer.parseInt(fl.nextLine());
        }
        fl.close();
        return data;
    }

    public static void main(String[] args) {

        int[] data = fetchData(args); //read file 
        HistogramGenerator demo = new HistogramGenerator();

        int[] fre = findFreq(data); //finds frequency
        demo.generateChart(fre); //create chart
    }

}