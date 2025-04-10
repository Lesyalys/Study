--5. Вывести список академиков, ФИО в формате Фамилия и Инициалы

SELECT 
    CONCAT(
        LEFT(A.ФИО, CHARINDEX(' ', A.ФИО) - 1), ' ',
        UPPER(SUBSTRING(A.ФИО, CHARINDEX(' ', A.ФИО) + 1, 1)), '. ',
        UPPER(SUBSTRING(
            A.ФИО, 
            CHARINDEX(' ', A.ФИО, CHARINDEX(' ', A.ФИО) + 1) + 1, 
            1
        )), '.'
    ) AS ФИО_форматированное
FROM 
    Академики AS A