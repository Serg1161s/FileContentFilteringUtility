Утилита фильтрации содержимого файлов.

Задача утилиты прочитать входящие файлы и записать разные типы данных из этих файлов в разные файлы. Целые числа в один
выходной файл, вещественные в другой, строки в третий.
Обрабатывает текстовые файлы в формате *.txt.
Создаваемые файлы  в формате *.txt
Обрабатываемые данные:
1) Целых чисел. Диапазон значений: от +/- 1.7E-308 до 1.7E+308 (Double).
2) Вещественные числа. Диапазон значений: от +/- 1.7E-308 до 1.7E+308 (Double).
3) Строки (Всё остальное не вошедшее в первые два пункта).

Инструкция по использованию утилиты:
1. В папку с собранной утилитой поместить файлы для сортировки.
2. В командной строке для запуска утилиты нужно набрать команду:
   java -jar FileContentFilteringUtility-1.0.jar
   после имени набрать нужные ключи и указать имена входящих файлов
   Ключи:
   -o - "Заданный путь к папке с результатом"
   -p - Префикс к имени файлов с результатами
   -s - Короткая статистика
   -f - Полная статистик
   -h - список команд
   -  - после тире перечислить имена файлов для сортировки через запятую 
3. Нажать Ввод!

Пример команды:
   
java -jar FileContentFilteringUtility-1.0.jar -p some_ -s -f  - in1.txt,in2.txt,in2.XLS,in2.txt,in2.tx,in3.txt -o C:\Temp\temp

Система сборки:

IntelliJ IDEA 2025.2.6.1 (Community Edition)
Build #IC-252.28539.33, built on January 9, 2026
Source revision: 4e8dca23c1f67
Runtime version: 21.0.9+1-b1038.78 amd64 (JCEF 122.1.9)
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.awt.windows.WToolkit
Windows 11.0
GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
Memory: 2048M
Cores: 8
Registry:
ide.experimental.ui=true
llm.show.ai.promotion.window.on.start=false
Kotlin: 252.28539.33-IJ


http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd

java 25.0.1 2025-10-21 LTS
Java(TM) SE Runtime Environment (build 25.0.1+8-LTS-27)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.1+8-LTS-27, mixed mode, sharing)

Зависимости:
JComander
 https://mvnrepository.com/artifact/com.beust/jcommander
JarPlagin
 https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-jar-plugin 
Maven dependency
 https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-dependency-plugin 

