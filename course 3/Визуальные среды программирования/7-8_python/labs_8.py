import matplotlib.pyplot as plt
import numpy as np
import random

def labs8_1():
    xpoints = np.array([0,6])
    ypoints = np.array([0,250])
    plt.plot(xpoints, ypoints)
    plt.show()

def labs8_2():
    min = int(input('min : '))
    max = int(input('max : '))
    minLimit = int(input('minLimit : '))
    maxLimit = int(input('maxLimit : '))
    arrays = [[random.randint(minLimit,maxLimit) for _ in range(min)] for _ in range(max)]
    # for row in arrays:
    #     print(row)
    return arrays

def selection_sort(row):
    n = len(row)
    for i in range(n):
        minIndex = i
        for j in range(i+1,n):
            if row[j] < row[minIndex]:
                minIndex = j
        row[i],row[minIndex] = row[minIndex],row[i]
    return row
def labs8_3():
    #Реализовать методы сортировки строк числовой матрицы в соответствии с заданием:1.  Выбором
    arrays = labs8_2()
    sorted = []
    for i in arrays:
        sortedrows = selection_sort(i.copy())
        sorted.append(sortedrows)

    print("Sorted arrays:")
    for row in sorted:
        print(row)
    return 0
labs8_3()

def labs8_4():
    # 1.	Эллипса, по формуле, где пользователь вводит не нулевые значения a и b: x2 / a2 + y2 / b2 = 1
    a = int(input('a = '))
    b = int(input('b = '))
    if a > 0 and b > 0:
        t = np.linspace(0, 2 * np.pi, 1000)
        x = a * np.cos(t)
        y = b * np.sin(t)
        plt.title(f'Эллипс: x²/{a}²+y²/{b}²=1')
        plt.plot(x, y)
        plt.axis('equal') #одинаковый масштаб по осям
        plt.show()
    else:
        print("argument need > 0")
        return 0

