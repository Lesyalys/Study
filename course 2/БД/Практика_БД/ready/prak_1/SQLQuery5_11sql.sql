--������ � ������� �� ������� � ����������� �� �������� ������ �� �����, 
--� ����� ����������� ����, ����������� ��� ���� ������� ���������, ������������ ��� ��������������� �������; 

DECLARE @CONST INT = 1;

SELECT *
,CASE
	WHEN FIO IS NOT NULL THEN @CONST
	END AS 'CONST'
FROM ������_�������
WHERE FIO LIKE '�%'
ORDER BY FIO DESC