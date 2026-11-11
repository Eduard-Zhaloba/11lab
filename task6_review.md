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

---

# Eduard's Review & Defense / ев'ю та захист дуарда

## 1. Peer Review

**Review of Demian Mysiv's code (Tasks 3 & 4). Reviewer: Eduard Zhaloba**

Task 3 (Facade):
- Diagram check: The class diagram correctly maps the Facade and the 5 sub-services.
- Problem check: The system successfully centralizes the check-in process, removing duplication.
- Runner check: Demo runs flawlessly.
- REMARK: In CheckInFacade.java, you instantiate the 5 services directly inside the constructor. It would be better to pass these services via constructor parameters (Dependency Injection) to make the Facade easier to unit test.

Task 4 (Proxy):
- Diagram check: Realization and aggregation links are correct.
- Problem check: Solves the performance issue (lazy loading) and security issue (role-based access).
- Runner check: Demo confirms the archive is loaded only once and the Cashier is denied access.
- REMARK: In RealFlightLog.java, the loadCount variable is not thread-safe. Consider using AtomicInteger.

## 2. Defense Arguments

**Arguments for Tasks 1 & 2 (by Eduard Zhaloba):**
* Adapter Pattern (Task 1): Used to integrate a third-party weather service with an imperial measurement system. The adapter wrapped the service calls and converted the data to the metric system on the fly. This solved the incompatibility issue without changing the existing control center code.
* Decorator Pattern (Task 2): Applied to eliminate the exponential growth of classes. The basic ticket is dynamically "wrapped" by service objects at runtime, adding the corresponding cost.

---

## 1. заємне рецензування (Peer Review)

**ев'ю на код студента ем'яна исіва (авдання 3 та 4). ецензент: дуард алоба**

авдання 3 (асад):
- еревірка діаграми: іаграма класів правильно відображає асад і 5 підсистем.
- еревірка проблеми: Система успішно централізує процес реєстрації, усуваючи дублювання.
- еревірка запуску: емо працює бездоганно.
- Я:  CheckInFacade.java ви створюєте 5 сервісів безпосередньо в конструкторі. раще було б передавати ці сервіси через параметри конструктора (Dependency Injection), щоб асад було легше тестувати.

авдання 4 (амісник/Proxy):
- еревірка діаграми: в'язки реалізації та агрегації правильні.
- еревірка проблеми: ирішує проблему продуктивності (ліниве завантаження) та безпеки (доступ на основі ролей).
- еревірка запуску: емо підтверджує, що архів завантажується лише один раз, а асиру відмовлено в доступі.
- Я:  RealFlightLog.java змінна loadCount не є потокобезпечною. озгляньте можливість використання AtomicInteger.

## 2. ргументація вибору шаблонів для захисту

**ргументація до авдань 1 та 2 (виконав дуард алоба):**
* атерн даптер (авдання 1): икористано для інтеграції стороннього метеосервісу з імперською системою мір. даптер обгорнув виклики сервісу та конвертував дані в метричну систему "на льоту". е дозволило вирішити проблему несумісності без зміни коду.
* атерн екоратор (авдання 2): астосовано для усунення експоненційного зростання кількості класів. азовий квиток динамічно "обгортається" об'єктами-послугами під час виконання програми, додаючи відповідну вартість.
