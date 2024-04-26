/*import java.util.*; // задание 2
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(); // вводим x
        ArrayList<String> listOfNumbers = new ArrayList<>();
        String number = "517814323"; // строка целых чисел
        listOfNumbers.addAll(List.of(number.split(""))); // каждую цифру из строки целых чисел отправляем в список целых чисел
        listOfNumbers.add(Integer.toString(x)); // добавим в список x
        Collections.sort(listOfNumbers); // сортировка списка
        System.out.println(listOfNumbers);
    }
}*/

/*import java.util.*; // задание 4
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine(); // вводим строку символов
        ArrayList<String> list = new ArrayList<>(); // создаём список
        list.addAll(List.of(string.split(""))); // добавляем в список строку символов через разделитель ""
        Collections.sort(list); // сортировка символов
        System.out.println(list);
    }
}*/



/*import java.util.*; // задание 6
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> englishText = new HashSet<>(); //создадим множество для исключения дубликатов
        String[] text = in.nextLine().split(" "); // ввод текста
        for (String a : text) { // проходимся по тексту
            englishText.add(a.toLowerCase()); // каждое слово преобразуем к нижнему регистру и добавляем в наш сет для избавления от дубликатов
        }
        System.out.println(englishText.size()); // выводим количество различных слов
    }
}*/

import java.util.*; // исключения
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Scanner in = new Scanner(System.in);
        String login = in.next(); // ввод логина
        String password = in.next(); // ввод пароля
        String confirmPassword = in.next(); // ввод подтверждающего пароля
        System.out.println(checking(login, password, confirmPassword)); // вызываем метод проверки логина и пароля
    }

    public static boolean checking(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        Matcher matcherLogin = Pattern.compile("[\\w]{1,20}").matcher(login); // проверка на нужное количество символов
        Matcher matcherPassword = Pattern.compile("[\\w]{1,20}").matcher(password); // проверка на нужное количество символов
        if (matcherLogin.matches()) { // правильность логина
            if (matcherPassword.matches() && password.equals(confirmPassword)) { // правильность пароля и соответствие пароля и подтверждающего пароля
                return true;
            } else {
                throw new WrongPasswordException("WrongPasswordException");
            }
        } else {
            throw new WrongLoginException("WrongLoginException");
        }
    }
}