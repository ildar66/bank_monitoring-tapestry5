# bank_monitoring-tapestry5
Bank events monitoring
Branches:

1)creating-the-skeleton-application-tapestry-5.3.7(create in maven 5.3.7 archetype)

2)v.1.0-List-events-by-Deal-(mockDB with tapestry5 native Inject-implementation)

3)v.1.1-ListDealEvents-(used gridDataSource-paging-sorting)

4)v.2.0-jQuery_Tapestry_integration(modal-dialog clientDictionary example)

5)v.3.0-Spring_Tapestry_integration(Oracle DB spring DAO and configure example)

6)Example passivate(activate) in CreateEvent form. No store(@persist) in session. Using ajaxformloop and ajax dialog.

7)v.3.1-Spring_Tapestry_integration(Oracle DB + spring DAO + usage example)

На этапе формирования команды по java разработке, обучал молодых специалистов, принимал решения по архитектуре и используемым технологиям. После переезда из Москвы в Таганрог, работал удаленно.

##### Памятка для себя:))
### J2EE Projects (VTB bankа) :
Project "Monitoring"(Система формирования и исполнения мероприятий)
Модуль занимается мониторингом клиентов и их сделок, выявлением ФКР(риски).
Отслеживает весь процесс формирования Календаря контрольных мероприятий(КМ):
 - Выверка параметров КМ.
 - Акцепт списка КМ.
 - Анализ полноты оформления плана Календаря.
 - Утверждение Календаря.
 - Направление мероприятий на исполнение.
и исполнения КМ.
В процессе участвуют(роли) руководители и сотрудники юридических, финансовых
и др. служб и подразделений ОАО Банк ВТБ.
Большую часть времени проект вел самостоятельно
(архитектура, реализация режимов, создание таблиц БД и пользовательских функций). Взаимодействовал с аналитиками заказчика.

#### Тендер версия и несколько use-case с Tapestry5 сделал сам:
#### https://github.com/ildar66/bank_monitoring-tapestry5
После победы подключилась команда:
https://github.com/ildar66/Eclipse_vtb_monitoring

Требованиями(пожеланиями) со стороны заказчика были использование сл. технологий:
Tapestry компоненты (core + jQuery) и каркас на стороне клиента.
Activity Business Process Management (BPM) - управление бизнес процессами.
Spring Data и Batis ORM mapping на уровне соотнесения с БД Oracle11 
Использовал Spring ICo 
Разработка в Eclipse IDE, JIRA+Git(контроль версий и бизнес требований).

Проект успешно внедрен.
-------------------------------------------------------------------------------------------------
Для проектов "ВТБ" создал раздел "Справочники и классификаторы."

JSF компоненты (IBM, Apache MyFaсes) и каркас на стороне клиента. EJB3 и POJO на уровне бизнес-логики.
JPA mapping на уровне соотнесения с БД Oracle11
IBM WebSphere App server.
Tools: Rational Application Developer (v6 - 7. 5),
version control: svn; bug-tracking: JIRA; testing: jUnit, HttpUnit

Раздел для проектов успешно внедрен.
- -------------------------------------------------------------
Общий "Модуль администрирования" для систем "ВТБ":
1) СПО (предкредитная обработка).
2) "Кредитные комитеты".
3) "Рейтинги"
управление пользователями, департаментами, мапировка ролей и полномочий.
Писал самостоятельно с нуля.

Средства разработки: Rational Application Developer (v6 - 7. 5)
Контроль версий: svn
Система управления задачами: JIRA
Проект успешно внедрен.
