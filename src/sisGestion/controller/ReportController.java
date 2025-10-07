/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.controller;

import sisGestion.model.Metric;
import sisGestion.model.Report;

/**
 *
 * @author Daniel Marín
 */
public class ReportController {


    public void addMetricToReport(Report report, Metric metric) {
        report.getMetrics().add(metric);
    }

 
    public boolean removeMetricFromReport(Report report, Metric metric) {
        return report.getMetrics().remove(metric);
    }

    
    public void updateReportDescription(Report report, String newDescription) {
        report.setDescription(newDescription);
    }
}
