--5. ������� ������ ��������� � ���������, ������� 20000 ���

SELECT *
FROM (
	SELECT S.�������
	,S.���������
	,S.��������
	FROM ��������� AS S
	WHERE S.��������� = '�������') AS S1
WHERE S1.�������� < 20000
