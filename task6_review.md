# Task 6. Cross-review and defense preparation

## 1. Peer Review

**Review of Eduard Zhaloba's code (Tasks 1 & 2). Reviewer: Demian Mysiv**

Task 1 (Adapter):
- Diagram check: The class diagram accurately matches the Java code.
- Problem check: The Adapter successfully isolates the incompatible metric/imperial conversions.
- Runner check: The demo scenario runs perfectly.
- REMARK: In InternationalWeatherAdapter.java, there are hardcoded conversion rates. According to Clean Code principles, these should be extracted into private static final double constants.

Task 2 (Decorator):
- Diagram check: The UML shows the correct inheritance and composition.
- Problem check: Solves the class explosion issue. Services can be combined dynamically.
- Runner check: Costs and descriptions are calculated correctly.
- REMARK: The TicketDecorator base class is abstract, which is good, but wrappedTicket is protected final. It is safer to make it private final and provide a protected getter for better encapsulation.

## 2. Defense Arguments

**Arguments for Tasks 3 & 4 (by Demian Mysiv):**
* Facade Pattern (Task 3): Solved the problem of duplicating the complex check-in process. The CheckInFacade hid the interaction with 5 different subsystems behind a single method.
* Proxy Pattern (Task 4): The virtual proxy defers the expensive loading of the archive until the actual telemetry request (Lazy Initialization). The protection proxy additionally checks the user's role.

---

# Завдання 6. Крос-рев'ю та підготовка до захисту

## 1. Взаємне рецензування (Peer Review)

**Рев'ю на код студента Едуарда Жалоби (Завдання 1 та 2). Рецензент: Дем'ян Мисів**

Завдання 1 (Адаптер):
- Перевірка діаграми: Діаграма класів точно відповідає коду Java.
- Перевірка проблеми: Адаптер успішно ізолює несумісні метричні/імперські перетворення.
- Перевірка запуску: Демонстраційний сценарій працює ідеально.
- ЗАУВАЖЕННЯ: У InternationalWeatherAdapter.java є жорстко закодовані коефіцієнти конвертації. Згідно з принципами Clean Code, їх слід винести у константи private static final double.

Завдання 2 (Декоратор):
- Перевірка діаграми: UML показує правильне успадкування та композицію.
- Перевірка проблеми: Вирішує проблему експоненційного зростання класів. Послуги можна комбінувати динамічно.
- Перевірка запуску: Вартість та описи розраховуються правильно.
- ЗАУВАЖЕННЯ: Базовий клас TicketDecorator є абстрактним, що добре, але wrappedTicket є protected final. Безпечніше зробити його private final і надати protected геттер для кращої інкапсуляції.

## 2. Аргументація вибору шаблонів для захисту

**Аргументація до Завдань 3 та 4 (виконав Дем'ян Мисів):**
* Патерн Фасад (Завдання 3): Вирішив проблему дублювання складного процесу реєстрації. Фасад CheckInFacade приховав взаємодію з 5 різними підсистемами за одним методом.
* Патерн Замісник/Proxy (Завдання 4): Віртуальний проксі відкладає дороге завантаження архіву до моменту фактичного запиту телеметрії (Lazy Initialization). Захисний проксі додатково перевіряє роль користувача.
