public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i] + " шагов");
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxStep = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxStep) {
                maxStep = days[i];
            }
        }
        return maxStep;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        int size = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                size = currentSeries;
                currentSeries = 0;
                if (size > finalSeries) {
                    finalSeries = size;
                }
            }
        }
        return finalSeries;
    }

    int averageNumberOfSteps(int steps) {
        int stepdays = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > 0) {
                stepdays++;
            }
            if (stepdays != 0) {
                return steps / stepdays;
            }
        }
        return stepdays;
    }

}











