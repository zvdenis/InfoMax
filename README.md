# Отборочное задание
Для подобных объемных файлов используют различные системы баз данных. Поэтому в моей реализации сделан упор на функциональности работы с XMl файлами а не на оптимизацию чтения и записи файла. (Можно было считывать файл не целиком, а по частям экономя память, но теряя при этом в функциональности). Для записи создан отдельный класс с методами equals и getHashCode. Количество записей считаем с помощью HashMap.

## Использование
Для добавления файлов в список для анализа их нужно разместить в папке filesToParse, после чего для каждого файла будет выполнено задание

## Резултаты
![res](https://github.com/zvdenis/InfoMax/blob/master/res.png)
