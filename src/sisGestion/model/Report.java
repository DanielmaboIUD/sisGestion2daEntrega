/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisGestion.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Marín
 */
public class Report {
    private static int incrementIdCode=1;
    private int code;
    private String title;
    private String description;
    private String format;
    private String reportDate;
    private String period;
    private List<Metric> metrics;

    public Report(int code, String title, String description, String format, String reportDate, String period) {
        this.code = Report.incrementIdCode;
        this.title = title;
        this.description = description;
        this.format = format;
        this.reportDate = reportDate;
        this.period = period;
        incrementIdCode++;
        this.metrics = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }
    
    public int searchMetric(int code){
    
        for (int i = 0; i < this.metrics.size(); i++) {
            
            Metric m=this.metrics.get(i);
            if(m.getCode() == code){
                return i;
            }
        }
        return -1;
    }
    public boolean addMetric(Metric metric){
        return this.metrics.add(metric);
    }
    public Metric dropMetric(int code){
        int index= this.searchMetric(code);
        if(index<0){
            return null;
        }
        return this.metrics.remove(index);
    }
    
    public Metric updateMetric(int code, Metric metric){
        int index= this.searchMetric(code);
        if(index<0){
            return null;
        }
        return this.metrics.set(index, metric);
    }
    
    public String showMetric(){
    
        String report="";
        for (int i = 0; i < this.metrics.size(); i++) {
            Metric m=metrics.get(i);
            report += m.toString()+"\n";
        }
        return report;
    
    }
}
