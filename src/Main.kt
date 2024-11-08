
import java.util.*
import kotlin.random.Random
//1
fun generateRandomNumbers() {
    val randomNumbers = List(10) { Random.nextInt(1, 101) }
    println("случайные числа: $randomNumbers")
}
//2
fun analyzeString(input: String): Pair<Int, Int> {
    val vowels = "aeiouAEIOU"
    var vowelCount = 0
    var consonantCount = 0
    for (char in input) {
        when {
            char.isLetter() && char in vowels -> vowelCount++
            char.isLetter() -> consonantCount++
        }
    }
    return Pair(vowelCount, consonantCount)
}
//3
fun convertCurrency(dollars: Double, euroRate: Double): Double {
    return dollars * euroRate
}
//4
fun areAnagrams(str1: String, str2: String): Boolean {
    val normalizedStr1 = str1.replace(Regex("[^a-zA-Z]"), "").toLowerCase().toCharArray().sortedArray()
    val normalizedStr2 = str2.replace(Regex("[^a-zA-Z]"), "").toLowerCase().toCharArray().sortedArray()
    return normalizedStr1.contentEquals(normalizedStr2)
}
//5
fun findPrimes(n: Int): List<Int> {
    return (2..n).filter { isPrime(it) }
}
fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}
//6
fun sortStrings(strings: Array<String>): Array<String> {
    return strings.sortedArray()
}
//7
fun toggleCase(str: String): String {
    return str.map {
        if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar()
    }.joinToString("")
}
//8
fun playGuessingGame() {
    val randomNumber = Random.nextInt(1, 101)
    var guess: Int? = null
    println("угадайте число от 1 до 100:")
    while (guess != randomNumber) {
        guess = readLine()?.toIntOrNull()
        when {
            guess == null -> println("введите корректное число")
            guess < randomNumber -> println("слишком мало")
            guess > randomNumber -> println("слишком много")
            else -> println("вы угадали число")
        }
    }
}
//9
fun generatePassword(length: Int): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()"
    return (1..length).map { chars.random() }.joinToString("")
}
//10
fun findLongestWord(input: String): String {
    val words = input.split(Regex("\\W+"))
    return words.maxByOrNull { it.length } ?: ""
}
fun main() {
    val scanner = Scanner(System.`in`)
    println("\nЗадание 1")
    generateRandomNumbers()
    println("\nЗадание 2")
    println("введите строку:")
    val inputStr = scanner.nextLine()
    val (vowelsCount, consonantsCount) = analyzeString(inputStr)
    println("гласные: $vowelsCount, согласные: $consonantsCount")
    println("\nЗадание 3")
    println("введите сумму в долларах:")
    val dollars = scanner.nextDouble()
    println("введите курс евро:")
    val euroRate = scanner.nextDouble()
    val euros = convertCurrency(dollars, euroRate)
    println("сумма в евро: $euros")
    println("\nЗадание 4")
    println("введите первую строку:")
    val str1 = scanner.nextLine()
    println("введите вторую строку:")
    val str2 = scanner.nextLine()
    println("анаграммы? ${areAnagrams(str1, str2)}")
    println("\nЗадание 5")
    println("введите число N:")
    val n = scanner.nextInt()
    val primes = findPrimes(n)
    println("простые числа до $n: $primes")
    println("\nЗадание 6")
    println("введите массив строк (через запятую):")
    val strings = scanner.nextLine().split(",").map { it.trim() }.toTypedArray()
    val sortedStrings = sortStrings(strings)
    println("отсортированные строки: ${sortedStrings.joinToString(", ")}")
    println("\nЗадание 7")
    println("введите строку для изменения регистра:")
    val caseStr = scanner.nextLine()
    println("измененный регистр: ${toggleCase(caseStr)}")
    println("\nЗадание 8")
    playGuessingGame()
    println("\nЗадание 9")
    println("введите длину пароля:")
    val passwordLength = scanner.nextInt()
    println("сгенерированный пароль: ${generatePassword(passwordLength)}")
    println("\nЗадание 10")
    println("введите строку для поиска самого длинного слова:")
    val longestWordInput = scanner.nextLine()
    println("самое длинное слово: ${findLongestWord(longestWordInput)}")
}