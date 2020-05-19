package geekbrains.lesson_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
	 */
        System.out.println("компьютер загадал одно из следующих слов: \"apple\", \"orange\", \"lemon\", \"banana\", " +
                "\"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\",\n" +
                "\"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\"," +
                "\"olive\", \"pea\", \"peanut\",\n" +
                "\"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\" отгадайте какое.");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        pickRandom(words);
        };
    public static void pickRandom(String[] inputString){
        int i = (int) (Math.random() * 25);//делаю рандомную переменную что бы по её номеру бралось случайное
        // слово из массива
        String randomWord = inputString[i];
//        System.out.println(randomWord);//это строчка на раннем этапе создания посмотреть рандомно ли выбирается слово
        doGame(randomWord);//Программой слово выбранно, теперь перейдём к вводу слова от пользователя
    }
    public static void doGame(String guessedWord){
        Scanner scanner = new Scanner(System.in);//создаю объкт сканнер, для воода ответа,
        // с которым будем сравнивать загаданное слово
            System.out.println("Введите в консоль слово которое по вашему мнению загадала программа:");
            String userAnswer = scanner.nextLine();
            if (guessedWord.equals(userAnswer)) {
                System.out.println("Вы угадали правильно. Поздравляю!");
            }
            else doAdvise(userAnswer, guessedWord);//если не угадали, то запустить метод вывода подсказки
    }
    public static void doAdvise(String userAnswer, String compChoice){
        int hiddenWordLength = compChoice.length();// делаю переменную длинны букв загаданного слова.
        char[] charsAnswer = userAnswer.toCharArray();// разбиваю загаданное слово на массив из его букв.
        // массив из его букв что-бы их сравнить по одной.
        for (int i = 0; i < hiddenWordLength; i++){
            if (i > charsAnswer.length) break;
            charsAnswer[i] = (compChoice.charAt(i) != charsAnswer[i]) ? '#' : charsAnswer[i];
//            if (compChoice.charAt(i) != charsAnswer[i]) charsAnswer[i] = "#";//альтернативная логика
            System.out.print("если в загаданном программой слове есть буквы из указанного вами слова в том же порядке, он выведет их в консоли\r\n"
                 + Arrays.toString(charsAnswer));
        }
//        StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
//        for (int i = comment.length(); i < 15; i++) comment.append("#");
//        System.out.println(comment);
        System.out.println("если в загаданном программой слове есть буквы из указанного вами слова в том же порядке, он выведет их в консоли\r\n"
                 + charsAnswer);
        doGame(compChoice);
    }
}
