import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter convert = new Converter();
    int goalByStepsPerDay = 10000;


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть 1 - 12. А у вас " + month);
            return;
        }
        System.out.println("Какое количество дней вы хотели бы заполнить?");
        int index = scanner.nextInt();
        if (index <= 0 || index > 30) {
            System.out.println("Значение должно быть от 0 до 30. А у вас " + index);
            return;
        }
        for (int i = 1; i <= index; i++) {
            System.out.println("Введите номер дня");
            int day = scanner.nextInt();
            if (day < 1 || day > 30) {
                System.out.println("День должен быть от 1 до 30. А у Вас " + day);
                return;
            }
            System.out.println("Введите количество шагов");
            int steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Количество шагов должно быть положительным");
                return;
            }

            MonthData monthData = monthToData[month - 1];
            monthData.days[day - 1] = steps;
        }
    }

    void makeStepsTaken(int monthForStatistic) {

        monthToData[monthForStatistic - 1].printDaysAndStepsFromMonth();
    }

    void makeSumSteps(int monthForStatistic) {
        System.out.println("Общее количество шагов за " + convert.convertMonth(monthForStatistic) + ": "
                + monthToData[monthForStatistic - 1].sumStepsFromMonth());

    }

    void makeMaxSteps(int monthForStatistic) {
        System.out.println("Максимальное количество шагов за " + convert.convertMonth(monthForStatistic) + ": "
                + monthToData[monthForStatistic - 1].maxSteps());
    }

    void changeStepGoal() {
        System.out.println("Сейчас цель шагов на день " + goalByStepsPerDay + ". Задайте новую цель шагов на день");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay == 0 || goalByStepsPerDay < 0) {
            System.out.println("Цель шагов на день должна быть > 0, а у вас" + goalByStepsPerDay);
            return;
        }
        System.out.println("Новая цель шагов " + goalByStepsPerDay + " задана");
    }

    void makeBestSeries(int monthForStatistic) {
        System.out.println("Максимальная серия за " + convert.convertMonth(monthForStatistic) + ": в течение "
                + monthToData[monthForStatistic - 1].bestSeries(goalByStepsPerDay) +
                " дней вы достигали или превышали цель " + goalByStepsPerDay + " шагов");
    }


    void printStatistic() {
        System.out.println("За какой месяц вы хотите получить статистику?");
        int monthForStatistic = scanner.nextInt();
        if (monthForStatistic < 1 || monthForStatistic > 12) {
            System.out.println("Месяц должен быть 1 - 12. А у вас " + monthForStatistic);
            return;
        }
        System.out.println("Какая статистика вас интересует?");
        System.out.println("1. Количество пройденных шагов по дням за месяц ");
        System.out.println("2. Общее количество шагов за месяц ");
        System.out.println("3. Максимальное количество шагов в месяце");
        System.out.println("4. Максимальное количество подряд идущих дней, в течение которых количество шагов " +
                "за день было равно или выше целевого");
        System.out.println("5. Среднее количество шагов за месяц");
        System.out.println("6. Пройденная дистанция в километрах за месяц");
        System.out.println("7. Количество сожженых килокалорий за месяц");
        System.out.println("8. Текущая цель по шагам");
        int commandStatistic = scanner.nextInt();
        if (commandStatistic == 1) {
            makeStepsTaken(monthForStatistic);
        } else if (commandStatistic == 2) {
            makeSumSteps(monthForStatistic);
        } else if (commandStatistic == 3) {
            makeMaxSteps(monthForStatistic);
        } else if (commandStatistic == 4) {
            makeBestSeries(monthForStatistic);
        } else if (commandStatistic == 5) {
            System.out.println("За " + convert.convertMonth(monthForStatistic) + " вы прошли в среднем " +
                    monthToData[monthForStatistic - 1].averageNumberOfSteps(monthToData[monthForStatistic - 1].sumStepsFromMonth())
                    + " шагов");
        } else if (commandStatistic == 6) {
            System.out.println("За " + convert.convertMonth(monthForStatistic) + " вы прошли " +
                    monthToData[monthForStatistic - 1].sumStepsFromMonth() + " шагов. Это " +
                    convert.convertToKm(monthToData[monthForStatistic - 1].sumStepsFromMonth()) + " км");
        } else if (commandStatistic == 7) {
            System.out.println("За " + convert.convertMonth(monthForStatistic) + " вы прошли " +
                    monthToData[monthForStatistic - 1].sumStepsFromMonth() + " шагов. Это " +
                    convert.convertStepsToKilocalories(monthToData[monthForStatistic - 1].sumStepsFromMonth()) + " ккал");
        } else if (commandStatistic == 8) {
            System.out.println("Текущая цель: " + goalByStepsPerDay + " шагов в день");
        }
    }
}



