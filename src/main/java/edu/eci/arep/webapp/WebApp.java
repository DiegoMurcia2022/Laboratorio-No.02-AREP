package edu.eci.arep.webapp;

import edu.eci.arep.CalculatorWebApp;
import static spark.Spark.*;

public class WebApp {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");

        post("/calculator", (request, response) -> {
            CalculatorWebApp.readJSON(request.body());
            return "{\"media\":" + CalculatorWebApp.mean() + ", \"desviacion\":" + CalculatorWebApp.standardDeviation() + "}";
        });
    }

    static int getPort() {
        if (System.getenv("PORT")!=null) {
            return Integer.parseInt(System.getenv("PORT"));
        }

        return 4567;
    }
}
