package com.sevenc.amresh.sevenc_studio;

import java.util.List;

/**
 * Created by Amresh on 12/14/2015.
 */
public class Weather {

    String date,precipMM, tempMaxC, tempMaxF, tempMinC,  tempMinF,  weatherCode, winddir16Point,  winddirDegree, winddirection, windspeedKmph, windspeedMiles;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public String getTempMaxC() {
        return tempMaxC;
    }

    public void setTempMaxC(String tempMaxC) {
        this.tempMaxC = tempMaxC;
    }

    public String getTempMaxF() {
        return tempMaxF;
    }

    public void setTempMaxF(String tempMaxF) {
        this.tempMaxF = tempMaxF;
    }

    public String getTempMinC() {
        return tempMinC;
    }

    public void setTempMinC(String tempMinC) {
        this.tempMinC = tempMinC;
    }

    public String getTempMinF() {
        return tempMinF;
    }

    public void setTempMinF(String tempMinF) {
        this.tempMinF = tempMinF;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public List<WeatherDescription> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<WeatherDescription> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    List<WeatherDescription> weatherDesc;
    List<WeatherIconUrl> weatherIconUrl;
}
