--3. ������� � ������� ��� ������� ���������� ����� � ������� ��� ����������������� ������������. 
--��� ���������� �������� ���� ������������ �������� ������


SELECT DISTINCT
    S1.���_�����
    ,S1.�������
    ,S1.���������
    ,S1.����
    ,S2.������� AS �������_�����������
	,S2.���������
FROM 
    (SELECT 
     S.���_�����,
     S.�������,
     S.���������,
     S.����
     FROM ��������� AS S
     WHERE S.��������� != '���.��������') AS S1
JOIN ��������� S2 ON S1.���� = S2.����
WHERE S2.��������� = '���.��������'