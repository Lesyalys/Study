--1. ������� ����������� ������� �����
DECLARE @MIN FLOAT = 800

SELECT * 
FROM ������ AS C
WHERE C.������� <= @MIN
ORDER BY C.�������� ASC
