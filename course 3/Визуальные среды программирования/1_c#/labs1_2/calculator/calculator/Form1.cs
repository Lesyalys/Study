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
            textBox1.Text = "0";
        }
        private void button1_Click(object sender, EventArgs e) => NumberButtonClick("1");
        private void button2_Click(object sender, EventArgs e) => NumberButtonClick("2");
        private void button3_Click(object sender, EventArgs e) => NumberButtonClick("3");
        private void button4_Click(object sender, EventArgs e) => NumberButtonClick("4");
        private void button5_Click(object sender, EventArgs e) => NumberButtonClick("5");
        private void button6_Click(object sender, EventArgs e) => NumberButtonClick("6");
        private void button7_Click(object sender, EventArgs e) => NumberButtonClick("7");
        private void button8_Click(object sender, EventArgs e) => NumberButtonClick("8");
        private void button9_Click(object sender, EventArgs e) => NumberButtonClick("9");
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
            UpdateExpressionDisplay();
        }
        private void button10_Click(object sender, EventArgs e)=>OperationButtonClick("+");
        private void button11_Click(object sender, EventArgs e)=>OperationButtonClick("-");
        private void button12_Click(object sender, EventArgs e)=>OperationButtonClick("×");
        private void button13_Click(object sender, EventArgs e) =>OperationButtonClick("/");
        private void button14_Click(object sender, EventArgs e) => OperationButtonClick("%");

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
                    case "/":
                        if (secondNumber != 0)
                            result = firstNumber / secondNumber;
                        else
                        {
                            textBox1.Text = "Ошибка";
                            label3.Text = "Деление на ноль!";
                            return;
                        }
                        break;
                    case "%":
                        result = firstNumber % secondNumber;
                        break;
                }

                label3.Text = $"{firstNumber} {operation} {secondNumber} =";
                textBox1.Text = result.ToString();

                operation = "";
                isOperationPressed = true;
            }
        }

        private void UpdateExpressionDisplay()
        {
            if (!string.IsNullOrEmpty(operation))
            {
                label3.Text = $"{firstNumber} {operation} {textBox1.Text}";
            }
            else
            {
                label3.Text = textBox1.Text;
            }
        }

        private void button16_Click_1(object sender, EventArgs e)
        {
            NumberButtonClick("0");
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

        private void label2_Click(object sender, EventArgs e) { }
        private void label3_Click(object sender, EventArgs e) { }
        private void textBox1_TextChanged(object sender, EventArgs e) { }
        private void label4_Click(object sender, EventArgs e) { }
    }
}