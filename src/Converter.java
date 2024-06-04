public class Converter {
    int oneStepInCm = 75;
    int oneKmInCm = 100000;
    int oneStepKal = 50;
    int kalInKkal = 1000;
    String[] name = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь",
            "октябрь", "ноябрь", "декабрь"};

    int convertToKm(int steps) {
        return (steps * oneStepInCm) / oneKmInCm;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * oneStepKal) / kalInKkal;
    }

    String convertMonth(int month) {
        return name[month - 1];
    }
}
