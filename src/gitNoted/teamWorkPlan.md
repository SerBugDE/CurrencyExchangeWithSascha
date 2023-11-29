## Общий порядок (схема) работы в режиме с доступом на запись

1. Открыть имеющийся репо (или создать новый)
2. Добавить членов команды
3. Настройка защиты ветки `main`
4. Клонировать репо (скачать на компьютер)
5. Открыть репо любимом редакторе
6. Создать отдельную ветку под задачу
    - `git checkout -b новая_ветка main`
    - `git checkout -b andreibakhtinov/create-hello-file main`
7. Решаем задачу (вносим правки в проект)
8. Фиксация изменений
    - `git add .`
    - `git commit -m 'update'`
9. Выгрузить ветку (изменения) на GitHub
    - `git push -u origin ветка`
10. Оформить “заявку на улучшение” (Pull Request, PR, запрос на слияние)
11. **(доп/шаг)** Выгрузить изменения с GitHub себе на компьютер
    1. переключиться на `main`
    2. `git pull`

## Проверить работу коллеги

1. Найти ветку с работой коллеги
2. Выгрузить ветки на компьютер (синхронизация)
    - `git pull`
3. Переключиться на ветку коллеги
    - `git checkout origin/название_ветки_коллеги`

## Завершить работу коллеги

1. Найти ветку с работой коллеги
2. Выгрузить ветки на компьютер (синхронизация)
    - `git pull`
3. Создать свою ветку на основе коллеги
    - `git checkout -b НОВАЯ_ВЕТКА origin/название_ветки_коллеги`
4. Правки, коммит, выгрузка, PR