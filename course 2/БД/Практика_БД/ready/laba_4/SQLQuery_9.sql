--9. ������� ���������� ���� �� ����� ��������

DECLARE @DATENOW DATE
SET @DATENOW = GETDATE()

SELECT 
MAX(S.����) AS '��������� �������'
,DATEDIFF(DAY,MAX(S.����),@DATENOW) AS '�� ����� ��������'
FROM ������� AS S