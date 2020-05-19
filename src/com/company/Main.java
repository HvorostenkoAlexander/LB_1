package com.company;

//ЛБ_2
       /* Создать приложение, удовлетворяющее требованиям, приведенным в задании.
        Наследование применять только в тех заданиях, в которых это логически обосновано.
        Аргументировать принадлежность классу каждого создаваемого метода
        и корректно переопределить для каждого класса методы equals(), hashCode(), toString().

        28.	 Создать объект класса Государство, используя классы Область, Район, Город.
        Методы: вывести на консоль столицу, количество областей, площадь, областные центры.*/

//ЛБ_4
/*4.	Выполнить задания на основе варианта А Лабораторная работа №2, контролируя состояние пото¬ков ввода/вывода.
        При возникновении ошибок, связанных с корректностью вы¬полнения математических операций,
        генерировать и обрабатывать исклю¬чительные ситуации. Предусмотреть обработку исключений,
        возникающих при нехватке памяти, отсутствии требуемой записи (объекта) в файле, недопусти¬мом значении поля и т. д.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        City minsk = new City("Minsk", 1_992_685);
        Country belarus = new Country("Belarus", minsk);
        belarus.addRegion(new Region("Minskaya oblast'", minsk, 39.854));
        belarus.addRegion(new Region("Brestskaya oblast'", new City("Brest", 343_985), 32.787));
        belarus.addRegion(new Region("Vitebskaya oblast'", new City("Vitebsk", 362_466), 40.051));
        belarus.addRegion(new Region("Gomel'skaya oblast'", new City("Gomel", 508_839), 40.372));
        belarus.addRegion(new Region("Grodnenskaya oblast'", new City("Grodno", 368_710), 25.127));
        belarus.addRegion(new Region("Mogilevskaya oblast'", new City("Mogilev", 380_440), 29.068));

        Country russia = new Country("Russia",  new City("Moscow", 1_992_685));

        List<Country> countrys = new ArrayList<>();
        countrys.add(belarus);
        countrys.add(russia);

        InOutFile.OutFile(countrys); // запись списка государств в ФАЙЛ

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";

        while (true){
            System.out.println("1 - вывести на консоль столицу");
            System.out.println("2 - вывести количество областей");
            System.out.println("3 - вывести площадь");
            System.out.println("4 - вывести областные центры");
            System.out.println("5 - поиск государсвта из списка государств в файле по столице");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x){
                case 1:
                    //вывести на консоль столицу
                   belarus.printCapital();
                    break;
                case 2:
                    // вывести количество областей
                    belarus.printNumberOfRegions();
                    break;
                case 3:
                    //  вывести площадь
                    belarus.printArea();
                    break;
                case 4:
                    // вывести областные центры
                    belarus.printRegionCenters();
                    break;
                case 5:
                    // поиск государсвта в файле по столице
                    Country.searchCity();
                    break;
            }
        }

    }
}
