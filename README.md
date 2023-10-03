# ExpressionCalculator
Данная программа является калькулятором выражений, с поддержкой приоритетов операций.
## Что доступно? 
### Базовые арифметические операции
Чем выше приоритет у операции, тем первее она будет выполняться

| Имя операции         | Оператор | Приоритет |
|----------------------|----------|-----------|
| Сложение             | +        | 1         |
| Вычитание            | -        | 1         |
| Умножение            | *        | 2         |
| Деление              | /        | 2         |
| Возведение в степень | ^        | 3         |
| Унарный минус        | -        | 4         |

### Функции
У функций выше приоритет чем у базовых операций, но все функции имеют одинаковый приоритет

| Функция                                                           | Сигнатура            |
|-------------------------------------------------------------------|----------------------|
| Синус a                                                           | sin(a)               |
| Косинус a                                                         | cos(a)               |
| Квадратный корень из a                                            | sqrt(a)              |
| Расстояние между точками A(x1; y1) <br/> и B(x2; y2) на плоскости | diff(x1, y1, x2, y2) |

## Как это работает ?
1. С помощью [Shunting yard algorithm](https://en.wikipedia.org/wiki/Shunting_yard_algorithm) инфиксная форма записи преобразуется в обратную польскую нотацию
2. Далее по обратной польской нотации строится объектная модель, в основе которой лежит интерфейс Calculable
3. В результате успешного построения, получается объект класса Expression, который можно использовать для вычисления выражения