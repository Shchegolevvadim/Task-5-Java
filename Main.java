// 5.	Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, 
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
//  Предложить хотя бы одно решение или сообщить, что его нет.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main{
    static char[] textGlobal;
    static List<Integer> signIndexesGlobal;
    public static void main(String[] args) throws IOException {

    ArrayList<Integer> signIndexes = new ArrayList<>();
    String text = "2? + ?5 = 69"; // уравнение в виде строки, мы не можем менять строки 
    char[] textChar = text.replace(" ", "").toCharArray();
    // массив символов могу менять, вместо вопросов поставить все возможные цифры
    for (int i = 0; i < textChar.length; i++) {
    if (textChar[i] == '+' || textChar[i] == '=') {
        textChar[i] = '-';
    }
    if (textChar[i] == '?') {
          signIndexes.add(i);
    }
}
textGlobal = textChar;
signIndexesGlobal = signIndexes;
combWithRep(new int[signIndexes.size()], 0, 10); 
}
public static void combWithRep(int[] comb, int index, int K){
    if (index == comb.length) {
        // готова очередная комбинация
        // давайте здесь поставим на место вопросов комбинацию, проверим подходит ли она нам
        checkComb(comb);
        return;
    }
    for (int i = 0; i < K; i++) {
        comb[index] = i;
        combWithRep(comb, index + 1, K);
    }
}
public static void checkComb(int[] comb) {
    for (int i = 0; i < comb.length; i++){
        // sign = 2, 5
        // comb = 1, 1
textGlobal[signIndexesGlobal.get(i)] = Character.forDigit(comb[i],10);
    }
    String[] numbers = String.valueOf(textGlobal).split("-");
int a = Integer.parseInt(numbers[0]);
int b = Integer.parseInt(numbers[1]);
int c = Integer.parseInt(numbers[2]);
if (a + b == c) {
System.out.printf("%d + %d = %d", a, b, c);
System.out.println();
}
}
}
