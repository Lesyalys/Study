-- 7. Поиск контакта по имени/телефону/email
SELECT id, FIRST_NAME, LAST_NAME, EMAIL, NUMBER
FROM dbo.CONTACT
WHERE FIRST_NAME LIKE '%Иван%' 
   OR LAST_NAME LIKE '%Иванов%'
   OR EMAIL LIKE '%@gmail.com%'
   OR NUMBER LIKE '%123%';