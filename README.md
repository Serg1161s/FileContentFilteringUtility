Утилита фильтрации содержимого файлов.

Задача утилиты прочитать входящие файлы и записать разные типы данных из этих файлов в разные файлы. Целые числа в один
выходной файл, вещественные в другой, строки в третий.
Обрабатывает текстовые файлы в формате *.txt.
Создаваемые файлы  в формате *.txt
Обрабатываемые данные:
1) Целых чисел. Диапозон значений: от +/- 1.7E-308 до 1.7E+308 (Double).
2) Вещественные числа. Диапозон значений: от +/- 1.7E-308 до 1.7E+308 (Double).
3) Строки (Всё остальное не вошедее в первые два пункта).

Иструкция по использованию утилиты:
1. В папку с собранной утилитой поместить файлы для сортировки.
2. В командной строке для запуска утилиты нужно набрать команду:
   java -jar FileContentFilteringUtility-1.0.jar
   послe имени набрать нужные ключи и указать имена входящих файлов
   Ключи:
   -o - "Заданный путь к папке с результатом"
   -p - Префикс к имени файлов с результатоми
   -s - Короткая статистика
   -f - Полная статистик
   -h - список команд
   -  - после тире перечислить имена файлов для сортировки через запятую 
3. Нажать Ввод!

Пример команды:
   
java -jar FileContentFilteringUtility-1.0.jar -p some_ -s -f  -in1.txt,in2.txt,in2.XLS,in2.txt,in2.tx,in3.txt -o C:\Temp\temp

Система сборки:

IntelliJ IDEA 2024.1.1 (Community Edition)
Build #IC-241.15989.150, built on April 29, 2024
Runtime version: 17.0.10+1-b1207.14 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Windows 10.0

Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Program Files\Maven\apache-maven-3.9.9
Java version: 23.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-23
Default locale: ru_RU, platform encoding: UTF-8
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

Зависимости
JComander
 <!-- https://mvnrepository.com/artifact/com.beust/jcommander -->
 JarPlagin
 <!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-jar-plugin -->
Maven dependency
<!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-dependency-plugin -->

