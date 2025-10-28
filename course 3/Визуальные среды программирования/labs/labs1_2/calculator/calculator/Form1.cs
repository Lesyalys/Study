using System;
using System.Windows.Forms;

namespace calculator
{
    public partial class Form1 : Form
    {
        private double firstNumber = 0;
        private double secondNumber = 0;
        private string operation = "";
        private bool isOperationPressed = false;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // Инициализация при загрузке формы
            textBox1.Text = "0";
        }

        // Обработчики для цифровых кнопок 1-9
        private void button1_Click(object sender, EventArgs e)
        {
            NumberButtonClick("1");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            NumberButtonClick("2");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            NumberButtonClick("3");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            NumberButtonClick("4");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            NumberButtonClick("5");
        }

        private void button6_Click(object sender, EventArgs e)
        {
            NumberButtonClick("6");
        }

        private void button7_Click(object sender, EventArgs e)
        {
            NumberButtonClick("7");
        }

        private void button8_Click(object sender, EventArgs e)
        {
            NumberButtonClick("8");
        }

        private void button9_Click(object sender, EventArgs e)
        {
            NumberButtonClick("9");
        }

        // Кнопка 0 (button10)
        //private void button16_Click(object sender, EventArgs e)
        //{
        //    NumberButtonClick("0");
        //}

        // Общий метод для обработки цифровых кнопок
        private void NumberButtonClick(string number)
        {
            if (textBox1.Text == "0" || isOperationPressed)
            {
                textBox1.Text = number;
                isOperationPressed = false;
            }
            else
            {
                textBox1.Text += number;
            }

            // Обновляем отображение текущего выражения
            UpdateExpressionDisplay();
        }

        // Кнопки операций (11-14)
        private void button11_Click(object sender, EventArgs e) // +
        {
            OperationButtonClick("-");
        }

        private void button12_Click(object sender, EventArgs e) // -
        {
            OperationButtonClick("*");
        }

        private void button13_Click(object sender, EventArgs e) // ×
        {
            OperationButtonClick("/");
        }

        private void button14_Click(object sender, EventArgs e) // ÷
        {
            OperationButtonClick("%");
        }

        // Общий метод для обработки операций
        private void OperationButtonClick(string op)
        {
            if (!isOperationPressed)
            {
                firstNumber = double.Parse(textBox1.Text);
                operation = op;
                isOperationPressed = true;
                UpdateExpressionDisplay();
            }
        }

        // Кнопка равно (button15)
        private void button15_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(operation))
            {
                secondNumber = double.Parse(textBox1.Text);
                double result = 0;

                switch (operation)
                {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "×":
                        result = firstNumber * secondNumber;
                        break;
                    case "÷":
                        if (secondNumber != 0)
                            result = firstNumber / secondNumber;
                        else
                        {
                            textBox1.Text = "Ошибка";
                            label3.Text = "Деление на ноль!";
                            return;
                        }
                        break;
                }

                // Отображаем полное выражение и результат
                label3.Text = $"{firstNumber} {operation} {secondNumber} =";
                textBox1.Text = result.ToString();

                // Сбрасываем операцию для следующего вычисления
                operation = "";
                isOperationPressed = true;
            }
        }

        // Метод для обновления отображения текущего выражения
        private void UpdateExpressionDisplay()
        {
            if (!string.IsNullOrEmpty(operation))
            {
                label3.Text = $"{firstNumber} {operation}";
            }
            else
            {
                label3.Text = textBox1.Text;
            }
        }

        // Дополнительные методы (если нужны другие кнопки)
        private void label2_Click(object sender, EventArgs e)
        {
            // Метка 2
        }

        private void label3_Click(object sender, EventArgs e)
        {
            // Метка 3 - для отображения выражения
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            // Текстовое поле для ввода/вывода
        }

        // Добавим метод для кнопки очистки (если есть такая кнопка)
        private void ClearCalculator()
        {
            textBox1.Text = "0";
            firstNumber = 0;
            secondNumber = 0;
            operation = "";
            label3.Text = "";
            isOperationPressed = false;
        }

        private void button16_Click_1(object sender, EventArgs e)
        {
            NumberButtonClick("0");
        }

        private void button10_Click(object sender, EventArgs e)
        {
            OperationButtonClick("+");
        }

        private void button17_Click(object sender, EventArgs e)
        {
            textBox1.Text = "0";
            firstNumber = 0;
            secondNumber = 0;
            operation = "";
            label3.Text = "";
            isOperationPressed = false;
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
    }
}