--6. ������� ��� ������ � ���������� �������� ������ ��� ������ � ���������� ��������?

SELECT 
MAX(C.�������) AS 'MAX'
,MIN(C.�������) AS 'MIN'
,CAST(MAX(C.�������) AS FLOAT) / NULLIF(MIN(C.�������),0) AS '�� ������� ��� ������'
FROM ������ AS C