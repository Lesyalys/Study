-- 7. ����� �������� �� �����/��������/email
SELECT id, FIRST_NAME, LAST_NAME, EMAIL, NUMBER
FROM dbo.CONTACT
WHERE FIRST_NAME LIKE '%����%' 
   OR LAST_NAME LIKE '%������%'
   OR EMAIL LIKE '%@gmail.com%'
   OR NUMBER LIKE '%123%';